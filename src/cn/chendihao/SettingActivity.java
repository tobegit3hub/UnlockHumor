package cn.chendihao;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.widget.Toast;

public class SettingActivity extends PreferenceActivity implements OnPreferenceChangeListener{
	
	private final Handler mHandler = new Handler();
	
	private BroadcastReceiver screenOnReceiver = new ScreenOnReceiver();
	
    public static final String KEY_AUTORUN = "key_autorun";
    public static final String KEY_SHOW_TIME = "key_show_time";
    public static final String KEY_SHOW_CONTENT = "key_show_content";
    
    private Preference autorunPreference;
    private Preference showTimePreference;
    private Preference showContentPreference;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        addPreferencesFromResource(R.xml.preference);

        autorunPreference = findPreference(KEY_AUTORUN);
        showTimePreference = findPreference(KEY_SHOW_TIME);
        showContentPreference = findPreference(KEY_SHOW_CONTENT);

        showTimePreference.setSummary(showTimePreference.getSharedPreferences().getString(KEY_SHOW_TIME, ""));
        showContentPreference.setSummary(showContentPreference.getSharedPreferences().getString(KEY_SHOW_CONTENT, ""));
        
        autorunPreference.setOnPreferenceChangeListener(this);
        showTimePreference.setOnPreferenceChangeListener(this);
        showContentPreference.setOnPreferenceChangeListener(this);
    }

	@Override
	public boolean onPreferenceChange(final Preference arg0, Object arg1) {
	
		final String key = arg0.getKey();
		
		if(key.equals(KEY_AUTORUN) || key.equals(KEY_SHOW_TIME) || key.equals(KEY_SHOW_CONTENT)){
		
	        //希望250ms内newValue会被写进去。
	        mHandler.postDelayed(new Runnable() {
	
	            @Override
	            public void run() {
	            	if(key.equals(KEY_AUTORUN)){
	            		
	            		if(arg0.getSharedPreferences().getBoolean(KEY_AUTORUN, false)){
		    	        	IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON); 
		    	        	//filter.addAction("android.intent.action.SCREEN_OFF"); 
		    	        	registerReceiver(screenOnReceiver, filter); 
		    	        	
		    	        	KeyguardManager mKeyguardManager = (KeyguardManager)getSystemService(Context.KEYGUARD_SERVICE); 
		    	        	KeyguardLock mKeyguardLock = mKeyguardManager.newKeyguardLock("FLAG_DISMISS_KEYGUARD"); 
		    	        	mKeyguardLock.disableKeyguard(); 
		    	        	
	            		}else{
	            			unregisterReceiver(screenOnReceiver);
	            			
	            			//KeyguardManager mKeyguardManager = (KeyguardManager)getSystemService(Context.KEYGUARD_SERVICE); 
		    	        	//KeyguardLock mKeyguardLock = mKeyguardManager.newKeyguardLock("FLAG_DISMISS_KEYGUARD"); 
		    	        	//mKeyguardLock.reenableKeyguard();
	            		}

	            	}else if(key.equals(KEY_SHOW_TIME)){
	        	        showTimePreference.setSummary(arg0.getSharedPreferences().getString(KEY_SHOW_TIME, ""));
	        		}else if(key.equals(KEY_SHOW_CONTENT)){
	        			showContentPreference.setSummary(arg0.getSharedPreferences().getString(KEY_SHOW_CONTENT, ""));
	        		}
	            }
	        }, 250);
		}
        
        return true;        
	}
	
  @Override
  public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {

      return false;
  }
    
}