package com.example.mybluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE = 1;
    private BluetoothAdapter mBluetoothAdapter;
    private String TAG="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 注册蓝牙状态接收广播
        IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(mReceiverBluetoothStatus,intentFilter);}

    /**
     * 定义接收蓝牙状态广播receiver
     *
     * @param savedInstanceState
     */
    private BroadcastReceiver mReceiverBluetoothStatus = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int status = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,-1);
            switch (status) {
                case BluetoothAdapter.STATE_OFF:
                    Log.d(TAG,"蓝牙已关闭");
                    break;
                case BluetoothAdapter.STATE_ON:
                    Log.d(TAG,"蓝牙已打开");
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    Log.d(TAG,"蓝牙关闭中...");
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    Log.d(TAG,"蓝牙打开中...");
                    break;
                default:

                    break;
            }
        }
    };
}