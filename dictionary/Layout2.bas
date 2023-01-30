B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.2
@EndOfDesignText@
#Region Module Attributes
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
	Dim searchTxt As EditText
	Dim searchBtn As Button
	Dim scrollView1 As ScrollView
	Dim j As HttpJob
	Dim BackBtn As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("SearchLayout")
End Sub

Sub Activity_Resume

End Sub
Sub Activity_Pause (UserClosed As Boolean)
	CallSub(ImageDownloader, "ActivityIsPaused")
End Sub
Private Sub SearchBtn_Click
	Dim searchWord As String = searchTxt.Text
	job1.Initialize("job1", Me)
	job1.PostString("http://192.168.100.8:3000/search/" & searchWord,"")
	job1.GetRequest.SetContentType("application/json")
End Sub
Private Sub BackBtn_Click 
	StartActivity(Main)
End Sub
Sub JobDone (job As HttpJob)
	If job.Success = True Then
		Select job.JobName
			Case "job1"
				Log(job.GetString)
				Dim res As String = job.GetString
				Dim parser As JSONParser
				parser.Initialize(res)
				Dim root As Map = parser.NextObject
				Dim result As List = root.Get("result")
				Dim allUrls As List = root.Get("allUrls")
				j.Initialize("",Me)
				scrollView1.Panel.RemoveAllViews
				scrollView1.Panel.Height = 0
				Dim urlIndex As Int = 0
				For Each getWord As Map In result
					Dim WordLabel As Label
					WordLabel.Initialize("")
					WordLabel.Text = getWord.Get("word")
					scrollView1.Panel.AddView(WordLabel, 0, scrollView1.Panel.Height, scrollView1.Width, 50dip)
					scrollView1.Panel.Height = scrollView1.Panel.Height + 50dip
					
					Dim ImageView1 As ImageView
					ImageView1.Initialize("")
					Dim links As Map
					links.Initialize
					Try
						links.Put(ImageView1,allUrls.Get(urlIndex))
						CallSubDelayed2(ImageDownloader, "Download", links)
					Catch
						Log(LastException.Message)
					End Try
					scrollView1.Panel.AddView(ImageView1, 0, scrollView1.Panel.Height, scrollView1.Width, 100dip)
					scrollView1.Panel.Height = scrollView1.Panel.Height + 100dip
					urlIndex = urlIndex + 1
				Next
		End Select
	Else
		Log("Error: " & job.ErrorMessage)
	End If
	job.Release
End Sub
