package info.nightscout.android.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import info.nightscout.android.UploaderApplication;
import info.nightscout.android.medtronic.service.MasterService;

/**
 * Created by John on 4.9.17.
 */

public class AutoStart extends BroadcastReceiver {
    private static final String TAG = AutoStart.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Service auto starter, starting!");

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(UploaderApplication.getAppContext());

        if (prefs.getBoolean("EnableCgmService", false)) {
            Log.d(TAG, "starting master service");

            UploaderApplication.getAppContext().startService(new Intent(UploaderApplication.getAppContext(), MasterService.class));
        }
    }
}