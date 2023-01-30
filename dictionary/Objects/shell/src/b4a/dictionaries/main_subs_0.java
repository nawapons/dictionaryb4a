package b4a.dictionaries;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return b4a.dictionaries.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="Activity.LoadLayout(\"MainPage\")";
Debug.ShouldStop(4194304);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("MainPage")),main.mostCurrent.activityBA);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,36);
if (RapidSub.canDelegate("activity_pause")) { return b4a.dictionaries.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="CallSub(ImageDownloader, \"ActivityIsPaused\")";
Debug.ShouldStop(16);
main.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",main.processBA,(Object)((main.mostCurrent._imagedownloader.getObject())),(Object)(RemoteObject.createImmutable("ActivityIsPaused")));
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
if (RapidSub.canDelegate("activity_resume")) { return b4a.dictionaries.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Dim MainBtn As Button";
main.mostCurrent._mainbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _loginbtn_click() throws Exception{
try {
		Debug.PushSubsStack("LoginBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,29);
if (RapidSub.canDelegate("loginbtn_click")) { return b4a.dictionaries.main.remoteMe.runUserSub(false, "main","loginbtn_click");}
 BA.debugLineNum = 29;BA.debugLine="Sub LoginBtn_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="StartActivity(Login)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._login.getObject())));
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
public static RemoteObject  _mainbtn_click() throws Exception{
try {
		Debug.PushSubsStack("MainBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,26);
if (RapidSub.canDelegate("mainbtn_click")) { return b4a.dictionaries.main.remoteMe.runUserSub(false, "main","mainbtn_click");}
 BA.debugLineNum = 26;BA.debugLine="Sub MainBtn_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="StartActivity(Layout2)";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._layout2.getObject())));
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

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
layout2_subs_0._process_globals();
imagedownloader_subs_0._process_globals();
login_subs_0._process_globals();
manage_subs_0._process_globals();
add_subs_0._process_globals();
edit_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.dictionaries.main");
layout2.myClass = BA.getDeviceClass ("b4a.dictionaries.layout2");
imagedownloader.myClass = BA.getDeviceClass ("b4a.dictionaries.imagedownloader");
login.myClass = BA.getDeviceClass ("b4a.dictionaries.login");
manage.myClass = BA.getDeviceClass ("b4a.dictionaries.manage");
add.myClass = BA.getDeviceClass ("b4a.dictionaries.add");
edit.myClass = BA.getDeviceClass ("b4a.dictionaries.edit");
httputils2service.myClass = BA.getDeviceClass ("b4a.dictionaries.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.dictionaries.httpjob");
bitmapsasync.myClass = BA.getDeviceClass ("b4a.dictionaries.bitmapsasync");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}