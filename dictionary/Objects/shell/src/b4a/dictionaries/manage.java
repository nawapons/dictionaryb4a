
package b4a.dictionaries;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class manage implements IRemote{
	public static manage mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public manage() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("manage"), "b4a.dictionaries.manage");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, manage.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _logoutbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _addbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _editbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static b4a.dictionaries.main _main = null;
public static b4a.dictionaries.layout2 _layout2 = null;
public static b4a.dictionaries.imagedownloader _imagedownloader = null;
public static b4a.dictionaries.login _login = null;
public static b4a.dictionaries.add _add = null;
public static b4a.dictionaries.edit _edit = null;
public static b4a.dictionaries.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",manage.mostCurrent._activity,"Add",Debug.moduleToString(b4a.dictionaries.add.class),"AddBtn",manage.mostCurrent._addbtn,"Edit",Debug.moduleToString(b4a.dictionaries.edit.class),"EditBtn",manage.mostCurrent._editbtn,"HttpUtils2Service",Debug.moduleToString(b4a.dictionaries.httputils2service.class),"ImageDownloader",Debug.moduleToString(b4a.dictionaries.imagedownloader.class),"Layout2",Debug.moduleToString(b4a.dictionaries.layout2.class),"Login",Debug.moduleToString(b4a.dictionaries.login.class),"LogoutBtn",manage.mostCurrent._logoutbtn,"Main",Debug.moduleToString(b4a.dictionaries.main.class)};
}
}