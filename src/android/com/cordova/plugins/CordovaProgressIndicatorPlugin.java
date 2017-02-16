/**
 */
package com.cordova.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import java.util.Date;
import cc.cloudist.acplibrary.ACProgressFlower;
import cc.cloudist.acplibrary.ACProgressConstant;

public class CordovaProgressIndicatorPlugin extends CordovaPlugin {
  private static final String TAG = "CordovaProgressIndicatorPlugin";
  private ACProgressFlower dialog;
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing CordovaProgressIndicatorPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

    if(action.equals("show")) {
      String phrase = args.getString(0);
      if (dialog != null)
      {
        //Hide existing dialog
      }
      dialog = new ACProgressFlower.Builder(this)
                              .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                              .themeColor(Color.WHITE)
                              .text("Title is here)
                              .fadeColor(Color.DKGRAY).build();
      dialog.setCanceledOnTouchOutside(false);
      dialog.show();

    } else if(action.equals("hide")) {
      // An example of returning data back to the web layer
      final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
      callbackContext.sendPluginResult(result);
    }
    return true;
  }

}
