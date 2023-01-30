package b4a.dictionaries;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class layout2_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (layout2) ","layout2",1,layout2.mostCurrent.activityBA,layout2.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return b4a.dictionaries.layout2.remoteMe.runUserSub(false, "layout2","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="Activity.LoadLayout(\"SearchLayout\")";
Debug.ShouldStop(4194304);
layout2.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("SearchLayout")),layout2.mostCurrent.activityBA);
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
		Debug.PushSubsStack("Activity_Pause (layout2) ","layout2",1,layout2.mostCurrent.activityBA,layout2.mostCurrent,29);
if (RapidSub.canDelegate("activity_pause")) { return b4a.dictionaries.layout2.remoteMe.runUserSub(false, "layout2","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="CallSub(ImageDownloader, \"ActivityIsPaused\")";
Debug.ShouldStop(536870912);
layout2.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",layout2.processBA,(Object)((layout2.mostCurrent._imagedownloader.getObject())),(Object)(RemoteObject.createImmutable("ActivityIsPaused")));
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (layout2) ","layout2",1,layout2.mostCurrent.activityBA,layout2.mostCurrent,26);
if (RapidSub.canDelegate("activity_resume")) { return b4a.dictionaries.layout2.remoteMe.runUserSub(false, "layout2","activity_resume");}
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
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("BackBtn_Click (layout2) ","layout2",1,layout2.mostCurrent.activityBA,layout2.mostCurrent,38);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.dictionaries.layout2.remoteMe.runUserSub(false, "layout2","backbtn_click");}
 BA.debugLineNum = 38;BA.debugLine="Private Sub BackBtn_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(64);
layout2.mostCurrent.__c.runVoidMethod ("StartActivity",layout2.processBA,(Object)((layout2.mostCurrent._main.getObject())));
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 14;BA.debugLine="Dim job1 As HttpJob";
layout2.mostCurrent._job1 = RemoteObject.createNew ("b4a.dictionaries.httpjob");
 //BA.debugLineNum = 15;BA.debugLine="Dim searchTxt As EditText";
layout2.mostCurrent._searchtxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim searchBtn As Button";
layout2.mostCurrent._searchbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim scrollView1 As ScrollView";
layout2.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim j As HttpJob";
layout2.mostCurrent._j = RemoteObject.createNew ("b4a.dictionaries.httpjob");
 //BA.debugLineNum = 19;BA.debugLine="Dim BackBtn As Button";
layout2.mostCurrent._backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (layout2) ","layout2",1,layout2.mostCurrent.activityBA,layout2.mostCurrent,41);
if (RapidSub.canDelegate("jobdone")) { return b4a.dictionaries.layout2.remoteMe.runUserSub(false, "layout2","jobdone", _job);}
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _allurls = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _urlindex = RemoteObject.createImmutable(0);
RemoteObject _getword = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _wordlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _imageview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _links = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("job", _job);
 BA.debugLineNum = 41;BA.debugLine="Sub JobDone (job As HttpJob)";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),layout2.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 43;BA.debugLine="Select job.JobName";
Debug.ShouldStop(1024);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("job1"))) {
case 0: {
 BA.debugLineNum = 45;BA.debugLine="Log(job.GetString)";
Debug.ShouldStop(4096);
layout2.mostCurrent.__c.runVoidMethod ("LogImpl","4786436",_job.runClassMethod (b4a.dictionaries.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 46;BA.debugLine="Dim res As String = job.GetString";
Debug.ShouldStop(8192);
_res = _job.runClassMethod (b4a.dictionaries.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 47;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(16384);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 48;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(32768);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 49;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(65536);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 50;BA.debugLine="Dim result As List = root.Get(\"result\")";
Debug.ShouldStop(131072);
_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_result = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("result")))));Debug.locals.put("result", _result);Debug.locals.put("result", _result);
 BA.debugLineNum = 51;BA.debugLine="Dim allUrls As List = root.Get(\"allUrls\")";
Debug.ShouldStop(262144);
_allurls = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_allurls = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("allUrls")))));Debug.locals.put("allUrls", _allurls);Debug.locals.put("allUrls", _allurls);
 BA.debugLineNum = 52;BA.debugLine="j.Initialize(\"\",Me)";
Debug.ShouldStop(524288);
layout2.mostCurrent._j.runClassMethod (b4a.dictionaries.httpjob.class, "_initialize" /*RemoteObject*/ ,layout2.processBA,(Object)(BA.ObjectToString("")),(Object)(layout2.getObject()));
 BA.debugLineNum = 53;BA.debugLine="scrollView1.Panel.RemoveAllViews";
Debug.ShouldStop(1048576);
layout2.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 54;BA.debugLine="scrollView1.Panel.Height = 0";
Debug.ShouldStop(2097152);
layout2.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, 0));
 BA.debugLineNum = 55;BA.debugLine="Dim urlIndex As Int = 0";
Debug.ShouldStop(4194304);
_urlindex = BA.numberCast(int.class, 0);Debug.locals.put("urlIndex", _urlindex);Debug.locals.put("urlIndex", _urlindex);
 BA.debugLineNum = 56;BA.debugLine="For Each getWord As Map In result";
Debug.ShouldStop(8388608);
_getword = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group15 = _result;
final int groupLen15 = group15.runMethod(true,"getSize").<Integer>get()
;int index15 = 0;
;
for (; index15 < groupLen15;index15++){
_getword = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group15.runMethod(false,"Get",index15));Debug.locals.put("getWord", _getword);
Debug.locals.put("getWord", _getword);
 BA.debugLineNum = 57;BA.debugLine="Dim WordLabel As Label";
