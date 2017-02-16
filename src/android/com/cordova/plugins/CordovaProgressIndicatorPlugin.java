/**
 */
package com.cordova.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import android.graphics.Color;
import android.util.Log;


import cc.cloudist.acplibrary.ACProgressFlower;
import cc.cloudist.acplibrary.ACProgressConstant;

public class CordovaProgressIndicatorPlugin extends CordovaPlugin {
    private static final String TAG = "ProgressIndicatorPlugin";
    private ACProgressFlower dialog;
    private CordovaInterface cordova;

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.cordova = cordova;
        Log.d(TAG, "Initializing CordovaProgressIndicatorPlugin");
    }

    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

        if (action.equals("show")) {
            String message = args.getString(0);
            if (dialog != null) {
                //Hide existing dialog
                dialog.dismiss();
            }
            dialog = new ACProgressFlower.Builder(this.cordova.getActivity())
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .fadeColor(Color.DKGRAY).build();
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);

            if (message!=null)
            {
                if (!message.isEmpty())
                {
                    dialog.setTitle(message);
                }
            }

            dialog.show();
            final PluginResult result = new PluginResult(PluginResult.Status.OK);
            callbackContext.sendPluginResult(result);
        } else if (action.equals("hide")) {
            if (dialog != null) {
                //Hide existing dialog
                dialog.dismiss();
                dialog = null;
            }
            final PluginResult result = new PluginResult(PluginResult.Status.OK);
            callbackContext.sendPluginResult(result);
        }
        return true;
    }

}
