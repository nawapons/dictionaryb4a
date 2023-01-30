package b4a.dictionaries;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class edit extends Activity implements B4AActivity{
	public static edit mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.dictionaries", "b4a.dictionaries.edit");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (edit).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, true))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.dictionaries", "b4a.dictionaries.edit");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.dictionaries.edit", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (edit) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (edit) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return edit.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (edit) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (edit) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            edit mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (edit) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.ButtonWrapper _backbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _searchbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _savebtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _deletebtn = null;
public anywheresoftware.b4a.objects.EditTextWrapper _wordtxt = null;
public anywheresoftware.b4a.objects.EditTextWrapper _showtxt = null;
public b4a.dictionaries.httpjob _job1 = null;
public b4a.dictionaries.httpjob _job2 = null;
public b4a.dictionaries.httpjob _job3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _idshow = null;
public b4a.dictionaries.main _main = null;
public b4a.dictionaries.layout2 _layout2 = null;
public b4a.dictionaries.imagedownloader _imagedownloader = null;
public b4a.dictionaries.login _login = null;
public b4a.dictionaries.manage _manage = null;
public b4a.dictionaries.add _add = null;
public b4a.dictionaries.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="edit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=13303808;
 //BA.debugLineNum = 13303808;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=13303811;
 //BA.debugLineNum = 13303811;BA.debugLine="Activity.LoadLayout(\"EditPage\")";
mostCurrent._activity.LoadLayout("EditPage",mostCurrent.activityBA);
RDebugUtils.currentLine=13303812;
 //BA.debugLineNum = 13303812;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="edit";
RDebugUtils.currentLine=13434880;
 //BA.debugLineNum = 13434880;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=13434882;
 //BA.debugLineNum = 13434882;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="edit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=13369344;
 //BA.debugLineNum = 13369344;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=13369346;
 //BA.debugLineNum = 13369346;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="edit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=14286848;
 //BA.debugLineNum = 14286848;BA.debugLine="Sub BackBtn_Click";
RDebugUtils.currentLine=14286849;
 //BA.debugLineNum = 14286849;BA.debugLine="StartActivity(Manage)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._manage.getObject()));
RDebugUtils.currentLine=14286850;
 //BA.debugLineNum = 14286850;BA.debugLine="End Sub";
return "";
}
public static String  _deletebtn_click() throws Exception{
RDebugUtils.currentModule="edit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "deletebtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "deletebtn_click", null));}
String _id = "";
RDebugUtils.currentLine=17301504;
 //BA.debugLineNum = 17301504;BA.debugLine="Private Sub DeleteBtn_Click";
RDebugUtils.currentLine=17301505;
 //BA.debugLineNum = 17301505;BA.debugLine="If IdShow.Text.Trim == \"\" Then";
if ((mostCurrent._idshow.getText().trim()).equals("")) { 
RDebugUtils.currentLine=17301506;
 //BA.debugLineNum = 17301506;BA.debugLine="ToastMessageShow(\"Show Text must have Word!\",Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Show Text must have Word!"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=17301508;
 //BA.debugLineNum = 17301508;BA.debugLine="Dim id As String = \"{\"\"id\"\": \"\"\" & IdShow.Text &";
_id = "{\"id\": \""+mostCurrent._idshow.getText()+"\"}";
RDebugUtils.currentLine=17301509;
 //BA.debugLineNum = 17301509;BA.debugLine="job3.Initialize(\"Job3\", Me)";
mostCurrent._job3._initialize /*String*/ (null,processBA,"Job3",edit.getObject());
RDebugUtils.currentLine=17301510;
 //BA.debugLineNum = 17301510;BA.debugLine="job3.PostString(\"http://192.168.100.8:3000/delet";
mostCurrent._job3._poststring /*String*/ (null,"http://192.168.100.8:3000/delete",_id);
RDebugUtils.currentLine=17301511;
 //BA.debugLineNum = 17301511;BA.debugLine="job3.GetRequest.SetContentType(\"application/json";
mostCurrent._job3._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("application/json");
 };
RDebugUtils.currentLine=17301513;
 //BA.debugLineNum = 17301513;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.dictionaries.httpjob _job) throws Exception{
RDebugUtils.currentModule="edit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
String _res = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
RDebugUtils.currentLine=14417920;
 //BA.debugLineNum = 14417920;BA.debugLine="Sub JobDone (job As HttpJob)";
RDebugUtils.currentLine=14417921;
 //BA.debugLineNum = 14417921;BA.debugLine="Select job";
