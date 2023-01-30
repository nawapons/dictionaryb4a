B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.2
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim BackBtn As Button
	Dim SearchBtn As Button
	Dim SaveBtn As Button
	Dim DeleteBtn As Button
	Dim WordTxt As EditText
	Dim ShowTxt As EditText
	Dim job1 As HttpJob
	Dim job2 As HttpJob
	Dim job3 As HttpJob
	Dim IdShow As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("EditPage")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub BackBtn_Click
	StartActivity(Manage)
End Sub
Private Sub SearchBtn_Click
	Dim Word As String = "{""Word"": """ & WordTxt.Text & """}"
	job1.Initialize("Job1", Me)
	job1.PostString("http://192.168.100.8:3000/searchadmin", Word)
	job1.GetRequest.SetContentType("application/json")
End Sub
Private Sub SaveBtn_Click
	If ShowTxt.Text.Trim == "" Then
		ToastMessageShow("Show Text must have Word!",True)
	Else
		Dim Word As String = "{ ""id"": """ &IdShow.Text & """, ""word"": """ & ShowTxt.Text & """ }"
		job2.Initialize("Job2", Me)
		job2.PostString("http://192.168.100.8:3000/edit", Word)
		job2.GetRequest.SetContentType("application/json")
	End If
End Sub
Private Sub DeleteBtn_Click
	If IdShow.Text.Trim == "" Then
		ToastMessageShow("Show Text must have Word!",True)
	Else
		Dim id As String = "{""id"": """ & IdShow.Text & """}"
		job3.Initialize("Job3", Me)
		job3.PostString("http://192.168.100.8:3000/delete", id)
		job3.GetRequest.SetContentType("application/json")
	End If
End Sub
Sub JobDone (job As HttpJob)
Select job
		Case job1
			If job.Success = True Then
				Dim res As String = job.GetString
				Dim parser As JSONParser
				parser.Initialize(res)
				Dim root As Map = parser.NextObject
				If root.Get("success") = True Then
					ShowTxt.Text = root.Get("word")
					ShowTxt.Enabled = True
					IdShow.Text = root.Get("id")
					WordTxt.Text = ""
				Else If root.Get("success") = False Then
					ToastMessageShow("Word not found!: ", True)
				Else
					ToastMessageShow("Search failed: " & root.Get("message"), True)
				End If
			Else
				ToastMessageShow("Error: " & job.ErrorMessage, True)
			End If
			job1.Release
		Case job2
			If job.Success = True Then
				Dim res As String = job.GetString
				Dim parser As JSONParser
				parser.Initialize(res)
				Dim root As Map = parser.NextObject
				If root.Get("success") = True Then
					ToastMessageShow("Word save! ", True)
					ShowTxt.Text = ""
					ShowTxt.Enabled = False
					IdShow.Text = ""
				Else
					ToastMessageShow("Save failed: " & root.Get("message"), True)
				End If
			Else
				ToastMessageShow("Error: " & job.ErrorMessage, True)
			End If
			job2.Release
		Case job3
			If job.Success = True Then
				Dim res As String = job.GetString
				Dim parser As JSONParser
				parser.Initialize(res)
				Dim root As Map = parser.NextObject
				If root.Get("success") = True Then
					ToastMessageShow("Delete Success! ", True)
					ShowTxt.Text = ""
					ShowTxt.Enabled = False
					IdShow.Text = ""
				Else
					ToastMessageShow("Delete failed: " & root.Get("message"), True)
				End If
			Else
				ToastMessageShow("Error: " & job.ErrorMessage, True)
			End If
			job3.Release
End Select
End Sub
