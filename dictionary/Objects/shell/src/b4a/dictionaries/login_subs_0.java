package b4a.dictionaries;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class login_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (login) ","login",3,login.mostCurrent.activityBA,login.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return b4a.dictionaries.login.remoteMe.runUserSub(false, "login","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"LoginPage\")";
Debug.ShouldStop(16777216);
login.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LoginPage")),login.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Activity_Pause (login) ","login",3,login.mostCurrent.activityBA,login.mostCurrent,32);
if (RapidSub.canDelegate("activity_pause")) { return b4a.dictionaries.login.remoteMe.runUserSub(false, "login","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Activity_Resume (login) ","login",3,login.mostCurrent.activityBA,login.mostCurrent,28);
if (RapidSub.canDelegate("activity_resume")) { return b4a.dictionaries.login.remoteMe.runUserSub(false, "login","activity_resume");}
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("BackBtn_Click (login) ","login",3,login.mostCurrent.activityBA,login.mostCurrent,35);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.dictionaries.login.remoteMe.runUserSub(false, "login","backbtn_click");}
 BA.debugLineNum = 35;BA.debugLine="Private Sub BackBtn_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="StartActivity(\"Main\")";
Debug.ShouldStop(8);
login.mostCurrent.__c.runVoidMethod ("StartActivity",login.processBA,(Object)((RemoteObject.createImmutable("Main"))));
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
 //BA.debugLineNum = 15;BA.debugLine="Dim job1 As HttpJob";
login.mostCurrent._job1 = RemoteObject.createNew ("b4a.dictionaries.httpjob");
 //BA.debugLineNum = 16;BA.debugLine="Dim LoginBtn As Button";
login.mostCurrent._loginbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim UsernameTxt As EditText";
login.mostCurrent._usernametxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim PasswordTxt As EditText";
login.mostCurrent._passwordtxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim BackBtn As Button";
login.mostCurrent._backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (login) ","login",3,login.mostCurrent.activityBA,login.mostCurrent,45);
if (RapidSub.canDelegate("jobdone")) { return b4a.dictionaries.login.remoteMe.runUserSub(false, "login","jobdone", _job);}
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("job", _job);
 BA.debugLineNum = 45;BA.debugLine="Sub JobDone (job As HttpJob)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),login.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 47;BA.debugLine="Dim res As String = job.GetString";
Debug.ShouldStop(16384);
_res = _job.runClassMethod (b4a.dictionaries.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 48;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(32768);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 49;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(65536);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 50;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(131072);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 51;BA.debugLine="If root.Get(\"success\") = True Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("success")))),(login.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 52;BA.debugLine="ToastMessageShow(\"Login successful\", True)";
Debug.ShouldStop(524288);
login.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Login successful")),(Object)(login.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 53;BA.debugLine="StartActivity(Manage)";
Debug.ShouldStop(1048576);
login.mostCurrent.__c.runVoidMethod ("StartActivity",login.processBA,(Object)((login.mostCurrent._manage.getObject())));
 }else {
 BA.debugLineNum = 55;BA.debugLine="ToastMessageShow(\"Login failed: \" & root.Get(\"m";
Debug.ShouldStop(4194304);
login.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Login failed: "),_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("message"))))))),(Object)(login.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 58;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(33554432);
login.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(login.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 60;BA.debugLine="job.Release";
Debug.ShouldStop(134217728);
_job.runClassMethod (b4a.dictionaries.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loginbtn_click() throws Exception{
try {
		Debug.PushSubsStack("LoginBtn_Click (login) ","login",3,login.mostCurrent.activityBA,login.mostCurrent,38);
if (RapidSub.canDelegate("loginbtn_click")) { return b4a.dictionaries.login.remoteMe.runUserSub(false, "login","loginbtn_click");}
RemoteObject _json = RemoteObject.createImmutable("");
 BA.debugLineNum = 38;BA.debugLine="Private Sub LoginBtn_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="Dim json As String = \"{ \"\"username\"\": \"\"\" &Userna";
Debug.ShouldStop(64);
_json = RemoteObject.concat(RemoteObject.createImmutable("{ \"username\": \""),login.mostCurrent._usernametxt.runMethod(true,"getText"),RemoteObject.createImmutable("\", \"password\": \""),login.mostCurrent._passwordtxt.runMethod(true,"getText"),RemoteObject.createImmutable("\" }"));Debug.locals.put("json", _json);Debug.locals.put("json", _json);
 BA.debugLineNum = 40;BA.debugLine="job1.Initialize(\"Job1\", Me)";
Debug.ShouldStop(128);
login.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_initialize" /*RemoteObject*/ ,login.processBA,(Object)(BA.ObjectToString("Job1")),(Object)(login.getObject()));
 BA.debugLineNum = 41;BA.debugLine="job1.PostString(\"http://192.168.100.8:3000/login\"";
Debug.ShouldStop(256);
login.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("http://192.168.100.8:3000/login")),(Object)(_json));
 BA.debugLineNum = 42;BA.debugLine="job1.GetRequest.SetContentType(\"application/json\"";
Debug.ShouldStop(512);
login.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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