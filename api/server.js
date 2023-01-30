const express = require('express')
const mysql = require('mysql2')
const cors = require('cors')
const app = express()
const axios = require('axios');
const bodyParser = require('body-parser');
app.use(express.json())
app.use(cors())

// SQL CONNECTION
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'dictionary'
});

connection.connect((err) => {
    if (err) {
        console.log('Error connecting to MySQL Database', err);
        return;
    }
    console.log('Connecting to MySQL Database successfully')
})

app.use(bodyParser.json());
// API Search Photos
async function searchImages(keyword) {
    try {
        const API_KEY = 'get-api-key';
        const response = await axios.get(`https://pixabay.com/api/?key=${API_KEY}&q=${encodeURIComponent(keyword)}`);
        // do something with the response
        const firstPhotoUrl = response.data.hits[1].previewURL;
        return firstPhotoUrl
    } catch (error) {
        // handle the error
        console.log(error);
    }
}

// Create routes
app.get("/read", async (req, res) => {
    try {
        await connection.query("SELECT * FROM tbl_words", (err, result) => {
            if (err) {
                console.log(err);
                return res.status(400).send();
            }
            res.status(200).send(result);
        })
    } catch (err) {
        console.log(err);
        return res.status(500).send();
    }
})
app.post('/search/:search', (req, res) => {
    const { search } = req.params;
    try {
        connection.query("SELECT * FROM tbl_words WHERE word LIKE ?", [`%${search}%`], async (err, result) => {
            if (err) {
                console.log(err);
                return res.status(400).send();
            }
            if (result.length > 0) {
                let allUrls = [];
                for (let i = 0; i < result.length; i++) {
                    const keyword = result[i].word;
                    const photoUrl = await searchImages(keyword);
                    allUrls.push(photoUrl);
                }
                res.status(200).send({ result, allUrls });
                console.log(result, allUrls);
            }
        })
    } catch (err) {
        console.log(err);
        return res.status(500).send();
    }
})
app.post('/login', (req, res) => {
    const { username, password } = req.body;
    try {
        connection.query("SELECT * FROM tbl_admin WHERE username = ? AND password = ?", [username, password], async (err, result) => {
            if (err) {
                console.log(err);
                return res.status(400).send({ success: false, message: "Bad request" });
            }
            if (result.length > 0) {
                res.status(200).send({ success: true, message: "Login successful" });
            } else {
                res.status(200).send({ success: false, message: "Login failed" });
            }
        })
    } catch (err) {
        console.log(err);
        return res.status(500).send({ success: false, message: "Internal server error" });
    }
})
app.post('/add', (req, res) => {
    const word = req.body.Word;
    try {
        connection.query("SELECT * FROM tbl_words WHERE word = ? ", [word], async (err, result) => {
            if (err) {
                return res.status(400).send({ success: false, message: "Bad request" });
            }
            if (result.length > 0) {
                res.status(200).send({ success: false, message: "Add failed" });
            } else {
                connection.query("INSERT INTO tbl_words (word) VALUE (?)", [word], async (err2, result2) => {
                    if (err2) {
                        console.log(err2);
                        return res.status(400).send({ success: false, message: "Bad request" });
                    }
                    res.status(200).send({ success: true, message: "Add success" });
                })
            }
        })
    } catch (err) {
        console.log(err);
        return res.status(500).send({ success: false, message: "Internal server error" });
    }
})
app.post('/searchadmin', (req, res) => {
    const word = req.body.Word;
    try {
        connection.query("SELECT * FROM tbl_words WHERE word = ? LIMIT 1", [word], async (err, result) => {
            if (err) {
                return res.status(400).send({ success: false, message: "Bad request" });
            }
            if (result.length > 0) {
                res.status(200).send({ success: true, word: result[0].word, id: result[0].id });
            } else {
                res.status(200).send({ success: false, message: "search failed" });
            }
        })
    } catch (err) {
        console.log(err);
        return res.status(500).send({ success: false, message: "Internal server error" });
    }
})
app.post('/edit', (req, res) => {
    const word = req.body.word;
    const id = req.body.id;
    try {
        connection.query("UPDATE tbl_words SET word = ? WHERE id = ? ", [word,id], async (err, result) => {
            if (err) {
                return res.status(400).send({ success: false, message: "Bad request" });
            }
            res.status(200).send({ success: true, message: "save success" });
        })
    } catch (err) {
        console.log(err);
        return res.status(500).send({ success: false, message: "Internal server error" });
    }
})
app.post('/delete',(req,res)=>{
    const id = req.body.id;
    try {
        connection.query("DELETE FROM tbl_words WHERE id = ? ", [id], async (err, result) => {
            if (err) {
                return res.status(400).send({ success: false, message: "Bad request" });
            }
            res.status(200).send({ success: true, message: "Delete success" });
        })
    } catch (err) {
        console.log(err);
        return res.status(500).send({ success: false, message: "Internal server error" });
    }
})
app.listen(3000, () => console.log('server listening on port 3000'));