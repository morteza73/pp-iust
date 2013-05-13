package com.example.tv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.perspolisiha.Main;
import com.example.rank.RankGlobalInformation;
import com.example.rank.RankLayout;

import android.util.Log;

public class TVParserFunctions {
	private static String html_text=null;
	private static TVData my_data;
	
	 public static String getXML(String Link){	 	 
			String sentence = "";
				String line = null;
				Log.d("getxml","get");
				try {
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost("http://footballonline.ir/");
					HttpResponse httpResponse = httpClient.execute(httpPost);
					HttpEntity httpEntity = httpResponse.getEntity();
					line = EntityUtils.toString(httpEntity);
				} catch (UnsupportedEncodingException e) {
					line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
				} catch (MalformedURLException e) {
					line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
				} catch (IOException e) {
					line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
				}
				html_text = line;
			return line;
	}

	 @SuppressWarnings("static-access")
	public final static void setDataFromNet(int id){
			String temp= "<hr />";
		 	String tag = "<div>";
			String endTag = "</div>";
		 	my_data.matchNumber = 0;

		 	int startOfWhile = 0 ;
		 	int endOfWhile = 0;
		 	startOfWhile = html_text.indexOf("<strong style=\"float:right;\">برنامه های تلویزیون</strong>");
		 	endOfWhile = 0;
		 
		 	while (true)
		 	{
			 	startOfWhile = html_text.indexOf(temp,startOfWhile + 1);
			 	
				if (startOfWhile == -1)
					 break;
				
			 	my_data.matchNumber++;
		 	}

			int start=0;
		 	int end=0;

		 	startOfWhile = html_text.indexOf("<strong style=\"float:right;\">برنامه های تلویزیون</strong>");
		 	endOfWhile = html_text.indexOf("<div class=\"w-footer\"></div>", html_text.indexOf(temp,startOfWhile + 1));

			 Log.d("TEAM NUMBERE ALAN1",String.valueOf(my_data.matchNumber));
		 	 Main.db.clearTable(0);
			 Log.d("TEAM NUMBERE ALAN2",String.valueOf(my_data.matchNumber));

			 for (int i = 0 ; i < my_data.matchNumber;i++)
		 	{
				
				Log.d("TEAM NUMBERE ALAN5",String.valueOf(my_data.matchNumber));
			 	start = startOfWhile;
			 	TVInfo TV = new TVInfo();
			 	TV.matchNumber = my_data.matchNumber;
			 	
			 	start=html_text.indexOf(tag, start)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	my_data.addTime(html_text.substring(start, end));
			 	TV.addTime(html_text.substring(start, end));
			 	
			 	start=html_text.indexOf(tag, start+1)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	my_data.addGame(html_text.substring(start, end));
			 	TV.addGame(html_text.substring(start, end));

			 	startOfWhile = html_text.indexOf(temp,startOfWhile + 1);
			 	

			 	Main.db.updateLeagueInfo(0,TV);
			}
			 Log.d("TEAM NUMBERE ALAN2",String.valueOf(my_data.matchNumber));

	 }
	 
	 @SuppressWarnings("static-access")
	public final static void setDataFromSQL(int id)
	 {
		 ArrayList<TVInfo> TV = new ArrayList<TVInfo>();
		 TV = Main.db.getInfo(0);
		 
		 my_data.matchNumber = Main.db.getExsistedRow(0);
		 
		 for (int i = 0;i < my_data.matchNumber;i++)
		 {
				Log.d("teamName",TV.get(i).getTime());
				Log.d("gameNo",TV.get(i).getGame());
			 	my_data.addTime(TV.get(i).getTime());
			 	my_data.addGame(TV.get(i).getGame());
		 }
		 
	 }
	 
	 public final static TVData Parse(int id,boolean isNet)
	 {
		 if (isNet)
			 setDataFromNet(id);
		 else 
			 setDataFromSQL(id);

		 
		 return my_data;
	 }
}