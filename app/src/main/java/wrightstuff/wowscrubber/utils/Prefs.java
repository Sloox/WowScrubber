package wrightstuff.wowscrubber.utils;

import android.content.Context;
import android.content.SharedPreferences;

import wrightstuff.wowscrubber.R;

/**
 * Created by michaelwright on 01/08/2017.
 */
public class Prefs {

    public static String getString(Context context, int resId) {
        return getPrefs(context).getString(context.getString(resId), "");
    }

    public static void setString(Context context, int resId, String value) {
        getPrefs(context).edit().putString(context.getString(resId), value).commit();
    }

    public static void setString(Context context, String key, String value) {
        getPrefs(context).edit().putString(key, value).commit();
    }


    public static int getInt(Context context, int resId) {
        return getPrefs(context).getInt(context.getString(resId), 0);
    }

    public static int getInt(Context context, String key) {
        return getPrefs(context).getInt(key, 0);
    }

    public static void setInt(Context context, int resId, int value) {
        getPrefs(context).edit().putInt(context.getString(resId), value).commit();
    }

    public static void setInt(Context context, String key, int value) {
        getPrefs(context).edit().putInt(key, value).commit();
    }


    public static double getDouble(Context context, int resId) {
        return Double.valueOf(getPrefs(context).getString(context.getString(resId), "0"));
    }

    public static void setDouble(Context context, int resId, double value) {
        getPrefs(context).edit().putString(context.getString(resId), "" + value).commit();
    }


    public static boolean getBoolean(Context context, int resId) {
        final String key = context.getString(resId);
        return getPrefs(context).getBoolean(key, false);
    }

    public static void setBoolean(Context context, int resId, boolean value) {
        getPrefs(context).edit().putBoolean(context.getString(resId), value).commit();
    }


    public static long getLong(Context context, int resId) {
        return getPrefs(context).getLong(context.getString(resId), 0);
    }

    public static long getLong(Context context, String key) {
        return getPrefs(context).getLong(key, 0);
    }

    public static void setLong(Context context, int resId, long value) {
        getPrefs(context).edit().putLong(context.getString(resId), value).commit();
    }

    public static void setLong(Context context, String key, long value) {
        getPrefs(context).edit().putLong(key, value).commit();
    }


    private static SharedPreferences getPrefs(Context context) {
        String prefsName = context.getString(R.string.preference_file);
        return context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
    }

    public static void clearPreferences(Context context, int resId) {
        final SharedPreferences prefs = getPrefs(context);
        final String key = context.getString(resId);
        prefs.edit().remove(key).commit();
    }
}
