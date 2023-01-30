package b4a.dictionaries;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class imagedownloader_subs_0 {


public static RemoteObject  _activityispaused() throws Exception{
try {
		Debug.PushSubsStack("ActivityIsPaused (imagedownloader) ","imagedownloader",2,imagedownloader.processBA,imagedownloader.mostCurrent,60);
if (RapidSub.canDelegate("activityispaused")) { return b4a.dictionaries.imagedownloader.remoteMe.runUserSub(false, "imagedownloader","activityispaused");}
 BA.debugLineNum = 60;BA.debugLine="Sub ActivityIsPaused";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="tasks.Clear";
Debug.ShouldStop(268435456);
imagedownloader._tasks.runVoidMethod ("Clear");
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _download(RemoteObject _imageviewsmap) throws Exception{
try {
		Debug.PushSubsStack("Download (imagedownloader) ","imagedownloader",2,imagedownloader.processBA,imagedownloader.mostCurrent,25);
if (RapidSub.canDelegate("download")) { return b4a.dictionaries.imagedownloader.remoteMe.runUserSub(false, "imagedownloader","download", _imageviewsmap);}
int _i = 0;
RemoteObject _link = RemoteObject.createImmutable("");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _j = RemoteObject.declareNull("b4a.dictionaries.httpjob");
Debug.locals.put("ImageViewsMap", _imageviewsmap);
 BA.debugLineNum = 25;BA.debugLine="Sub Download (ImageViewsMap As Map)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 26;BA.debugLine="For i = 0 To ImageViewsMap.Size - 1";
Debug.ShouldStop(33554432);
{
final int step1 = 1;
final int limit1 = RemoteObject.solve(new RemoteObject[] {_imageviewsmap.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 27;BA.debugLine="tasks.Put(ImageViewsMap.GetKeyAt(i), ImageViewsM";
Debug.ShouldStop(67108864);
imagedownloader._tasks.runVoidMethod ("Put",(Object)(_imageviewsmap.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i)))),(Object)(_imageviewsmap.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i)))));
 BA.debugLineNum = 28;BA.debugLine="Dim link As String = ImageViewsMap.GetValueAt(i)";
Debug.ShouldStop(134217728);
_link = BA.ObjectToString(_imageviewsmap.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("link", _link);Debug.locals.put("link", _link);
 BA.debugLineNum = 29;BA.debugLine="If cache.ContainsKey(link) Then";
Debug.ShouldStop(268435456);
if (imagedownloader._cache.runMethod(true,"ContainsKey",(Object)((_link))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 30;BA.debugLine="Dim iv As ImageView = ImageViewsMap.GetKeyAt(i)";
Debug.ShouldStop(536870912);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
_iv = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ImageViewWrapper"), _imageviewsmap.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("iv", _iv);Debug.locals.put("iv", _iv);
 BA.debugLineNum = 31;BA.debugLine="iv.SetBackgroundImage(cache.Get(link))";
Debug.ShouldStop(1073741824);
_iv.runVoidMethod ("SetBackgroundImageNew",(Object)((imagedownloader._cache.runMethod(false,"Get",(Object)((_link))))));
 }else 
{ BA.debugLineNum = 32;BA.debugLine="Else If ongoingTasks.ContainsKey(link) = False T";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",imagedownloader._ongoingtasks.runMethod(true,"ContainsKey",(Object)((_link))),imagedownloader.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 33;BA.debugLine="ongoingTasks.Put(link, \"\")";
Debug.ShouldStop(1);
imagedownloader._ongoingtasks.runVoidMethod ("Put",(Object)((_link)),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 34;BA.debugLine="Dim j As HttpJob";
Debug.ShouldStop(2);
_j = RemoteObject.createNew ("b4a.dictionaries.httpjob");Debug.locals.put("j", _j);
 BA.debugLineNum = 35;BA.debugLine="j.Initialize(link, Me)";
Debug.ShouldStop(4);
_j.runClassMethod (b4a.dictionaries.httpjob.class, "_initialize" /*RemoteObject*/ ,imagedownloader.processBA,(Object)(_link),(Object)(imagedownloader.getObject()));
 BA.debugLineNum = 36;BA.debugLine="j.Download(link)";
Debug.ShouldStop(8);
_j.runClassMethod (b4a.dictionaries.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(_link));
 }}
;
 }
}Debug.locals.put("i", _i);
;
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
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (imagedownloader) ","imagedownloader",2,imagedownloader.processBA,imagedownloader.mostCurrent,41);
if (RapidSub.canDelegate("jobdone")) { return b4a.dictionaries.imagedownloader.remoteMe.runUserSub(false, "imagedownloader","jobdone", _job);}
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
int _i = 0;
RemoteObject _link = RemoteObject.createImmutable("");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 41;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="ongoingTasks.Remove(Job.JobName)";
Debug.ShouldStop(512);
imagedownloader._ongoingtasks.runVoidMethod ("Remove",(Object)((_job.getField(true,"_jobname" /*RemoteObject*/ ))));
 BA.debugLineNum = 43;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(1024);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 44;BA.debugLine="Dim bmp As Bitmap = Job.GetBitmap";
Debug.ShouldStop(2048);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp = _job.runClassMethod (b4a.dictionaries.httpjob.class, "_getbitmap" /*RemoteObject*/ );Debug.locals.put("bmp", _bmp);Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 45;BA.debugLine="cache.Put(Job.JobName, bmp)";
Debug.ShouldStop(4096);
imagedownloader._cache.runVoidMethod ("Put",(Object)((_job.getField(true,"_jobname" /*RemoteObject*/ ))),(Object)((_bmp.getObject())));
 BA.debugLineNum = 46;BA.debugLine="If tasks.IsInitialized Then";
Debug.ShouldStop(8192);
if (imagedownloader._tasks.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 47;BA.debugLine="For i = 0 To tasks.Size - 1";
Debug.ShouldStop(16384);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {imagedownloader._tasks.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 48;BA.debugLine="Dim link As String = tasks.GetValueAt(i)";
Debug.ShouldStop(32768);
_link = BA.ObjectToString(imagedownloader._tasks.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("link", _link);Debug.locals.put("link", _link);
 BA.debugLineNum = 49;BA.debugLine="If link = Job.JobName Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_link,_job.getField(true,"_jobname" /*RemoteObject*/ ))) { 
 BA.debugLineNum = 50;BA.debugLine="Dim iv As ImageView = tasks.GetKeyAt(i)";
Debug.ShouldStop(131072);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
_iv = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ImageViewWrapper"), imagedownloader._tasks.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("iv", _iv);Debug.locals.put("iv", _iv);
 BA.debugLineNum = 51;BA.debugLine="iv.SetBackgroundImage(bmp)";
Debug.ShouldStop(262144);
_iv.runVoidMethod ("SetBackgroundImageNew",(Object)((_bmp.getObject())));
 };
 }
}Debug.locals.put("i", _i);
;
 };
 }else {
 BA.debugLineNum = 56;BA.debugLine="Log(\"Error downloading image: \" & Job.JobName &";
Debug.ShouldStop(8388608);
imagedownloader.mostCurrent.__c.runVoidMethod ("LogImpl","41179663",RemoteObject.concat(RemoteObject.createImmutable("Error downloading image: "),_job.getField(true,"_jobname" /*RemoteObject*/ ),imagedownloader.mostCurrent.__c.getField(true,"CRLF"),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 };
 BA.debugLineNum = 58;BA.debugLine="Job.Release";
Debug.ShouldStop(33554432);
_job.runClassMethod (b4a.dictionaries.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private cache As Map";
imagedownloader._cache = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 7;BA.debugLine="Private tasks As Map";
imagedownloader._tasks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 8;BA.debugLine="Private ongoingTasks As Map";
imagedownloader._ongoingtasks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (imagedownloader) ","imagedownloader",2,imagedownloader.processBA,imagedownloader.mostCurrent,11);
if (RapidSub.canDelegate("service_create")) { return b4a.dictionaries.imagedownloader.remoteMe.runUserSub(false, "imagedownloader","service_create");}
 BA.debugLineNum = 11;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(1024);
 BA.debugLineNum = 12;BA.debugLine="tasks.Initialize";
Debug.ShouldStop(2048);
imagedownloader._tasks.runVoidMethod ("Initialize");
 BA.debugLineNum = 13;BA.debugLine="cache.Initialize";
Debug.ShouldStop(4096);
imagedownloader._cache.runVoidMethod ("Initialize");
 BA.debugLineNum = 14;BA.debugLine="ongoingTasks.Initialize";
Debug.ShouldStop(8192);
imagedownloader._ongoingtasks.runVoidMethod ("Initialize");
 BA.debugLineNum = 15;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (imagedownloader) ","imagedownloader",2,imagedownloader.processBA,imagedownloader.mostCurrent,21);
if (RapidSub.canDelegate("service_destroy")) { return b4a.dictionaries.imagedownloader.remoteMe.runUserSub(false, "imagedownloader","service_destroy");}
 BA.debugLineNum = 21;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (imagedownloader) ","imagedownloader",2,imagedownloader.processBA,imagedownloader.mostCurrent,17);
if (RapidSub.canDelegate("service_start")) { return b4a.dictionaries.imagedownloader.remoteMe.runUserSub(false, "imagedownloader","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 17;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 19;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}