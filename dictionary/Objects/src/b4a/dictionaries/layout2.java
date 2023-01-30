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

public class layout2 extends Activity implements B4AActivity{
	public static layout2 mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.dictionaries", "b4a.dictionaries.layout2");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (layout2).");
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
		activityBA = new BA(this, layout, processBA, "b4a.dictionaries", "b4a.dictionaries.layout2");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.dictionaries.layout2", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (layout2) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (layout2) Resume **");
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
		return layout2.class;
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
            BA.LogInfo("** Activity (layout2) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (layout2) Pause event (activity is not paused). **");
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
            layout2 mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (layout2) Resume **");
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
public b4a.dictionaries.httpjob _job1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _searchtxt = null;
public anywheresoftware.b4a.objects.ButtonWrapper _searchbtn = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public b4a.dictionaries.httpjob _j = null;
public anywheresoftware.b4a.objects.ButtonWrapper _backbtn = null;
public b4a.dictionaries.main _main = null;
public b4a.dictionaries.imagedownloader _imagedownloader = null;
public b4a.dictionaries.login _login = null;
public b4a.dictionaries.manage _manage = null;
public b4a.dictionaries.add _add = null;
public b4a.dictionaries.edit _edit = null;
public b4a.dictionaries.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="layout2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Activity.LoadLayout(\"SearchLayout\")";
mostCurrent._activity.LoadLayout("SearchLayout",mostCurrent.activityBA);
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="layout2";
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="CallSub(ImageDownloader, \"ActivityIsPaused\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._imagedownloader.getObject()),"ActivityIsPaused");
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="layout2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="layout2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Private Sub BackBtn_Click";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.dictionaries.httpjob _job) throws Exception{
RDebugUtils.currentModule="layout2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
String _res = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.List _result = null;
anywheresoftware.b4a.objects.collections.List _allurls = null;
int _urlindex = 0;
anywheresoftware.b4a.objects.collections.Map _getword = null;
anywheresoftware.b4a.objects.LabelWrapper _wordlabel = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
anywheresoftware.b4a.objects.collections.Map _links = null;
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub JobDone (job As HttpJob)";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Select job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"job1")) {
case 0: {
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="Log(job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("4786436",_job._getstring /*String*/ (null),0);
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="Dim res As String = job.GetString";
_res = _job._getstring /*String*/ (null);
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="Dim result As List = root.Get(\"result\")";
_result = new anywheresoftware.b4a.objects.collections.List();
_result = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_root.Get((Object)("result"))));
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="Dim allUrls As List = root.Get(\"allUrls\")";
_allurls = new anywheresoftware.b4a.objects.collections.List();
_allurls = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_root.Get((Object)("allUrls"))));
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="j.Initialize(\"\",Me)";
mostCurrent._j._initialize /*String*/ (null,processBA,"",layout2.getObject());
RDebugUtils.currentLine=786444;
 //BA.debugLineNum = 786444;BA.debugLine="scrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="scrollView1.Panel.Height = 0";
mostCurrent._scrollview1.getPanel().setHeight((int) (0));
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="Dim urlIndex As Int = 0";
_urlindex = (int) (0);
RDebugUtils.currentLine=786447;
 //BA.debugLineNum = 786447;BA.debugLine="For Each getWord As Map In result";
_getword = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group15 = _result;
final int groupLen15 = group15.getSize()
;int index15 = 0;
;
for (; index15 < groupLen15;index15++){
_getword = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group15.Get(index15)));
RDebugUtils.currentLine=786448;
 //BA.debugLineNum = 786448;BA.debugLine="Dim WordLabel As Label";
_wordlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=786449;
 //BA.debugLineNum = 786449;BA.debugLine="WordLabel.Initialize(\"\")";
_wordlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=786450;
 //BA.debugLineNum = 786450;BA.debugLine="WordLabel.Text = getWord.Get(\"word\")";
_wordlabel.setText(BA.ObjectToCharSequence(_getword.Get((Object)("word"))));
RDebugUtils.currentLine=786451;
 //BA.debugLineNum = 786451;BA.debugLine="scrollView1.Panel.AddView(WordLabel, 0, scrol";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_wordlabel.getObject()),(int) (0),mostCurrent._scrollview1.getPanel().getHeight(),mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=786452;
 //BA.debugLineNum = 786452;BA.debugLine="scrollView1.Panel.Height = scrollView1.Panel.";
mostCurrent._scrollview1.getPanel().setHeight((int) (mostCurrent._scrollview1.getPanel().getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))));
RDebugUtils.currentLine=786454;
 //BA.debugLineNum = 786454;BA.debugLine="Dim ImageView1 As ImageView";
_imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=786455;
 //BA.debugLineNum = 786455;BA.debugLine="ImageView1.Initialize(\"\")";
_imageview1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=786456;
 //BA.debugLineNum = 786456;BA.debugLine="Dim links As Map";
_links = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=786457;
 //BA.debugLineNum = 786457;BA.debugLine="links.Initialize";
_links.Initialize();
RDebugUtils.currentLine=786458;
 //BA.debugLineNum = 786458;BA.debugLine="Try";
try {RDebugUtils.currentLine=786459;
 //BA.debugLineNum = 786459;BA.debugLine="links.Put(ImageView1,allUrls.Get(urlIndex))";
_links.Put((Object)(_imageview1.getObject()),_allurls.Get(_urlindex));
RDebugUtils.currentLine=786460;
 //BA.debugLineNum = 786460;BA.debugLine="CallSubDelayed2(ImageDownloader, \"Download\",";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._imagedownloader.getObject()),"Download",(Object)(_links));
 } 
       catch (Exception e29) {
			processBA.setLastException(e29);RDebugUtils.currentLine=786462;
 //BA.debugLineNum = 786462;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("4786462",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=786464;
 //BA.debugLineNum = 786464;BA.debugLine="scrollView1.Panel.AddView(ImageView1, 0, scro";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_imageview1.getObject()),(int) (0),mostCurrent._scrollview1.getPanel().getHeight(),mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=786465;
 //BA.debugLineNum = 786465;BA.debugLine="scrollView1.Panel.Height = scrollView1.Panel.";
mostCurrent._scrollview1.getPanel().setHeight((int) (mostCurrent._scrollview1.getPanel().getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100))));
RDebugUtils.currentLine=786466;
 //BA.debugLineNum = 786466;BA.debugLine="urlIndex = urlIndex + 1";
_urlindex = (int) (_urlindex+1);
 }
};
 break; }
}
;
 }else {
RDebugUtils.currentLine=786470;
 //BA.debugLineNum = 786470;BA.debugLine="Log(\"Error: \" & job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("4786470","Error: "+_job._errormessage /*String*/ ,0);
 };
RDebugUtils.currentLine=786472;
 //BA.debugLineNum = 786472;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=786473;
 //BA.debugLineNum = 786473;BA.debugLine="End Sub";
return "";
}
public static String  _searchbtn_click() throws Exception{
RDebugUtils.currentModule="layout2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "searchbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "searchbtn_click", null));}
String _searchword = "";
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub SearchBtn_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim searchWord As String = searchTxt.Text";
_searchword = mostCurrent._searchtxt.getText();
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="job1.Initialize(\"job1\", Me)";
mostCurrent._job1._initialize /*String*/ (null,processBA,"job1",layout2.getObject());
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="job1.PostString(\"http://192.168.100.8:3000/search";
mostCurrent._job1._poststring /*String*/ (null,"http://192.168.100.8:3000/search/"+_searchword,"");
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="job1.GetRequest.SetContentType(\"application/json\"";
mostCurrent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("application/json");
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="End Sub";
return "";
}
}