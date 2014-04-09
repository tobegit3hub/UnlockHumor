package cn.chendihao;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class UnlockHumorService extends Service {

	@Override
	public void onCreate() {
		super.onCreate();
	
		LayoutInflater inflater = LayoutInflater.from(UnlockHumorService.this);
        View view = inflater.inflate(R.layout.toast, null);
		
        Toast toast = new Toast(UnlockHumorService.this);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        
        toast.show();
        
        stopSelf();
	}

	@Override
	public void onDestroy() {

		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		
		super.onStart(intent, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}
}
