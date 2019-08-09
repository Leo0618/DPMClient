package vip.okfood.dpmclient;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * function:
 *
 * <p></p>
 * Created by Leo on 2019/8/9.
 */
public class DPMReceiver extends DeviceAdminReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        LogUtil.logV("DeviceAdmin onReceive");
    }

    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
        LogUtil.logD("设备管理器已激活");
    }

    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {
        LogUtil.logD("发起禁用设备管理器的请求");
        return super.onDisableRequested(context, intent);
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);
        LogUtil.logD("设备管理器未激活");
    }

    @Override
    public void onPasswordChanged(Context context, Intent intent) {
        super.onPasswordChanged(context, intent);
        LogUtil.logD("密码己经改变");
    }

    @Override
    public void onPasswordExpiring(Context context, Intent intent) {
        super.onPasswordExpiring(context, intent);
        LogUtil.logD("密码已过期");
    }

    @Override
    public void onPasswordFailed(Context context, Intent intent) {
        super.onPasswordFailed(context, intent);
        LogUtil.logD("密码修改失败");
    }

    @Override
    public void onPasswordSucceeded(Context context, Intent intent) {
        super.onPasswordSucceeded(context, intent);
        LogUtil.logD("密码修改成功");
    }

}