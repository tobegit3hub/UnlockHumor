package cn.chendihao;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class AboutActivity extends Activity {
	
	Button backButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.about);
		
		backButton = (Button)findViewById(R.id.back);
		
		backButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				
//				LayoutInflater inflater = LayoutInflater.from(AboutActivity.this);
//	            View view = inflater.inflate(R.layout.toast, (ViewGroup)findViewById(R.id.toast_root));
//				
//	            Toast toast = new Toast(AboutActivity.this);
//	            toast.setView(view);
//	            toast.setDuration(Toast.LENGTH_LONG);
//	            toast.setGravity(Gravity.CENTER, 0, 0);
//	            
//	            toast.show();
	            
			}	
		});
	}


}
