package cn.chendihao;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ScreenOnReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Intent newIntent = new Intent(context, UnlockHumorService.class);
		
		context.startService(newIntent);
		
	}




}
