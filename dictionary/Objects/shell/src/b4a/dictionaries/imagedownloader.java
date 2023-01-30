
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

public class imagedownloader implements IRemote{
	public static imagedownloader mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public imagedownloader() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("imagedownloader"), "b4a.dictionaries.imagedownloader");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("b4a.dictionaries.imagedownloader");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, imagedownloader.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _cache = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _tasks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _ongoingtasks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static b4a.dictionaries.main _main = null;
public static b4a.dictionaries.layout2 _layout2 = null;
public static b4a.dictionaries.login _login = null;
public static b4a.dictionaries.manage _manage = null;
public static b4a.dictionaries.add _add = null;
public static b4a.dictionaries.edit _edit = null;
public static b4a.dictionaries.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Add",Debug.moduleToString(b4a.dictionaries.add.class),"cache",imagedownloader._cache,"Edit",Debug.moduleToString(b4a.dictionaries.edit.class),"HttpUtils2Service",Debug.moduleToString(b4a.dictionaries.httputils2service.class),"Layout2",Debug.moduleToString(b4a.dictionaries.layout2.class),"Login",Debug.moduleToString(b4a.dictionaries.login.class),"Main",Debug.moduleToString(b4a.dictionaries.main.class),"Manage",Debug.moduleToString(b4a.dictionaries.manage.class),"ongoingTasks",imagedownloader._ongoingtasks,"Service",imagedownloader.mostCurrent._service,"tasks",imagedownloader._tasks};
}
}