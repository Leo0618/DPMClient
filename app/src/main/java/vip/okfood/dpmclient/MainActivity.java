package vip.okfood.dpmclient;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private DevicePolicyManager mDevicePolicyManager;
    private ComponentName       mComponentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mDevicePolicyManager == null) mDevicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        if(mComponentName == null) mComponentName = new ComponentName(getApplicationContext(), DPMReceiver.class);
    }

    public void auth(View view) {
        if(!mDevicePolicyManager.isAdminActive(mComponentName)) {
            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mComponentName);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, getString(R.string.app_name));
            ComponentName componentName = intent.resolveActivity(getPackageManager());
            if(componentName != null) {
                intent.setComponent(componentName);
                startActivity(intent);
            } else {
                Toast.makeText(this, "请到设置中开启设备管理应用", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "设备已激活", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(mDevicePolicyManager.isAdminActive(mComponentName)) {
            mDevicePolicyManager.setCameraDisabled(mComponentName, isChecked);
            Toast.makeText(this, "摄像头已 "+(mDevicePolicyManager.getCameraDisabled(mComponentName) ? "禁用" : "启用"), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "请先激活设备", Toast.LENGTH_SHORT).show();
        }

    }
}
