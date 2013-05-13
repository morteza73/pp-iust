package com.example.tv;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TVDatabaseHelper extends SQLiteOpenHelper
{

	private final 			String 	TAG 			 = "databaseHelper";
	private static final	String 	DATABASE_NAME	 = "tvDb";
	private static	String 	TABLE_NAME		 		 = "tv";
	private static final	String 	COLUMN_ID		 = "_id";

		
	public TVDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 4);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE  = "CREATE TABLE IF NOT EXISTS " +
				TABLE_NAME + " (time TEXT,game TEXT);";

		Log.d(TAG,"On Created");
			
		db.execSQL(CREATE_TABLE);
		
		Log.i(TAG,"On Created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		String CREATE_TABLE  = "CREATE TABLE IF NOT EXISTS " +
				TABLE_NAME + " (time TEXT,game TEXT);";
				
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
		db.execSQL(CREATE_TABLE);
		
	}
	
	public String getRowIdName()
	{
		return COLUMN_ID;
	}

}