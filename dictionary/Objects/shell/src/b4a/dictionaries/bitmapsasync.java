
package b4a.dictionaries;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class bitmapsasync {
    public static RemoteObject myClass;
	public bitmapsasync() {
	}
    public static PCBA staticBA = new PCBA(null, bitmapsasync.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _jme = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _maxfilesize = RemoteObject.createImmutable(0L);
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static b4a.dictionaries.main _main = null;
public static b4a.dictionaries.layout2 _layout2 = null;
public static b4a.dictionaries.imagedownloader _imagedownloader = null;
public static b4a.dictionaries.login _login = null;
public static b4a.dictionaries.manage _manage = null;
public static b4a.dictionaries.add _add = null;
public static b4a.dictionaries.edit _edit = null;
public static b4a.dictionaries.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"jme",_ref.getField(false, "_jme"),"MaxFileSize",_ref.getField(false, "_maxfilesize"),"xui",_ref.getField(false, "_xui")};
}
}