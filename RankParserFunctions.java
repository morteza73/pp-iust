package com.example.rank;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.rank.RankGlobalInformation;

import android.util.Log;

public class RankParserFunctions {
	private static String html_text=null;
	private static RankData my_data;

	 public static String getXML(String Link){	 	 
			//String sentence = "";
				String line = null;
				Log.d("getxml","get");
				try {
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost("http://footballonline.ir/AllTable.aspx");
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
			String temp= "<tr style=\" font-family:";
		 	//String tag = "<td class=\"";
		 	String tag = "<td>";
			String endTag = "<";
		 	my_data.teamNumber = 0;

		 	int startOfWhile = 0 ;
		 	int endOfWhile = 0;
		 	startOfWhile = html_text.indexOf(RankGlobalInformation.Links[id]);
		 	endOfWhile = html_text.indexOf("</tr>", html_text.indexOf(temp,startOfWhile + 1));

		 	while (html_text.indexOf(temp, endOfWhile)!=-1   &&
		 			html_text.indexOf(temp, endOfWhile) < html_text.indexOf("</div>", endOfWhile))
		 	{
		 		Log.d("INAJ","as");
			 	startOfWhile = html_text.indexOf(temp,startOfWhile + 1);
			 	my_data.teamNumber++;
			 	endOfWhile = html_text.indexOf("</tr>", startOfWhile);
		 	}

	 		Log.d("team n",String.valueOf(my_data.teamNumber));
			int start=0;
		 	int end=0;
		 	startOfWhile = html_text.indexOf(RankGlobalInformation.Links[id]);
		 	endOfWhile = html_text.indexOf("</tr>", html_text.indexOf(temp,startOfWhile + 1));
		 	RankLayout.db.clearTable(id);
		 	
		 	while (html_text.indexOf(temp, endOfWhile)!=-1 &&
		 			html_text.indexOf(temp, endOfWhile) < html_text.indexOf("</div>", endOfWhile) )
		 	{
		 		Log.d("dive ??? ",String.valueOf(html_text.indexOf("</div>", endOfWhile)));
		 		Log.d("temp ??? ",String.valueOf(html_text.indexOf(temp, endOfWhile)));
			 	startOfWhile = html_text.indexOf(temp,startOfWhile + 1);
			 	start = startOfWhile;
			 	RankLeagueInfo lf = new RankLeagueInfo();
			 	lf.teamNumber = my_data.teamNumber;

			 	//it is added because footballonline first td is for the ranking! 
			 	start=html_text.indexOf(tag, start)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	
			 	start=html_text.indexOf(tag, start)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	Log.d(html_text.substring(start, end),"name");
			 	my_data.appendTeamName(ChangeNegetive(html_text.substring(start, end)));
			 	Log.d("TEAM NAME",ChangeNegetive(html_text.substring(start, end)));
			 	lf.appendTeamName(ChangeNegetive(html_text.substring(start, end)));
			 	
			 	start=html_text.indexOf(tag, start+1)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	my_data.appendGameNo(ChangeNegetive(html_text.substring(start, end)));
			 	lf.appendGameNo(ChangeNegetive(html_text.substring(start, end)));

			 	start=html_text.indexOf(tag, start+1)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	my_data.appendPlayWin(ChangeNegetive(html_text.substring(start, end)));
			 	lf.appendPlayWin(ChangeNegetive(html_text.substring(start, end)));

			 	start=html_text.indexOf(tag, start+1)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	my_data.appendPlayFaild(ChangeNegetive(html_text.substring(start, end)));
			 	lf.appendPlayFaild(ChangeNegetive(html_text.substring(start, end)));

			 	start=html_text.indexOf(tag, start+1)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	my_data.appendPlayEqual(ChangeNegetive(html_text.substring(start, end)));
			 	Log.d("EQUALESH",ChangeNegetive(html_text.substring(start, end)));
			 	lf.appendPlayEqual(ChangeNegetive(html_text.substring(start, end)));

			 	start=html_text.indexOf(tag, start+1)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	my_data.appendGoaleZade(ChangeNegetive(html_text.substring(start, end)));
			 	lf.appendGoaleZade(ChangeNegetive(html_text.substring(start, end)));

			 	start=html_text.indexOf(tag, start+1)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	my_data.appendGoaleKhorde(ChangeNegetive(html_text.substring(start, end)));
			 	lf.appendGoaleKhorde(ChangeNegetive(html_text.substring(start, end)));

			 	start=html_text.indexOf(tag, start+1)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	my_data.appendTafazol(ChangeNegetive(html_text.substring(start, end)));
			 	lf.appendTafazol(ChangeNegetive(html_text.substring(start, end)));
			 	//lf.appendTafazol("FFF");
	 					
			 	start=html_text.indexOf(tag, start+1)+tag.length();
			 	end=html_text.indexOf(endTag, start+1);
			 	my_data.appendScore(ChangeNegetive(html_text.substring(start, end)));
			 	lf.appendScore(ChangeNegetive(html_text.substring(start, end)));
			 	Log.d("SCORESH ?",ChangeNegetive(html_text.substring(start, end)));
			 	
			 	endOfWhile = html_text.indexOf("</tr>", startOfWhile);
			 	RankLayout.db.updateLeagueInfo(id,lf);
			}
	 }
	 
	 private final static String ChangeNegetive(String old)
	 {
		 if(old.charAt(old.length()-1)=='-')
		 {
			 String new_string="-";
			 new_string +=old.substring(0, old.length()-1);
			 return new_string ;			 
			 
		 }
		 return old;
		 
	 }
	 
	 @SuppressWarnings("static-access")
	public final static void setDataFromSQL(int id)
	 {
		 ArrayList<RankLeagueInfo> lf = new ArrayList<RankLeagueInfo>();
		 lf = RankLayout.db.getInfo(id);
		 
		 my_data.teamNumber = RankLayout.db.getExsistedRow(id);
		 Log.d("TEAM NUMBERE ALAN",String.valueOf(my_data.teamNumber));
		 
		 for (int i = 0;i < my_data.teamNumber;i++)
		 {
			 
			 Log.d(lf.get(i).getTeamName(),"teamName");
			 Log.d(lf.get(i).getGameNo(),"gameNo");
			 Log.d(lf.get(i).getPlayWin(),"win");
			 Log.d(lf.get(i).getPlayEqual(),"eq");
			 Log.d(lf.get(i).getPlayFaild(),"los");
			 Log.d(lf.get(i).getGoaleZade(),"zade");
			 Log.d(lf.get(i).getGoaleKhorde(),"khor");
			 Log.d(lf.get(i).getTafazol(),"tafaz");
			 Log.d(lf.get(i).getScore(),"score");
		 	my_data.appendTeamName(lf.get(i).getTeamName());
		 	my_data.appendGameNo(lf.get(i).getGameNo());
		 	my_data.appendPlayWin(lf.get(i).getPlayWin());
		 	my_data.appendPlayEqual(lf.get(i).getPlayEqual());
		 	my_data.appendPlayFaild(lf.get(i).getPlayFaild());
		 	my_data.appendGoaleZade(lf.get(i).getGoaleZade());
		 	my_data.appendGoaleKhorde(lf.get(i).getGoaleKhorde());
		 	my_data.appendTafazol(lf.get(i).getTafazol());
		 	my_data.appendScore(lf.get(i).getScore());
		 }
	 }
	 
	 public final static RankData Parse(int id,boolean isNet)
	 {
		 if (isNet)
			 setDataFromNet(id);
		 else 
			 setDataFromSQL(id);

		 
		 return my_data;
	 }
}