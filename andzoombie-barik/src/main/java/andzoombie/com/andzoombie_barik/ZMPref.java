package andzoombie.com.andzoombie_barik;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by jhovarie on 12/1/18.
 */

public class ZMPref {
    String preferencename;
    Activity act;

    public ZMPref(Activity act,String preferencename) {
        this.act = act;
        this.preferencename = preferencename;
    }

    public void setPref(String key, String value) {
        final SharedPreferences settings = act.getSharedPreferences(preferencename, 0);
        final SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getPref(String key) {
        //final SharedPreferences setting = act.getSharedPreferences(preferencename, 0);
        return act.getSharedPreferences(preferencename, 0).getString(key,"0");
    }

    public String getPref(String key,String defaultstr) {
        //final SharedPreferences setting = act.getSharedPreferences(preferencename, 0);
        return act.getSharedPreferences(preferencename, 0).getString(key,defaultstr);
    }
}
