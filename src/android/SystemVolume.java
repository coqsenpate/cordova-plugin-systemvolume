package com.coqsenpate.cordova;

import android.media.AudioManager;
import android.content.Context;
import android.util.Log;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SystemVolume extends CordovaPlugin {
  protected void pluginInitialize(){
  }

  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException{
    if (action.equals("set")){
      set(args.getString(0),callbackContext);
      return true;
    }
    else{
      return false;
    }
  }

  private void set(final String newVolumeValueString_0_100, CallbackContext callbackContext){

    AudioManager audioManager = (AudioManager)cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
    //convert string to float and float to int
    int newVolumeValue_0_100 = Integer.parseInt(newVolumeValueString_0_100);
    //get the maximal volume value
    int maxVolumeValue = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    // get the right new volume value
    int newVolumeValue = (maxVolumeValue*newVolumeValue_0_100)/100;
    Log.d("SystemVolume","Setting system volume to : "+newVolumeValue);

    //try set the new volume value
    audioManager.setStreamVolume(audioManager.STREAM_MUSIC, newVolumeValue, 0);
    if ( audioManager.getStreamVolume(AudioManager.STREAM_MUSIC) == newVolumeValue) {
      Log.d("SystemVolume","System volume set to "+newVolumeValue);
    }
    else{ // if it doesn't work beacause of unsafe volume warning
       int hearProtectionVolumeValue = newVolumeValue;
      // decrease it one by one util manage to do it
      while( audioManager.getStreamVolume(AudioManager.STREAM_MUSIC) != hearProtectionVolumeValue ){
        hearProtectionVolumeValue -= 1;
        audioManager.setStreamVolume(audioManager.STREAM_MUSIC, hearProtectionVolumeValue, 0);
      }
      Log.d("SystemVolume","System volume set to "+hearProtectionVolumeValue+" instead of "+newVolumeValue+" beacause of hear protection system ( system paramter config_safe_media_volume_enabled set to true )");
    }
    //send plugin Result
    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
  }
}
