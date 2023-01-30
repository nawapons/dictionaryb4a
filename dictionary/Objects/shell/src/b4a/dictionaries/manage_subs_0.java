package b4a.dictionaries;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class manage_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (manage) ","manage",4,manage.mostCurrent.activityBA,manage.mostCurrent,20);
if (RapidSub.canDelegate("activity_create")) { return b4a.dictionaries.manage.remoteMe.runUserSub(false, "manage","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 23;BA.debugLine="Activity.LoadLayout(\"ManagePage\")";
Debug.ShouldStop(4194304);
manage.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ManagePage")),manage.mostCurrent.activityBA);
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Pause (manage) ","manage",4,manage.mostCurrent.activityBA,manage.mostCurrent,30);
if (RapidSub.canDelegate("activity_pause")) { return b4a.dictionaries.manage.remoteMe.runUserSub(false, "manage","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Resume (manage) ","manage",4,manage.mostCurrent.activityBA,manage.mostCurrent,26);
if (RapidSub.canDelegate("activity_resume")) { return b4a.dictionaries.manage.remoteMe.runUserSub(false, "manage","activity_resume");}
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("AddBtn_Click (manage) ","manage",4,manage.mostCurrent.activityBA,manage.mostCurrent,36);
if (RapidSub.canDelegate("addbtn_click")) { return b4a.dictionaries.manage.remoteMe.runUserSub(false, "manage","addbtn_click");}
 BA.debugLineNum = 36;BA.debugLine="Private Sub AddBtn_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="StartActivity(Add)";
Debug.ShouldStop(16);
manage.mostCurrent.__c.runVoidMethod ("StartActivity",manage.processBA,(Object)((manage.mostCurrent._add.getObject())));
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _editbtn_click() throws Exception{
try {
		Debug.PushSubsStack("EditBtn_Click (manage) ","manage",4,manage.mostCurrent.activityBA,manage.mostCurrent,39);
if (RapidSub.canDelegate("editbtn_click")) { return b4a.dictionaries.manage.remoteMe.runUserSub(false, "manage","editbtn_click");}
 BA.debugLineNum = 39;BA.debugLine="Private Sub EditBtn_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="StartActivity(Edit)";
Debug.ShouldStop(128);
manage.mostCurrent.__c.runVoidMethod ("StartActivity",manage.processBA,(Object)((manage.mostCurrent._edit.getObject())));
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
 //BA.debugLineNum = 15;BA.debugLine="Dim LogoutBtn As Button";
manage.mostCurrent._logoutbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim AddBtn As Button";
manage.mostCurrent._addbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim EditBtn As Button";
manage.mostCurrent._editbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _logoutbtn_click() throws Exception{
try {
		Debug.PushSubsStack("LogoutBtn_Click (manage) ","manage",4,manage.mostCurrent.activityBA,manage.mostCurrent,33);
if (RapidSub.canDelegate("logoutbtn_click")) { return b4a.dictionaries.manage.remoteMe.runUserSub(false, "manage","logoutbtn_click");}
 BA.debugLineNum = 33;BA.debugLine="Private Sub LogoutBtn_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="StartActivity(Login)";
Debug.ShouldStop(2);
manage.mostCurrent.__c.runVoidMethod ("StartActivity",manage.processBA,(Object)((manage.mostCurrent._login.getObject())));
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}