switch (BA.switchObjectToInt(_job,mostCurrent._job1,mostCurrent._job2,mostCurrent._job3)) {
case 0: {
RDebugUtils.currentLine=14417923;
 //BA.debugLineNum = 14417923;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=14417924;
 //BA.debugLineNum = 14417924;BA.debugLine="Dim res As String = job.GetString";
_res = _job._getstring /*String*/ (null);
RDebugUtils.currentLine=14417925;
 //BA.debugLineNum = 14417925;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=14417926;
 //BA.debugLineNum = 14417926;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=14417927;
 //BA.debugLineNum = 14417927;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=14417928;
 //BA.debugLineNum = 14417928;BA.debugLine="If root.Get(\"success\") = True Then";
if ((_root.Get((Object)("success"))).equals((Object)(anywheresoftware.b4a.keywords.Common.True))) { 
RDebugUtils.currentLine=14417929;
 //BA.debugLineNum = 14417929;BA.debugLine="ShowTxt.Text = root.Get(\"word\")";
mostCurrent._showtxt.setText(BA.ObjectToCharSequence(_root.Get((Object)("word"))));
RDebugUtils.currentLine=14417930;
 //BA.debugLineNum = 14417930;BA.debugLine="ShowTxt.Enabled = True";
mostCurrent._showtxt.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14417931;
 //BA.debugLineNum = 14417931;BA.debugLine="IdShow.Text = root.Get(\"id\")";
mostCurrent._idshow.setText(BA.ObjectToCharSequence(_root.Get((Object)("id"))));
RDebugUtils.currentLine=14417932;
 //BA.debugLineNum = 14417932;BA.debugLine="WordTxt.Text = \"\"";
mostCurrent._wordtxt.setText(BA.ObjectToCharSequence(""));
 }else 
{RDebugUtils.currentLine=14417933;
 //BA.debugLineNum = 14417933;BA.debugLine="Else If root.Get(\"success\") = False Then";
if ((_root.Get((Object)("success"))).equals((Object)(anywheresoftware.b4a.keywords.Common.False))) { 
RDebugUtils.currentLine=14417934;
 //BA.debugLineNum = 14417934;BA.debugLine="ToastMessageShow(\"Word not found!: \", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Word not found!: "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=14417936;
 //BA.debugLineNum = 14417936;BA.debugLine="ToastMessageShow(\"Search failed: \" & root.Get";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Search failed: "+BA.ObjectToString(_root.Get((Object)("message")))),anywheresoftware.b4a.keywords.Common.True);
 }}
;
 }else {
RDebugUtils.currentLine=14417939;
 //BA.debugLineNum = 14417939;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage,";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=14417941;
 //BA.debugLineNum = 14417941;BA.debugLine="job1.Release";
mostCurrent._job1._release /*String*/ (null);
 break; }
case 1: {
RDebugUtils.currentLine=14417943;
 //BA.debugLineNum = 14417943;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=14417944;
 //BA.debugLineNum = 14417944;BA.debugLine="Dim res As String = job.GetString";
_res = _job._getstring /*String*/ (null);
RDebugUtils.currentLine=14417945;
 //BA.debugLineNum = 14417945;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=14417946;
 //BA.debugLineNum = 14417946;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=14417947;
 //BA.debugLineNum = 14417947;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=14417948;
 //BA.debugLineNum = 14417948;BA.debugLine="If root.Get(\"success\") = True Then";
if ((_root.Get((Object)("success"))).equals((Object)(anywheresoftware.b4a.keywords.Common.True))) { 
RDebugUtils.currentLine=14417949;
 //BA.debugLineNum = 14417949;BA.debugLine="ToastMessageShow(\"Word save! \", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Word save! "),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14417950;
 //BA.debugLineNum = 14417950;BA.debugLine="ShowTxt.Text = \"\"";
mostCurrent._showtxt.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=14417951;
 //BA.debugLineNum = 14417951;BA.debugLine="ShowTxt.Enabled = False";
mostCurrent._showtxt.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14417952;
 //BA.debugLineNum = 14417952;BA.debugLine="IdShow.Text = \"\"";
mostCurrent._idshow.setText(BA.ObjectToCharSequence(""));
 }else {
RDebugUtils.currentLine=14417954;
 //BA.debugLineNum = 14417954;BA.debugLine="ToastMessageShow(\"Save failed: \" & root.Get(\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Save failed: "+BA.ObjectToString(_root.Get((Object)("message")))),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=14417957;
 //BA.debugLineNum = 14417957;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage,";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=14417959;
 //BA.debugLineNum = 14417959;BA.debugLine="job2.Release";
mostCurrent._job2._release /*String*/ (null);
 break; }
case 2: {
RDebugUtils.currentLine=14417961;
 //BA.debugLineNum = 14417961;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=14417962;
 //BA.debugLineNum = 14417962;BA.debugLine="Dim res As String = job.GetString";
_res = _job._getstring /*String*/ (null);
RDebugUtils.currentLine=14417963;
 //BA.debugLineNum = 14417963;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=14417964;
 //BA.debugLineNum = 14417964;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=14417965;
 //BA.debugLineNum = 14417965;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=14417966;
 //BA.debugLineNum = 14417966;BA.debugLine="If root.Get(\"success\") = True Then";
if ((_root.Get((Object)("success"))).equals((Object)(anywheresoftware.b4a.keywords.Common.True))) { 
RDebugUtils.currentLine=14417967;
 //BA.debugLineNum = 14417967;BA.debugLine="ToastMessageShow(\"Delete Success! \", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Delete Success! "),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14417968;
 //BA.debugLineNum = 14417968;BA.debugLine="ShowTxt.Text = \"\"";
mostCurrent._showtxt.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=14417969;
 //BA.debugLineNum = 14417969;BA.debugLine="ShowTxt.Enabled = False";
mostCurrent._showtxt.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14417970;
 //BA.debugLineNum = 14417970;BA.debugLine="IdShow.Text = \"\"";
mostCurrent._idshow.setText(BA.ObjectToCharSequence(""));
 }else {
RDebugUtils.currentLine=14417972;
 //BA.debugLineNum = 14417972;BA.debugLine="ToastMessageShow(\"Delete failed: \" & root.Get";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Delete failed: "+BA.ObjectToString(_root.Get((Object)("message")))),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=14417975;
 //BA.debugLineNum = 14417975;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage,";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=14417977;
 //BA.debugLineNum = 14417977;BA.debugLine="job3.Release";
mostCurrent._job3._release /*String*/ (null);
 break; }
}
;
RDebugUtils.currentLine=14417979;
 //BA.debugLineNum = 14417979;BA.debugLine="End Sub";
return "";
}
public static String  _savebtn_click() throws Exception{
RDebugUtils.currentModule="edit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "savebtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "savebtn_click", null));}
String _word = "";
RDebugUtils.currentLine=16384000;
 //BA.debugLineNum = 16384000;BA.debugLine="Private Sub SaveBtn_Click";
