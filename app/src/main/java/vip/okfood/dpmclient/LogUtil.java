package vip.okfood.dpmclient;

import android.util.Log;

/**
 * function:
 *
 * <p></p>
 * Created by Leo on 2019/8/9.
 */
public class LogUtil {

    public static void logV(String msg) {
        if(BuildConfig.DEBUG) Log.d("Leo", msg);
    }

    public static void logD(String msg) {
        if(BuildConfig.DEBUG) Log.d("Leo", msg);
    }

    public static void logI(String msg) {
        if(BuildConfig.DEBUG) Log.d("Leo", msg);
    }
}
