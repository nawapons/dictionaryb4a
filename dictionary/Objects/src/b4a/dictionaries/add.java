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

public class add extends Activity implements B4AActivity{
	public static add mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.dictionaries", "b4a.dictionaries.add");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (add).");
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
		activityBA = new BA(this, layout, processBA, "b4a.dictionaries", "b4a.dictionaries.add");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.dictionaries.add", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (add) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (add) Resume **");
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
		return add.class;
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
            BA.LogInfo("** Activity (add) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (add) Pause event (activity is not paused). **");
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
            add mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (add) Resume **");
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
public anywheresoftware.b4a.objects.EditTextWrapper _wordtxt = null;
public anywheresoftware.b4a.objects.ButtonWrapper _addbtn = null;
public b4a.dictionaries.httpjob _job1 = null;
public b4a.dictionaries.main _main = null;
public b4a.dictionaries.layout2 _layout2 = null;
public b4a.dictionaries.imagedownloader _imagedownloader = null;
public b4a.dictionaries.login _login = null;
public b4a.dictionaries.manage _manage = null;
public b4a.dictionaries.edit _edit = null;
public b4a.dictionaries.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=9633792;
 //BA.debugLineNum = 9633792;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=9633795;
 //BA.debugLineNum = 9633795;BA.debugLine="Activity.LoadLayout(\"AddPage\")";
mostCurrent._activity.LoadLayout("AddPage",mostCurrent.activityBA);
RDebugUtils.currentLine=9633796;
 //BA.debugLineNum = 9633796;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="add";
RDebugUtils.currentLine=9764864;
 //BA.debugLineNum = 9764864;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=9764866;
 //BA.debugLineNum = 9764866;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=9699328;
 //BA.debugLineNum = 9699328;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=9699330;
 //BA.debugLineNum = 9699330;BA.debugLine="End Sub";
return "";
}
public static String  _addbtn_click() throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addbtn_click", null));}
String _word = "";
RDebugUtils.currentLine=11403264;
 //BA.debugLineNum = 11403264;BA.debugLine="Private Sub AddBtn_Click";
RDebugUtils.currentLine=11403265;
 //BA.debugLineNum = 11403265;BA.debugLine="Dim Word As String = \"{\"\"Word\"\": \"\"\" & WordTxt.Te";
_word = "{\"Word\": \""+mostCurrent._wordtxt.getText()+"\"}";
RDebugUtils.currentLine=11403266;
 //BA.debugLineNum = 11403266;BA.debugLine="job1.Initialize(\"Job1\", Me)";
mostCurrent._job1._initialize /*String*/ (null,processBA,"Job1",add.getObject());
RDebugUtils.currentLine=11403267;
 //BA.debugLineNum = 11403267;BA.debugLine="job1.PostString(\"http://192.168.100.8:3000/add\",";
mostCurrent._job1._poststring /*String*/ (null,"http://192.168.100.8:3000/add",_word);
RDebugUtils.currentLine=11403268;
 //BA.debugLineNum = 11403268;BA.debugLine="job1.GetRequest.SetContentType(\"application/json\"";
mostCurrent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("application/json");
RDebugUtils.currentLine=11403269;
 //BA.debugLineNum = 11403269;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=10616832;
 //BA.debugLineNum = 10616832;BA.debugLine="Sub BackBtn_Click";
RDebugUtils.currentLine=10616833;
 //BA.debugLineNum = 10616833;BA.debugLine="StartActivity(Manage)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._manage.getObject()));
RDebugUtils.currentLine=10616834;
 //BA.debugLineNum = 10616834;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.dictionaries.httpjob _job) throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
String _res = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
RDebugUtils.currentLine=11468800;
 //BA.debugLineNum = 11468800;BA.debugLine="Sub JobDone (job As HttpJob)";
RDebugUtils.currentLine=11468801;
 //BA.debugLineNum = 11468801;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=11468802;
 //BA.debugLineNum = 11468802;BA.debugLine="Dim res As String = job.GetString";
_res = _job._getstring /*String*/ (null);
RDebugUtils.currentLine=11468803;
 //BA.debugLineNum = 11468803;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=11468804;
 //BA.debugLineNum = 11468804;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=11468805;
 //BA.debugLineNum = 11468805;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=11468806;
 //BA.debugLineNum = 11468806;BA.debugLine="If root.Get(\"success\") = True Then";
if ((_root.Get((Object)("success"))).equals((Object)(anywheresoftware.b4a.keywords.Common.True))) { 
RDebugUtils.currentLine=11468807;
 //BA.debugLineNum = 11468807;BA.debugLine="ToastMessageShow(\"Add Word successful\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Add Word successful"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=11468808;
 //BA.debugLineNum = 11468808;BA.debugLine="Else If root.Get(\"success\") = False Then";
if ((_root.Get((Object)("success"))).equals((Object)(anywheresoftware.b4a.keywords.Common.False))) { 
RDebugUtils.currentLine=11468809;
 //BA.debugLineNum = 11468809;BA.debugLine="ToastMessageShow(\"Word Already Exist: \", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Word Already Exist: "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=11468811;
 //BA.debugLineNum = 11468811;BA.debugLine="ToastMessageShow(\"Add failed: \" & root.Get(\"mes";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Add failed: "+BA.ObjectToString(_root.Get((Object)("message")))),anywheresoftware.b4a.keywords.Common.True);
 }}
;
 }else {
RDebugUtils.currentLine=11468814;
 //BA.debugLineNum = 11468814;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=11468816;
 //BA.debugLineNum = 11468816;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=11468817;
 //BA.debugLineNum = 11468817;BA.debugLine="End Sub";
return "";
}
}