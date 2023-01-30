package b4a.dictionaries;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class edit_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (edit) ","edit",6,edit.mostCurrent.activityBA,edit.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) { return b4a.dictionaries.edit.remoteMe.runUserSub(false, "edit","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"EditPage\")";
Debug.ShouldStop(536870912);
edit.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("EditPage")),edit.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (edit) ","edit",6,edit.mostCurrent.activityBA,edit.mostCurrent,37);
if (RapidSub.canDelegate("activity_pause")) { return b4a.dictionaries.edit.remoteMe.runUserSub(false, "edit","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (edit) ","edit",6,edit.mostCurrent.activityBA,edit.mostCurrent,33);
if (RapidSub.canDelegate("activity_resume")) { return b4a.dictionaries.edit.remoteMe.runUserSub(false, "edit","activity_resume");}
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("BackBtn_Click (edit) ","edit",6,edit.mostCurrent.activityBA,edit.mostCurrent,40);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.dictionaries.edit.remoteMe.runUserSub(false, "edit","backbtn_click");}
 BA.debugLineNum = 40;BA.debugLine="Sub BackBtn_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="StartActivity(Manage)";
Debug.ShouldStop(256);
edit.mostCurrent.__c.runVoidMethod ("StartActivity",edit.processBA,(Object)((edit.mostCurrent._manage.getObject())));
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _deletebtn_click() throws Exception{
try {
		Debug.PushSubsStack("DeleteBtn_Click (edit) ","edit",6,edit.mostCurrent.activityBA,edit.mostCurrent,59);
if (RapidSub.canDelegate("deletebtn_click")) { return b4a.dictionaries.edit.remoteMe.runUserSub(false, "edit","deletebtn_click");}
RemoteObject _id = RemoteObject.createImmutable("");
 BA.debugLineNum = 59;BA.debugLine="Private Sub DeleteBtn_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="If IdShow.Text.Trim == \"\" Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",edit.mostCurrent._idshow.runMethod(true,"getText").runMethod(true,"trim"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 61;BA.debugLine="ToastMessageShow(\"Show Text must have Word!\",Tru";
Debug.ShouldStop(268435456);
edit.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Show Text must have Word!")),(Object)(edit.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 63;BA.debugLine="Dim id As String = \"{\"\"id\"\": \"\"\" & IdShow.Text &";
Debug.ShouldStop(1073741824);
_id = RemoteObject.concat(RemoteObject.createImmutable("{\"id\": \""),edit.mostCurrent._idshow.runMethod(true,"getText"),RemoteObject.createImmutable("\"}"));Debug.locals.put("id", _id);Debug.locals.put("id", _id);
 BA.debugLineNum = 64;BA.debugLine="job3.Initialize(\"Job3\", Me)";
Debug.ShouldStop(-2147483648);
edit.mostCurrent._job3.runClassMethod (b4a.dictionaries.httpjob.class, "_initialize" /*RemoteObject*/ ,edit.processBA,(Object)(BA.ObjectToString("Job3")),(Object)(edit.getObject()));
 BA.debugLineNum = 65;BA.debugLine="job3.PostString(\"http://192.168.100.8:3000/delet";
Debug.ShouldStop(1);
edit.mostCurrent._job3.runClassMethod (b4a.dictionaries.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("http://192.168.100.8:3000/delete")),(Object)(_id));
 BA.debugLineNum = 66;BA.debugLine="job3.GetRequest.SetContentType(\"application/json";
Debug.ShouldStop(2);
edit.mostCurrent._job3.runClassMethod (b4a.dictionaries.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 };
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim BackBtn As Button";
edit.mostCurrent._backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim SearchBtn As Button";
edit.mostCurrent._searchbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim SaveBtn As Button";
edit.mostCurrent._savebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim DeleteBtn As Button";
edit.mostCurrent._deletebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim WordTxt As EditText";
edit.mostCurrent._wordtxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim ShowTxt As EditText";
edit.mostCurrent._showtxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim job1 As HttpJob";
edit.mostCurrent._job1 = RemoteObject.createNew ("b4a.dictionaries.httpjob");
 //BA.debugLineNum = 22;BA.debugLine="Dim job2 As HttpJob";
edit.mostCurrent._job2 = RemoteObject.createNew ("b4a.dictionaries.httpjob");
 //BA.debugLineNum = 23;BA.debugLine="Dim job3 As HttpJob";
edit.mostCurrent._job3 = RemoteObject.createNew ("b4a.dictionaries.httpjob");
 //BA.debugLineNum = 24;BA.debugLine="Dim IdShow As Label";
edit.mostCurrent._idshow = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (edit) ","edit",6,edit.mostCurrent.activityBA,edit.mostCurrent,69);
if (RapidSub.canDelegate("jobdone")) { return b4a.dictionaries.edit.remoteMe.runUserSub(false, "edit","jobdone", _job);}
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("job", _job);
 BA.debugLineNum = 69;BA.debugLine="Sub JobDone (job As HttpJob)";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="Select job";
Debug.ShouldStop(32);
switch (BA.switchObjectToInt(_job,edit.mostCurrent._job1,edit.mostCurrent._job2,edit.mostCurrent._job3)) {
case 0: {
 BA.debugLineNum = 72;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),edit.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 73;BA.debugLine="Dim res As String = job.GetString";
Debug.ShouldStop(256);
_res = _job.runClassMethod (b4a.dictionaries.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 74;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(512);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 75;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(1024);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 76;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(2048);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 77;BA.debugLine="If root.Get(\"success\") = True Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("success")))),(edit.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 78;BA.debugLine="ShowTxt.Text = root.Get(\"word\")";
Debug.ShouldStop(8192);
edit.mostCurrent._showtxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("word"))))));
 BA.debugLineNum = 79;BA.debugLine="ShowTxt.Enabled = True";
