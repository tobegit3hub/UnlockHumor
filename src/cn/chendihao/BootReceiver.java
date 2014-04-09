package cn.chendihao;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		 if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){ 
		      Intent newIntent = new Intent(context, SettingActivity.class); 
		      newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  //注意，必须添加这个标记，否则启动会失败 
		      context.startActivity(newIntent);    
		 }	
		 
		 Toast.makeText(context, "okay boot receiver", Toast.LENGTH_LONG).show();
	}

}
