package b4a.dictionaries;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class add_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (add) ","add",5,add.mostCurrent.activityBA,add.mostCurrent,21);
if (RapidSub.canDelegate("activity_create")) { return b4a.dictionaries.add.remoteMe.runUserSub(false, "add","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 21;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 24;BA.debugLine="Activity.LoadLayout(\"AddPage\")";
Debug.ShouldStop(8388608);
add.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("AddPage")),add.mostCurrent.activityBA);
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (add) ","add",5,add.mostCurrent.activityBA,add.mostCurrent,31);
if (RapidSub.canDelegate("activity_pause")) { return b4a.dictionaries.add.remoteMe.runUserSub(false, "add","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Resume (add) ","add",5,add.mostCurrent.activityBA,add.mostCurrent,27);
if (RapidSub.canDelegate("activity_resume")) { return b4a.dictionaries.add.remoteMe.runUserSub(false, "add","activity_resume");}
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addbtn_click() throws Exception{
try {
		Debug.PushSubsStack("AddBtn_Click (add) ","add",5,add.mostCurrent.activityBA,add.mostCurrent,37);
if (RapidSub.canDelegate("addbtn_click")) { return b4a.dictionaries.add.remoteMe.runUserSub(false, "add","addbtn_click");}
RemoteObject _word = RemoteObject.createImmutable("");
 BA.debugLineNum = 37;BA.debugLine="Private Sub AddBtn_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="Dim Word As String = \"{\"\"Word\"\": \"\"\" & WordTxt.Te";
Debug.ShouldStop(32);
_word = RemoteObject.concat(RemoteObject.createImmutable("{\"Word\": \""),add.mostCurrent._wordtxt.runMethod(true,"getText"),RemoteObject.createImmutable("\"}"));Debug.locals.put("Word", _word);Debug.locals.put("Word", _word);
 BA.debugLineNum = 39;BA.debugLine="job1.Initialize(\"Job1\", Me)";
Debug.ShouldStop(64);
add.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_initialize" /*RemoteObject*/ ,add.processBA,(Object)(BA.ObjectToString("Job1")),(Object)(add.getObject()));
 BA.debugLineNum = 40;BA.debugLine="job1.PostString(\"http://192.168.100.8:3000/add\",";
Debug.ShouldStop(128);
add.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("http://192.168.100.8:3000/add")),(Object)(_word));
 BA.debugLineNum = 41;BA.debugLine="job1.GetRequest.SetContentType(\"application/json\"";
Debug.ShouldStop(256);
add.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
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
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("BackBtn_Click (add) ","add",5,add.mostCurrent.activityBA,add.mostCurrent,34);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.dictionaries.add.remoteMe.runUserSub(false, "add","backbtn_click");}
 BA.debugLineNum = 34;BA.debugLine="Sub BackBtn_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="StartActivity(Manage)";
Debug.ShouldStop(4);
add.mostCurrent.__c.runVoidMethod ("StartActivity",add.processBA,(Object)((add.mostCurrent._manage.getObject())));
 BA.debugLineNum = 36;BA.debugLine="End Sub";
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
add.mostCurrent._backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim WordTxt As EditText";
add.mostCurrent._wordtxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim AddBtn As Button";
add.mostCurrent._addbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim job1 As HttpJob";
add.mostCurrent._job1 = RemoteObject.createNew ("b4a.dictionaries.httpjob");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (add) ","add",5,add.mostCurrent.activityBA,add.mostCurrent,43);
if (RapidSub.canDelegate("jobdone")) { return b4a.dictionaries.add.remoteMe.runUserSub(false, "add","jobdone", _job);}
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("job", _job);
 BA.debugLineNum = 43;BA.debugLine="Sub JobDone (job As HttpJob)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),add.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 45;BA.debugLine="Dim res As String = job.GetString";
Debug.ShouldStop(4096);
_res = _job.runClassMethod (b4a.dictionaries.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 46;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(8192);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 47;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(16384);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 48;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(32768);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 49;BA.debugLine="If root.Get(\"success\") = True Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("success")))),(add.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 50;BA.debugLine="ToastMessageShow(\"Add Word successful\", True)";
Debug.ShouldStop(131072);
add.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Add Word successful")),(Object)(add.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 51;BA.debugLine="Else If root.Get(\"success\") = False Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("success")))),(add.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 52;BA.debugLine="ToastMessageShow(\"Word Already Exist: \", True)";
Debug.ShouldStop(524288);
add.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Word Already Exist: ")),(Object)(add.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 54;BA.debugLine="ToastMessageShow(\"Add failed: \" & root.Get(\"mes";
Debug.ShouldStop(2097152);
add.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Add failed: "),_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("message"))))))),(Object)(add.mostCurrent.__c.getField(true,"True")));
 }}
;
 }else {
 BA.debugLineNum = 57;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(16777216);
add.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(add.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 59;BA.debugLine="job.Release";
Debug.ShouldStop(67108864);
_job.runClassMethod (b4a.dictionaries.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
}