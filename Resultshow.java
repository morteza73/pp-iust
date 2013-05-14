package com.example.rank;

import java.util.ArrayList;
import com.example.perspolisiha.R;
import com.example.rank.RankGlobalInformation;
//import com.example.iran.Start.DownloadXmlTask;


//import com.example.iran.Start.DownloadXmlTask;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Resultshow extends Activity {
	public static String league;

	ArrayList<TextView> name = new ArrayList<TextView>();;
	ArrayList<TextView> game = new ArrayList<TextView>();;
	ArrayList<TextView> won = new ArrayList<TextView>();;
	ArrayList<TextView> equl = new ArrayList<TextView>();;
	ArrayList<TextView> lost = new ArrayList<TextView>();;
	ArrayList<TextView> zade = new ArrayList<TextView>();;
	ArrayList<TextView> khorde = new ArrayList<TextView>();;
	ArrayList<TextView> tafazol = new ArrayList<TextView>();;
	ArrayList<TextView> score = new ArrayList<TextView>();;
	DownloadXmlTask 	downloadXmlTask;
	private int id;
	private String Link;
	private			 ProgressDialog 	progressBar;
	private			 Animation 			rotation;
	private			 Boolean			Loading=false;
	private 		 Vibrator 			vibre;
	Button        backBtn;
	Button 		 updateButton ;
	TextView         title;
	@SuppressWarnings("static-access")
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		id = getIntent().getExtras().getInt("id");
		Link = getIntent().getExtras().getString("link");
		if ( RankLayout.my_data.teamNumber == 18)
			setContentView(R.layout.resultshow_18);	
		else if ( RankLayout.my_data.teamNumber == 20)
			setContentView(R.layout.resultshow_20);	
		else
			setContentView(R.layout.resultshow_error);	
		
		initilizer();
		setData();
		updateButton = (Button) findViewById(R.id.update);
		updateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("onclick", "AA");
				if ( isConnectedToInternet() ){
					downloadXmlTask=new DownloadXmlTask();	
					downloadXmlTask.execute();
		
				}
		     	else
		     		Toast.makeText(Resultshow.this,  "اختلال در ارتباط با اینترنت", Toast.LENGTH_SHORT).show();
	    	
			}
		});
		title = (TextView) findViewById(R.id.title_name);
		title.setText(RankGlobalInformation.persianItems[id]);
		backBtn = (Button) findViewById(R.id.backward);
		backBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
	
	@SuppressWarnings("static-access")
	public void setData()
	{
		for (int i = 0 ; i < RankLayout.my_data.teamNumber ; i++)
		{
			name.get(i).setText(RankLayout.my_data.getTeamName().get(i));
			game.get(i).setText(RankLayout.my_data.getGameNo().get(i));
			won.get(i).setText(RankLayout.my_data.getPlayWin().get(i));
			equl.get(i).setText(RankLayout.my_data.getPlayEqual().get(i));
			lost.get(i).setText(RankLayout.my_data.getPlayFaild().get(i));
			zade.get(i).setText(RankLayout.my_data.getGoaleZade().get(i));
			khorde.get(i).setText(RankLayout.my_data.getGoaleKhorde().get(i));
			tafazol.get(i).setText(RankLayout.my_data.getTafazol().get(i));		
			score.get(i).setText(RankLayout.my_data.getScore().get(i));
			
			
		}
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		RankLayout.db.open();
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		RankLayout.db.close();
		RankLayout.my_data.clear();
	}
	
	void initilizer()
	{
		
		name.add((TextView) findViewById(R.id.name0));
		name.add((TextView) findViewById(R.id.name1));
		name.add((TextView) findViewById(R.id.name2));
		name.add((TextView) findViewById(R.id.name3));
		name.add((TextView) findViewById(R.id.name4));
		name.add((TextView) findViewById(R.id.name5));
		name.add((TextView) findViewById(R.id.name6));
		name.add((TextView) findViewById(R.id.name7));
		name.add((TextView) findViewById(R.id.name8));
		name.add((TextView) findViewById(R.id.name9));
		name.add((TextView) findViewById(R.id.name10));
		name.add((TextView) findViewById(R.id.name11));
		name.add((TextView) findViewById(R.id.name12));
		name.add((TextView) findViewById(R.id.name13));
		name.add((TextView) findViewById(R.id.name14));
		name.add((TextView) findViewById(R.id.name15));
		name.add((TextView) findViewById(R.id.name16));
		name.add((TextView) findViewById(R.id.name17));
		name.add((TextView) findViewById(R.id.name18));
		name.add((TextView) findViewById(R.id.name19));

		game.add((TextView) findViewById(R.id.game0));
		game.add((TextView) findViewById(R.id.game1));
		game.add((TextView) findViewById(R.id.game2));
		game.add((TextView) findViewById(R.id.game3));
		game.add((TextView) findViewById(R.id.game4));
		game.add((TextView) findViewById(R.id.game5));
		game.add((TextView) findViewById(R.id.game6));
		game.add((TextView) findViewById(R.id.game7));
		game.add((TextView) findViewById(R.id.game8));
		game.add((TextView) findViewById(R.id.game9));
		game.add((TextView) findViewById(R.id.game10));
		game.add((TextView) findViewById(R.id.game11));
		game.add((TextView) findViewById(R.id.game12));
		game.add((TextView) findViewById(R.id.game13));
		game.add((TextView) findViewById(R.id.game14));
		game.add((TextView) findViewById(R.id.game15));
		game.add((TextView) findViewById(R.id.game16));
		game.add((TextView) findViewById(R.id.game17));
		game.add((TextView) findViewById(R.id.game18));
		game.add((TextView) findViewById(R.id.game19));
		

		won.add((TextView) findViewById(R.id.won0));
		won.add((TextView) findViewById(R.id.won1));
		won.add((TextView) findViewById(R.id.won2));
		won.add((TextView) findViewById(R.id.won3));
		won.add((TextView) findViewById(R.id.won4));
		won.add((TextView) findViewById(R.id.won5));
		won.add((TextView) findViewById(R.id.won6));
		won.add((TextView) findViewById(R.id.won7));
		won.add((TextView) findViewById(R.id.won8));
		won.add((TextView) findViewById(R.id.won9));
		won.add((TextView) findViewById(R.id.won10));
		won.add((TextView) findViewById(R.id.won11));
		won.add((TextView) findViewById(R.id.won12));
		won.add((TextView) findViewById(R.id.won13));
		won.add((TextView) findViewById(R.id.won14));
		won.add((TextView) findViewById(R.id.won15));
		won.add((TextView) findViewById(R.id.won16));
		won.add((TextView) findViewById(R.id.won17));
		won.add((TextView) findViewById(R.id.won18));
		won.add((TextView) findViewById(R.id.won19));

		equl.add((TextView) findViewById(R.id.equl0));
		equl.add((TextView) findViewById(R.id.equl1));
		equl.add((TextView) findViewById(R.id.equl2));
		equl.add((TextView) findViewById(R.id.equl3));
		equl.add((TextView) findViewById(R.id.equl4));
		equl.add((TextView) findViewById(R.id.equl5));
		equl.add((TextView) findViewById(R.id.equl6));
		equl.add((TextView) findViewById(R.id.equl7));
		equl.add((TextView) findViewById(R.id.equl8));
		equl.add((TextView) findViewById(R.id.equl9));
		equl.add((TextView) findViewById(R.id.equl10));
		equl.add((TextView) findViewById(R.id.equl11));
		equl.add((TextView) findViewById(R.id.equl12));
		equl.add((TextView) findViewById(R.id.equl13));
		equl.add((TextView) findViewById(R.id.equl14));
		equl.add((TextView) findViewById(R.id.equl15));
		equl.add((TextView) findViewById(R.id.equl16));
		equl.add((TextView) findViewById(R.id.equl17));
		equl.add((TextView) findViewById(R.id.equl18));
		equl.add((TextView) findViewById(R.id.equl19));
		
		lost.add((TextView) findViewById(R.id.lost0));
		lost.add((TextView) findViewById(R.id.lost1));
		lost.add((TextView) findViewById(R.id.lost2));
		lost.add((TextView) findViewById(R.id.lost3));
		lost.add((TextView) findViewById(R.id.lost4));
		lost.add((TextView) findViewById(R.id.lost5));
		lost.add((TextView) findViewById(R.id.lost6));
		lost.add((TextView) findViewById(R.id.lost7));
		lost.add((TextView) findViewById(R.id.lost8));
		lost.add((TextView) findViewById(R.id.lost9));
		lost.add((TextView) findViewById(R.id.lost10));
		lost.add((TextView) findViewById(R.id.lost11));
		lost.add((TextView) findViewById(R.id.lost12));
		lost.add((TextView) findViewById(R.id.lost13));
		lost.add((TextView) findViewById(R.id.lost14));
		lost.add((TextView) findViewById(R.id.lost15));
		lost.add((TextView) findViewById(R.id.lost16));
		lost.add((TextView) findViewById(R.id.lost17));
		lost.add((TextView) findViewById(R.id.lost18));
		lost.add((TextView) findViewById(R.id.lost19));


		khorde.add((TextView) findViewById(R.id.khorde0));
		khorde.add((TextView) findViewById(R.id.khorde1));
		khorde.add((TextView) findViewById(R.id.khorde2));
		khorde.add((TextView) findViewById(R.id.khorde3));
		khorde.add((TextView) findViewById(R.id.khorde4));
		khorde.add((TextView) findViewById(R.id.khorde5));
		khorde.add((TextView) findViewById(R.id.khorde6));
		khorde.add((TextView) findViewById(R.id.khorde7));
		khorde.add((TextView) findViewById(R.id.khorde8));
		khorde.add((TextView) findViewById(R.id.khorde9));
		khorde.add((TextView) findViewById(R.id.khorde10));
		khorde.add((TextView) findViewById(R.id.khorde11));
		khorde.add((TextView) findViewById(R.id.khorde12));
		khorde.add((TextView) findViewById(R.id.khorde13));
		khorde.add((TextView) findViewById(R.id.khorde14));
		khorde.add((TextView) findViewById(R.id.khorde15));
		khorde.add((TextView) findViewById(R.id.khorde16));
		khorde.add((TextView) findViewById(R.id.khorde17));
		khorde.add((TextView) findViewById(R.id.khorde18));
		khorde.add((TextView) findViewById(R.id.khorde19));

		zade.add((TextView) findViewById(R.id.zade0));
		zade.add((TextView) findViewById(R.id.zade1));
		zade.add((TextView) findViewById(R.id.zade2));
		zade.add((TextView) findViewById(R.id.zade3));
		zade.add((TextView) findViewById(R.id.zade4));
		zade.add((TextView) findViewById(R.id.zade5));
		zade.add((TextView) findViewById(R.id.zade6));
		zade.add((TextView) findViewById(R.id.zade7));
		zade.add((TextView) findViewById(R.id.zade8));
		zade.add((TextView) findViewById(R.id.zade9));
		zade.add((TextView) findViewById(R.id.zade10));
		zade.add((TextView) findViewById(R.id.zade11));
		zade.add((TextView) findViewById(R.id.zade12));
		zade.add((TextView) findViewById(R.id.zade13));
		zade.add((TextView) findViewById(R.id.zade14));
		zade.add((TextView) findViewById(R.id.zade15));
		zade.add((TextView) findViewById(R.id.zade16));
		zade.add((TextView) findViewById(R.id.zade17));
		zade.add((TextView) findViewById(R.id.zade18));
		zade.add((TextView) findViewById(R.id.zade19));

		tafazol.add((TextView) findViewById(R.id.tafazol0));
		tafazol.add((TextView) findViewById(R.id.tafazol1));
		tafazol.add((TextView) findViewById(R.id.tafazol2));
		tafazol.add((TextView) findViewById(R.id.tafazol3));
		tafazol.add((TextView) findViewById(R.id.tafazol4));
		tafazol.add((TextView) findViewById(R.id.tafazol5));
		tafazol.add((TextView) findViewById(R.id.tafazol6));
		tafazol.add((TextView) findViewById(R.id.tafazol7));
		tafazol.add((TextView) findViewById(R.id.tafazol8));
		tafazol.add((TextView) findViewById(R.id.tafazol9));
		tafazol.add((TextView) findViewById(R.id.tafazol10));
		tafazol.add((TextView) findViewById(R.id.tafazol11));
		tafazol.add((TextView) findViewById(R.id.tafazol12));
		tafazol.add((TextView) findViewById(R.id.tafazol13));
		tafazol.add((TextView) findViewById(R.id.tafazol14));
		tafazol.add((TextView) findViewById(R.id.tafazol15));
		tafazol.add((TextView) findViewById(R.id.tafazol16));
		tafazol.add((TextView) findViewById(R.id.tafazol17));
		tafazol.add((TextView) findViewById(R.id.tafazol18));
		tafazol.add((TextView) findViewById(R.id.tafazol19));

		score.add((TextView) findViewById(R.id.score0));
		score.add((TextView) findViewById(R.id.score1));
		score.add((TextView) findViewById(R.id.score2));
		score.add((TextView) findViewById(R.id.score3));
		score.add((TextView) findViewById(R.id.score4));
		score.add((TextView) findViewById(R.id.score5));
		score.add((TextView) findViewById(R.id.score6));
		score.add((TextView) findViewById(R.id.score7));
		score.add((TextView) findViewById(R.id.score8));
		score.add((TextView) findViewById(R.id.score9));
		score.add((TextView) findViewById(R.id.score10));
		score.add((TextView) findViewById(R.id.score11));
		score.add((TextView) findViewById(R.id.score12));
		score.add((TextView) findViewById(R.id.score13));
		score.add((TextView) findViewById(R.id.score14));
		score.add((TextView) findViewById(R.id.score15));
		score.add((TextView) findViewById(R.id.score16));
		score.add((TextView) findViewById(R.id.score17));
		score.add((TextView) findViewById(R.id.score18));
		score.add((TextView) findViewById(R.id.score19));
	}
	/****************************/

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
	
	    @SuppressWarnings("static-access")
		@Override
	    protected void onPostExecute(String result) { 
		    if (result.length()>100)
		    {//when not internet show the massage that len of it is smaller than 100

		        Log.d("parser function",String.valueOf(id));
		        RankLayout.my_data.clear();
		    	RankLayout.my_data=RankParserFunctions.Parse(id,true);
		    	Log.d(RankLayout.my_data.getTafazol().get(1),"bebina");
			    setData();
		    	Toast.makeText(Resultshow.this, "اطلاعات به روز شد", Toast.LENGTH_LONG).show();
		    }
		    else 
		    {
		    	Toast.makeText(Resultshow.this, "اختلال در ارتباط با اینترنت", Toast.LENGTH_LONG).show();
		    }
		    stopLoadingAndDownloading();//in this case just stoploading is run
	 		//Intent intent = new Intent(Resultshow.this,Resultshow.class); 
			//startActivity(intent);
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
		progressBar = ProgressDialog.show(Resultshow.this, "", "");
		progressBar.setContentView(R.layout.loading);
		progressBar.setCancelable(false);	
		
		Loading=true;
		
		final ImageView imageView = (ImageView) progressBar.findViewById(R.id.blankImageView); 
		Animation rotation = AnimationUtils.loadAnimation(Resultshow.this, R.anim.rotate);
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
