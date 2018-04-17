package com.fluper.foodtruckuser.utils;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fluper.foodtruckuser.activities.MainActivity;

/**
 * Created by fluper on 11/4/18.
 */

public class AppUtils {
    static Context context;
    static View view;

    public AppUtils(Context context, View view){
        this.context = context;
        this.view = view;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager)context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            final Snackbar snackbar = Snackbar.make(view,
                    "No internet connection!", Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("RETRY", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            });
            snackbar.setActionTextColor(Color.WHITE);
            View sbView = snackbar.getView();
            sbView.setBackgroundColor(Color.RED);
            TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();
            return false;
        }
        return true;
    }
}