RDebugUtils.currentLine=16384001;
 //BA.debugLineNum = 16384001;BA.debugLine="If ShowTxt.Text.Trim == \"\" Then";
if ((mostCurrent._showtxt.getText().trim()).equals("")) { 
RDebugUtils.currentLine=16384002;
 //BA.debugLineNum = 16384002;BA.debugLine="ToastMessageShow(\"Show Text must have Word!\",Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Show Text must have Word!"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=16384004;
 //BA.debugLineNum = 16384004;BA.debugLine="Dim Word As String = \"{ \"\"id\"\": \"\"\" &IdShow.Text";
_word = "{ \"id\": \""+mostCurrent._idshow.getText()+"\", \"word\": \""+mostCurrent._showtxt.getText()+"\" }";
RDebugUtils.currentLine=16384005;
 //BA.debugLineNum = 16384005;BA.debugLine="job2.Initialize(\"Job2\", Me)";
mostCurrent._job2._initialize /*String*/ (null,processBA,"Job2",edit.getObject());
RDebugUtils.currentLine=16384006;
 //BA.debugLineNum = 16384006;BA.debugLine="job2.PostString(\"http://192.168.100.8:3000/edit\"";
mostCurrent._job2._poststring /*String*/ (null,"http://192.168.100.8:3000/edit",_word);
RDebugUtils.currentLine=16384007;
 //BA.debugLineNum = 16384007;BA.debugLine="job2.GetRequest.SetContentType(\"application/json";
mostCurrent._job2._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("application/json");
 };
RDebugUtils.currentLine=16384009;
 //BA.debugLineNum = 16384009;BA.debugLine="End Sub";
return "";
}
public static String  _searchbtn_click() throws Exception{
RDebugUtils.currentModule="edit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "searchbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "searchbtn_click", null));}
String _word = "";
RDebugUtils.currentLine=15466496;
 //BA.debugLineNum = 15466496;BA.debugLine="Private Sub SearchBtn_Click";
RDebugUtils.currentLine=15466497;
 //BA.debugLineNum = 15466497;BA.debugLine="Dim Word As String = \"{\"\"Word\"\": \"\"\" & WordTxt.Te";
_word = "{\"Word\": \""+mostCurrent._wordtxt.getText()+"\"}";
RDebugUtils.currentLine=15466498;
 //BA.debugLineNum = 15466498;BA.debugLine="job1.Initialize(\"Job1\", Me)";
mostCurrent._job1._initialize /*String*/ (null,processBA,"Job1",edit.getObject());
RDebugUtils.currentLine=15466499;
 //BA.debugLineNum = 15466499;BA.debugLine="job1.PostString(\"http://192.168.100.8:3000/search";
mostCurrent._job1._poststring /*String*/ (null,"http://192.168.100.8:3000/searchadmin",_word);
RDebugUtils.currentLine=15466500;
 //BA.debugLineNum = 15466500;BA.debugLine="job1.GetRequest.SetContentType(\"application/json\"";
mostCurrent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("application/json");
RDebugUtils.currentLine=15466501;
 //BA.debugLineNum = 15466501;BA.debugLine="End Sub";
return "";
}
}