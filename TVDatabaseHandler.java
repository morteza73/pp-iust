package com.example.tv;

import java.util.ArrayList;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TextView;

public class TVDatabaseHandler {
	private final String TAG = "databaseHandler";
	static final String TIME = "time";
	static final String GAME = "game";
	
	private TVDatabaseHelper dbHelper;
	private SQLiteDatabase database;
	
	public TVDatabaseHandler(Context context)
	{
		dbHelper = new TVDatabaseHelper(context);
	}
	
	public void open()
	{
		database = dbHelper.getWritableDatabase();
	}

	public void close()
	{
		dbHelper.close();
	}

	public void updateLeagueInfo(int id, TVInfo TV)
	{
		//LeagueInfo LF = new LeagueInfo();
		Log.d("IN UPDATE","sa");
		ContentValues cv = new ContentValues();
		Log.d(TV.getTime(),"team name");
		cv.put(TIME, TV.getTime());
		cv.put(GAME, TV.getGame());
		database.insert("tv", null, cv);
		//database.insert(globalInformation.items[id],null, cv);	
		
	}
	
	public void deleteLeagueInfo(int id)	{
		database.delete("tv",null,null);
	}
	
	public void clearTable(int id)	{
		Log.d("ghablesh","a");
		database.delete("tv", null, null);
		Log.d("Badesh","b");
	}
	
	public ArrayList<TVInfo> getInfo(int id){
		
		ArrayList<TVInfo> TV = new ArrayList<TVInfo>();
		Cursor cursor = database.query("tv",null, null, null, null, null, null);
		cursor.moveToFirst();

		while(!cursor.isAfterLast()){
			TVInfo l = cursorToTVInfo(cursor);
			TV.add(l);
			cursor.moveToNext();
		}
		return TV;
	}
	
	private TVInfo cursorToTVInfo(Cursor cursor)
	{
		TVInfo TV = new TVInfo();
		
		TV.addTime(cursor.getString(0)); 
		TV.addGame(cursor.getString(1));
		
		return TV;
	}
	
	public int getExsistedRow(int id)
	{
		int counter = 0;
		Cursor cursor = database.query("tv",null, null, null, null, null, null);
		Log.d("A","ASAFWQ1");
		cursor.moveToFirst();
		Log.d("A","ASAFWQ1");
		while(!cursor.isAfterLast()){
			Log.d("A","ASAFWQ1");
			counter++;
			Log.d("A","ASAFWQ1");
			cursor.moveToNext();
		}
		Log.d("A",String.valueOf(counter));
		return counter;
	}
}
