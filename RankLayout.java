package com.example.rank;


import com.example.perspolisiha.R;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.content.Intent;
import android.os.Vibrator;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup;

public class RankLayout extends ListActivity {
    /** Called when the activity is first created. */
	private	 		 String 			Link="";
	private			 ProgressDialog 	progressBar;
	private			 Animation 			rotation;
	private			 Boolean			Loading=false;
	public static 	 RankData 				my_data;
	private 		 Vibrator 			vibre;
					 DownloadXmlTask 	downloadXmlTask;
	private 		 int 				id;
	public static	 RankDatabaseHandler    db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rank);

		setListAdapter(new IconicAdapter());
		
		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		Display display = getWindowManager().getDefaultDisplay(); 
		float width = display.getWidth()/this.getResources().getDisplayMetrics().density;
		RankGlobalInformation.Coefficient = (float) (width / 426.6);

		db = new RankDatabaseHandler(this);

		TextView title = (TextView) findViewById(R.id.title_name);
		title.setText("جدول رده بندی فوتبال");
		Button updateButton = (Button) findViewById(R.id.update);
		updateButton.setVisibility(updateButton.INVISIBLE);
		
		Button backButton = (Button) findViewById(R.id.backward);
		backButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//vibre.vibrate(25);
				finish();				
			}
		});

	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("TOO OPENE","a");
		db.open();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		db.close();
		if (Loading==true)
			stopLoadingAndDownloading();
	}
	
	
	private String getModel(int position){
		id = position;
		return(((IconicAdapter)getListAdapter()).getItem(position));
	}
    
    
    //=====================
	//New Class Starts Here
	//=====================
	
	class IconicAdapter extends ArrayAdapter<String> {
	   	int i=0;
	   	public IconicAdapter() {
	   		super(RankLayout.this, R.layout.row, R.id.label, RankGlobalInformation.persianItems);	
	   	}
	   	
	   	public View getView(int position, View convertView, ViewGroup parent){
	   		//return each raws
	   		id = position;
	   		View row = super.getView(position, convertView, parent);
	   		//for the first beacase raw not make return null
			RankViewHolder holder = (RankViewHolder)row.getTag();
			
			if(holder == null){			
				//beacase we dont can make id for items(?) we must added id in code 
				//in code we use tag instead of id
				holder = new RankViewHolder(row);
				row.setTag(holder);
			}
			
			Log.d(RankGlobalInformation.Links[4],"HAW");
			//by below code we can tell if getModel(position)==lig bartar--then what be icon of it
			//i dont find icon of ligs and if you cannot find it skip this section
			//better use switch
			if(getModel(position)==RankGlobalInformation.persianItems[0] )
				holder.icon.setImageResource(R.drawable.iran);
			
			else if(getModel(position)==RankGlobalInformation.persianItems[1]) {
				holder.icon.setImageResource(R.drawable.england);
			}
			else if(getModel(position)==RankGlobalInformation.persianItems[2]) {
				holder.icon.setImageResource(R.drawable.germany);
			}
			else if(getModel(position)==RankGlobalInformation.persianItems[3]) {
				holder.icon.setImageResource(R.drawable.france);
			}
			else if(getModel(position)==RankGlobalInformation.persianItems[4]) {
				holder.icon.setImageResource(R.drawable.spain);
			}
			else
			{
				holder.icon.setImageResource(R.drawable.italy);
			}
	   		
	   		return(row);
	   	}	   	
	}
	
	//below method is default method for listview 
    public void onListItemClick(ListView parent, View v, int position, 
    		long id){
    	//Link is link of Lig that we want download it
    	//Links is list of all link_lig
    	this.id = position;
    	Link=RankGlobalInformation.Links[position];
    	
    	vibre.vibrate(25);				
    	if (db.getExsistedRow(this.id) == 0)
    	{
			if ( isConnectedToInternet() ){
				downloadXmlTask=new DownloadXmlTask();	
				downloadXmlTask.execute();
	
			}
	     	else
	     		Toast.makeText(RankLayout.this,  "اختلال در ارتباط با اینترنت", Toast.LENGTH_SHORT).show();
    	}
    	else 
    	{
    		
    		my_data=RankParserFunctions.Parse(this.id,false); 
    		Intent intent = new Intent(RankLayout.this,Resultshow.class); 
    		intent.putExtra("id", this.id);
    		intent.putExtra("link", Link);
			startActivity(intent);
    	}
    }
	

	/*********************************************************
	 * this class is a useful class that prevent from crashing
	 *  when download of data take very long time
	 *********************************************************/
	
	private class DownloadXmlTask extends AsyncTask<Void, Void, String> {
		
		@Override
	    protected void onPreExecute() {//is automatic run
			showLoading();
	    }
		
		@Override
	    protected String doInBackground(Void... esult) {//msg is sent for argument result 
	        String msg="";
	        Log.d("GET XML",String.valueOf(id));
			msg= RankParserFunctions.getXML(Link);
			return msg;            
	    }
	
	    @Override
	    protected void onPostExecute(String result) { 
		    if (result.length()>100)
		    {//when not internet show the massage that len of it is smaller than 100

		        Log.d("parser function",String.valueOf(id));
		    	my_data=RankParserFunctions.Parse(id,true);
		 		Intent intent = new Intent(RankLayout.this,Resultshow.class); 
	    		intent.putExtra("id", id);
				startActivity(intent);
		    }
		    else 
		    {
		    	Toast.makeText(RankLayout.this, "اختلال در ارتباط با اینترنت", Toast.LENGTH_LONG).show();
		    }
		    stopLoadingAndDownloading();//in this case just stoploading is run
		    
	    }    
	}
	

	/*-----------------------------------------------------------------------------------
	 *  Checking Internet connection. True: connection found, False: connection not found 
	 *  ---------------------------------------------------------------------------------*/
	public boolean isConnectedToInternet(){
	    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	        return true;
	    }
	    return false;
	}
	
	/*-----------------------------------------------------------------------------------
	 *  Showing / Stopping progress dialog which is showing loading animation
	 *  ---------------------------------------------------------------------------------*/
	private void showLoading(){
		progressBar = ProgressDialog.show(RankLayout.this, "", "");
		progressBar.setContentView(R.layout.loading);
		progressBar.setCancelable(false);	
		
		Loading=true;

		final ImageView imageView = (ImageView) progressBar.findViewById(R.id.blankImageView); 
		Animation rotation = AnimationUtils.loadAnimation(RankLayout.this, R.anim.rotate);
		imageView.startAnimation(rotation);
	}
	
	
	private void stopLoadingAndDownloading() {
		Loading=false;
		
		if(progressBar.isShowing())
			progressBar.dismiss();
		
	    if (downloadXmlTask != null && downloadXmlTask.getStatus() != AsyncTask.Status.FINISHED)
	    	downloadXmlTask.cancel(true);
	}
}
