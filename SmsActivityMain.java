package com.example.perspolisiha;


import com.example.rank.ImageAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;


public class SmsActivityMain extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_main_activity);
		
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
		
		
		GridView gridSms = (GridView) findViewById(R.id.gridViewSms);
		gridSms.setAdapter(new ImageAdapter(getApplicationContext()));
		
		gridSms.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				Intent selectSms = new Intent(SmsActivityMain.this,SmsshowActivity.class);
				selectSms.putExtra("position", position);
				
				startActivity(selectSms);
				
			}
		});
			
		
	}
	

}
