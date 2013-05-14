package com.example.perspolisiha;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SmsshowActivity extends Activity {
	
	private String[] SmsType1 =
		{
			"hello",
			"how are ",
			"sms 3",
			"sms4"
		};
	
	private String[] SmsType2 =
		{
			"hello",
			"how are ",
			"sms 3",
			"sms4"
		};
	
	//kdkdkd	
	private String[] SmsType3 =
		{
			"hello",
			"how are ",
			"sms 3",
			"sms4"
		};
	
	private String[] SmsType4 =
		{
			"hello",
			"how are ",
			"sms 3",
			"sms4"
		};
	
	private String[] SmsType5 =
		{
			"hello",
			"how are ",
			"sms 3",
			"sms4"
		};
	
	private String[] SmsType6 =
		{
			"hello",
			"how are ",
			"sms 3",
			"sms4"
		};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_show_activity);
		Log.d("Start","Start oncreat");
		
		
		//position receive for found that what number of item that clicked from gridView
		Intent current=getIntent();
		int position=current.getExtras().getInt("position");
		
		Button btnUpdate = (Button) findViewById(R.id.update);
		btnUpdate.setVisibility(View.INVISIBLE);
		
		
		Button backButton = (Button) findViewById(R.id.backward);
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		Log.d("end","end oncreat");
				
	}
	
	
	private void SendSms(String Context) {
		// TODO Auto-generated method stub
		Uri uri = Uri.parse("smsto:");   
	    Intent it = new Intent(Intent.ACTION_SENDTO, uri);   
	    it.putExtra("sms_body", Context);   
	    startActivity(it);

	}

}
