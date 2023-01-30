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
	Dim WordTxt As EditText
	Dim AddBtn As Button
	Dim job1 As HttpJob
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("AddPage")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub BackBtn_Click
	StartActivity(Manage)
End Sub
Private Sub AddBtn_Click
	Dim Word As String = "{""Word"": """ & WordTxt.Text & """}"
	job1.Initialize("Job1", Me)
	job1.PostString("http://192.168.100.8:3000/add", Word)
	job1.GetRequest.SetContentType("application/json")
End Sub
Sub JobDone (job As HttpJob)
	If job.Success = True Then
		Dim res As String = job.GetString
		Dim parser As JSONParser
		parser.Initialize(res)
		Dim root As Map = parser.NextObject
		If root.Get("success") = True Then
			ToastMessageShow("Add Word successful", True)
		Else If root.Get("success") = False Then
			ToastMessageShow("Word Already Exist: ", True)
		Else
			ToastMessageShow("Add failed: " & root.Get("message"), True)
		End If
	Else
		ToastMessageShow("Error: " & job.ErrorMessage, True)
	End If
	job.Release
End Sub