Debug.ShouldStop(16384);
edit.mostCurrent._showtxt.runMethod(true,"setEnabled",edit.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 80;BA.debugLine="IdShow.Text = root.Get(\"id\")";
Debug.ShouldStop(32768);
edit.mostCurrent._idshow.runMethod(true,"setText",BA.ObjectToCharSequence(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 81;BA.debugLine="WordTxt.Text = \"\"";
Debug.ShouldStop(65536);
edit.mostCurrent._wordtxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 }else 
{ BA.debugLineNum = 82;BA.debugLine="Else If root.Get(\"success\") = False Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("success")))),(edit.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 83;BA.debugLine="ToastMessageShow(\"Word not found!: \", True)";
Debug.ShouldStop(262144);
edit.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Word not found!: ")),(Object)(edit.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 85;BA.debugLine="ToastMessageShow(\"Search failed: \" & root.Get";
Debug.ShouldStop(1048576);
edit.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Search failed: "),_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("message"))))))),(Object)(edit.mostCurrent.__c.getField(true,"True")));
 }}
;
 }else {
 BA.debugLineNum = 88;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage,";
Debug.ShouldStop(8388608);
edit.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(edit.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 90;BA.debugLine="job1.Release";
Debug.ShouldStop(33554432);
edit.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_release" /*RemoteObject*/ );
 break; }
case 1: {
 BA.debugLineNum = 92;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),edit.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 93;BA.debugLine="Dim res As String = job.GetString";
Debug.ShouldStop(268435456);
_res = _job.runClassMethod (b4a.dictionaries.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 94;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(536870912);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 95;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(1073741824);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 96;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(-2147483648);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 97;BA.debugLine="If root.Get(\"success\") = True Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("success")))),(edit.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 98;BA.debugLine="ToastMessageShow(\"Word save! \", True)";
Debug.ShouldStop(2);
edit.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Word save! ")),(Object)(edit.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 99;BA.debugLine="ShowTxt.Text = \"\"";
Debug.ShouldStop(4);
edit.mostCurrent._showtxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 100;BA.debugLine="ShowTxt.Enabled = False";
Debug.ShouldStop(8);
edit.mostCurrent._showtxt.runMethod(true,"setEnabled",edit.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 101;BA.debugLine="IdShow.Text = \"\"";
Debug.ShouldStop(16);
edit.mostCurrent._idshow.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 }else {
 BA.debugLineNum = 103;BA.debugLine="ToastMessageShow(\"Save failed: \" & root.Get(\"";
Debug.ShouldStop(64);
edit.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Save failed: "),_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("message"))))))),(Object)(edit.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 106;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage,";
Debug.ShouldStop(512);
edit.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(edit.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 108;BA.debugLine="job2.Release";
Debug.ShouldStop(2048);
edit.mostCurrent._job2.runClassMethod (b4a.dictionaries.httpjob.class, "_release" /*RemoteObject*/ );
 break; }
case 2: {
 BA.debugLineNum = 110;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),edit.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 111;BA.debugLine="Dim res As String = job.GetString";
Debug.ShouldStop(16384);
_res = _job.runClassMethod (b4a.dictionaries.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 112;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(32768);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 113;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(65536);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 114;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(131072);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 115;BA.debugLine="If root.Get(\"success\") = True Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("success")))),(edit.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 116;BA.debugLine="ToastMessageShow(\"Delete Success! \", True)";
Debug.ShouldStop(524288);
edit.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Delete Success! ")),(Object)(edit.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 117;BA.debugLine="ShowTxt.Text = \"\"";
Debug.ShouldStop(1048576);
edit.mostCurrent._showtxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 118;BA.debugLine="ShowTxt.Enabled = False";
Debug.ShouldStop(2097152);
edit.mostCurrent._showtxt.runMethod(true,"setEnabled",edit.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 119;BA.debugLine="IdShow.Text = \"\"";
Debug.ShouldStop(4194304);
edit.mostCurrent._idshow.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 }else {
 BA.debugLineNum = 121;BA.debugLine="ToastMessageShow(\"Delete failed: \" & root.Get";
Debug.ShouldStop(16777216);
edit.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Delete failed: "),_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("message"))))))),(Object)(edit.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 124;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage,";
Debug.ShouldStop(134217728);
edit.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(edit.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 126;BA.debugLine="job3.Release";
Debug.ShouldStop(536870912);
edit.mostCurrent._job3.runClassMethod (b4a.dictionaries.httpjob.class, "_release" /*RemoteObject*/ );
 break; }
}
;
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _savebtn_click() throws Exception{
try {
		Debug.PushSubsStack("SaveBtn_Click (edit) ","edit",6,edit.mostCurrent.activityBA,edit.mostCurrent,49);
if (RapidSub.canDelegate("savebtn_click")) { return b4a.dictionaries.edit.remoteMe.runUserSub(false, "edit","savebtn_click");}
RemoteObject _word = RemoteObject.createImmutable("");
 BA.debugLineNum = 49;BA.debugLine="Private Sub SaveBtn_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="If ShowTxt.Text.Trim == \"\" Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",edit.mostCurrent._showtxt.runMethod(true,"getText").runMethod(true,"trim"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 51;BA.debugLine="ToastMessageShow(\"Show Text must have Word!\",Tru";
Debug.ShouldStop(262144);
edit.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Show Text must have Word!")),(Object)(edit.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 53;BA.debugLine="Dim Word As String = \"{ \"\"id\"\": \"\"\" &IdShow.Text";
Debug.ShouldStop(1048576);
_word = RemoteObject.concat(RemoteObject.createImmutable("{ \"id\": \""),edit.mostCurrent._idshow.runMethod(true,"getText"),RemoteObject.createImmutable("\", \"word\": \""),edit.mostCurrent._showtxt.runMethod(true,"getText"),RemoteObject.createImmutable("\" }"));Debug.locals.put("Word", _word);Debug.locals.put("Word", _word);
 BA.debugLineNum = 54;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(2097152);
edit.mostCurrent._job2.runClassMethod (b4a.dictionaries.httpjob.class, "_initialize" /*RemoteObject*/ ,edit.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(edit.getObject()));
 BA.debugLineNum = 55;BA.debugLine="job2.PostString(\"http://192.168.100.8:3000/edit\"";
Debug.ShouldStop(4194304);
edit.mostCurrent._job2.runClassMethod (b4a.dictionaries.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("http://192.168.100.8:3000/edit")),(Object)(_word));
 BA.debugLineNum = 56;BA.debugLine="job2.GetRequest.SetContentType(\"application/json";
Debug.ShouldStop(8388608);
edit.mostCurrent._job2.runClassMethod (b4a.dictionaries.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 };
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _searchbtn_click() throws Exception{
try {
		Debug.PushSubsStack("SearchBtn_Click (edit) ","edit",6,edit.mostCurrent.activityBA,edit.mostCurrent,43);
if (RapidSub.canDelegate("searchbtn_click")) { return b4a.dictionaries.edit.remoteMe.runUserSub(false, "edit","searchbtn_click");}
RemoteObject _word = RemoteObject.createImmutable("");
 BA.debugLineNum = 43;BA.debugLine="Private Sub SearchBtn_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="Dim Word As String = \"{\"\"Word\"\": \"\"\" & WordTxt.Te";
Debug.ShouldStop(2048);
_word = RemoteObject.concat(RemoteObject.createImmutable("{\"Word\": \""),edit.mostCurrent._wordtxt.runMethod(true,"getText"),RemoteObject.createImmutable("\"}"));Debug.locals.put("Word", _word);Debug.locals.put("Word", _word);
 BA.debugLineNum = 45;BA.debugLine="job1.Initialize(\"Job1\", Me)";
Debug.ShouldStop(4096);
edit.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_initialize" /*RemoteObject*/ ,edit.processBA,(Object)(BA.ObjectToString("Job1")),(Object)(edit.getObject()));
 BA.debugLineNum = 46;BA.debugLine="job1.PostString(\"http://192.168.100.8:3000/search";
Debug.ShouldStop(8192);
edit.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("http://192.168.100.8:3000/searchadmin")),(Object)(_word));
 BA.debugLineNum = 47;BA.debugLine="job1.GetRequest.SetContentType(\"application/json\"";
Debug.ShouldStop(16384);
edit.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}