package com.example.tv;

import java.util.ArrayList;

import android.util.Log;

public class TVData  {
	private static ArrayList<String> time = new ArrayList<String>();
	private static ArrayList<String> game = new ArrayList<String>();
	public static int matchNumber;
	
	public final static void addTime(String Teamame) {
		time.add(Teamame);
	}

	public final static ArrayList<String> getTime() {
		return time;
	}
	
	public final static void addGame(String goal) {
		game.add(goal);
	}

	public final static ArrayList<String> getGame() {
		return game;
	}

	
	public final static void clear() {
		time.clear();
		game.clear();
	}	
}