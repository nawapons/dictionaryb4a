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
	Dim job1 As HttpJob
	Dim LoginBtn As Button
	Dim UsernameTxt As EditText
	Dim PasswordTxt As EditText
	Dim BackBtn As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("LoginPage")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Private Sub BackBtn_Click
	StartActivity("Main")
End Sub
Private Sub LoginBtn_Click
	Dim json As String = "{ ""username"": """ &UsernameTxt.Text & """, ""password"": """ & PasswordTxt.Text & """ }"
	job1.Initialize("Job1", Me)
	job1.PostString("http://192.168.100.8:3000/login", json)
	job1.GetRequest.SetContentType("application/json")
End Sub

Sub JobDone (job As HttpJob)
	If job.Success = True Then
		Dim res As String = job.GetString
		Dim parser As JSONParser
		parser.Initialize(res)
		Dim root As Map = parser.NextObject
		If root.Get("success") = True Then
			ToastMessageShow("Login successful", True)
			StartActivity(Manage)
		Else
			ToastMessageShow("Login failed: " & root.Get("message"), True)
		End If
	Else
		ToastMessageShow("Error: " & job.ErrorMessage, True)
	End If
	job.Release
End Sub