Debug.ShouldStop(16777216);
_wordlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("WordLabel", _wordlabel);
 BA.debugLineNum = 58;BA.debugLine="WordLabel.Initialize(\"\")";
Debug.ShouldStop(33554432);
_wordlabel.runVoidMethod ("Initialize",layout2.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 59;BA.debugLine="WordLabel.Text = getWord.Get(\"word\")";
Debug.ShouldStop(67108864);
_wordlabel.runMethod(true,"setText",BA.ObjectToCharSequence(_getword.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("word"))))));
 BA.debugLineNum = 60;BA.debugLine="scrollView1.Panel.AddView(WordLabel, 0, scrol";
Debug.ShouldStop(134217728);
layout2.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_wordlabel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(layout2.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"getHeight")),(Object)(layout2.mostCurrent._scrollview1.runMethod(true,"getWidth")),(Object)(layout2.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 61;BA.debugLine="scrollView1.Panel.Height = scrollView1.Panel.";
Debug.ShouldStop(268435456);
layout2.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {layout2.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"getHeight"),layout2.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "+",1, 1));
 BA.debugLineNum = 63;BA.debugLine="Dim ImageView1 As ImageView";
Debug.ShouldStop(1073741824);
_imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("ImageView1", _imageview1);
 BA.debugLineNum = 64;BA.debugLine="ImageView1.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_imageview1.runVoidMethod ("Initialize",layout2.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 65;BA.debugLine="Dim links As Map";
Debug.ShouldStop(1);
_links = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("links", _links);
 BA.debugLineNum = 66;BA.debugLine="links.Initialize";
Debug.ShouldStop(2);
_links.runVoidMethod ("Initialize");
 BA.debugLineNum = 67;BA.debugLine="Try";
Debug.ShouldStop(4);
try { BA.debugLineNum = 68;BA.debugLine="links.Put(ImageView1,allUrls.Get(urlIndex))";
Debug.ShouldStop(8);
_links.runVoidMethod ("Put",(Object)((_imageview1.getObject())),(Object)(_allurls.runMethod(false,"Get",(Object)(_urlindex))));
 BA.debugLineNum = 69;BA.debugLine="CallSubDelayed2(ImageDownloader, \"Download\",";
Debug.ShouldStop(16);
layout2.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",layout2.processBA,(Object)((layout2.mostCurrent._imagedownloader.getObject())),(Object)(BA.ObjectToString("Download")),(Object)((_links)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e29) {
			BA.rdebugUtils.runVoidMethod("setLastException",layout2.processBA, e29.toString()); BA.debugLineNum = 71;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(64);
layout2.mostCurrent.__c.runVoidMethod ("LogImpl","4786462",layout2.mostCurrent.__c.runMethod(false,"LastException",layout2.mostCurrent.activityBA).runMethod(true,"getMessage"),0);
 };
 BA.debugLineNum = 73;BA.debugLine="scrollView1.Panel.AddView(ImageView1, 0, scro";
Debug.ShouldStop(256);
layout2.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_imageview1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(layout2.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"getHeight")),(Object)(layout2.mostCurrent._scrollview1.runMethod(true,"getWidth")),(Object)(layout2.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 74;BA.debugLine="scrollView1.Panel.Height = scrollView1.Panel.";
Debug.ShouldStop(512);
layout2.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {layout2.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"getHeight"),layout2.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "+",1, 1));
 BA.debugLineNum = 75;BA.debugLine="urlIndex = urlIndex + 1";
Debug.ShouldStop(1024);
_urlindex = RemoteObject.solve(new RemoteObject[] {_urlindex,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("urlIndex", _urlindex);
 }
}Debug.locals.put("getWord", _getword);
;
 break; }
}
;
 }else {
 BA.debugLineNum = 79;BA.debugLine="Log(\"Error: \" & job.ErrorMessage)";
Debug.ShouldStop(16384);
layout2.mostCurrent.__c.runVoidMethod ("LogImpl","4786470",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 };
 BA.debugLineNum = 81;BA.debugLine="job.Release";
Debug.ShouldStop(65536);
_job.runClassMethod (b4a.dictionaries.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _searchbtn_click() throws Exception{
try {
		Debug.PushSubsStack("SearchBtn_Click (layout2) ","layout2",1,layout2.mostCurrent.activityBA,layout2.mostCurrent,32);
if (RapidSub.canDelegate("searchbtn_click")) { return b4a.dictionaries.layout2.remoteMe.runUserSub(false, "layout2","searchbtn_click");}
RemoteObject _searchword = RemoteObject.createImmutable("");
 BA.debugLineNum = 32;BA.debugLine="Private Sub SearchBtn_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Dim searchWord As String = searchTxt.Text";
Debug.ShouldStop(1);
_searchword = layout2.mostCurrent._searchtxt.runMethod(true,"getText");Debug.locals.put("searchWord", _searchword);Debug.locals.put("searchWord", _searchword);
 BA.debugLineNum = 34;BA.debugLine="job1.Initialize(\"job1\", Me)";
Debug.ShouldStop(2);
layout2.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_initialize" /*RemoteObject*/ ,layout2.processBA,(Object)(BA.ObjectToString("job1")),(Object)(layout2.getObject()));
 BA.debugLineNum = 35;BA.debugLine="job1.PostString(\"http://192.168.100.8:3000/search";
Debug.ShouldStop(4);
layout2.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("http://192.168.100.8:3000/search/"),_searchword)),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 36;BA.debugLine="job1.GetRequest.SetContentType(\"application/json\"";
Debug.ShouldStop(8);
layout2.mostCurrent._job1.runClassMethod (b4a.dictionaries.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
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
}