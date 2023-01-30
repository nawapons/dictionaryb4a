# B4A Dictionary App
A simple dictionary app built with B4A that connects to a Node.js server and a MySQL database.

## Features
 - Search for words in the dictionary database
 - Display definitions for selected words
 - Add new words and definitions to the database
 - Edit and delete existing words and definitions

## Prerequisites
 - Basic knowledge of B4A
 - A working Node.js server
 - A MySQL database setup and configured
 - An understanding of RESTful API principles
 - Getting Started
 
## Getting Started
  1. Clone the repository:
 ```$ git clone https://github.com/nawapons/dictionaryb4a.git ```
  2. Open the api folder in Vscode and edit the following variables in the Main module:
 ```host - The URL of your mysql server
username - The username for your MySQL database
password - The password for your MySQL database
database - The name of your MySQL database 
```
  3. In the Node.js server, run the following commands to start the server:
 ```$ npm install
$ npm run dev
```
 4. Build and run the B4A app on your device or emulator.

## About API_KEY
 I use api from pixabay to generate pictures from dictionary words so you must register in website pixabay and get api key
 then put it to server.js

## Contributing
If you would like to contribute to this project, please create a pull request.

## Screenshots

![Screenshot_2023-01-30-19-48-23-437_b4a dictionaries](https://user-images.githubusercontent.com/88156106/215483018-ec7052bb-1300-46da-994c-db18f4701e32.jpg)

![Screenshot_2023-01-30-19-48-35-907_b4a dictionaries](https://user-images.githubusercontent.com/88156106/215483080-08e42379-12d4-4868-aac6-61a5cf5bf01f.jpg)

![Screenshot_2023-01-30-19-48-41-093_b4a dictionaries](https://user-images.githubusercontent.com/88156106/215483114-37667843-f02f-4ed6-92a4-fad081c4fb17.jpg)

![Screenshot_2023-01-30-19-48-50-360_b4a dictionaries](https://user-images.githubusercontent.com/88156106/215483155-86a67026-4a12-4fef-be18-9860f9668579.jpg)


