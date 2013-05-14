package com.example.rank;

import java.util.ArrayList;

public class RankData  {
	private static ArrayList<String> TeamName = new ArrayList<String>();
	private static ArrayList<String> GameNo = new ArrayList<String>();
	private static ArrayList<String> PlayWin = new ArrayList<String>();
	private static ArrayList<String> PlayEqual = new ArrayList<String>();
	private static ArrayList<String> PlayFaild = new ArrayList<String>();
	private static ArrayList<String> GoaleZade = new ArrayList<String>();
	private static ArrayList<String> GoaleKhorde = new ArrayList<String>();
	private static ArrayList<String> Tafazol = new ArrayList<String>();
	private static ArrayList<String> Score = new ArrayList<String>();
	
	public static int teamNumber;
	
	public final static void appendTeamName(String Teamame) {
		TeamName.add(Teamame);
	}

	public final static ArrayList<String> getTeamName() {
		return TeamName;
	}
	
	public final static void appendGoaleKhorde(String goal) {
		GoaleKhorde.add(goal);
	}

	public final static void appendGoaleZade(String goal) {
		GoaleZade.add(goal);
	}

	public final static ArrayList<String> getGoaleZade() {
		return GoaleZade;
	}
	public final static ArrayList<String> getGoaleKhorde() {
		return GoaleKhorde;
	}
	public final static ArrayList<String> getTafazol() {
		return Tafazol;
	}
	
	public final static void appendTafazol(String tafazol) {
		Tafazol.add(tafazol);
	}
	
	public final static ArrayList<String> getGameNo() {
		return GameNo;
	}
	public final static void appendGameNo(String GamNo) {
		GameNo.add(GamNo);
	}
	
	public final static ArrayList<String> getPlayWin() {
		return PlayWin;
	}
	public final static void appendPlayWin(String PlaWin) {
		PlayWin.add(PlaWin);
	}
	
	public final static ArrayList<String> getPlayEqual() {
		return PlayEqual;
	}
	public final static void appendPlayEqual(String PlaEqual) {
		PlayEqual.add(PlaEqual);
	}
	
	public final static ArrayList<String> getPlayFaild() {
		return PlayFaild;
	}
	public final static void appendPlayFaild(String PlaFaild) {
		PlayFaild.add(PlaFaild);
	}
	
	public final static ArrayList<String> getScore() {
		return Score;
	}
	public final static void appendScore(String Emtia) {
		Score.add(Emtia);
	}

	public final static void clear() {
		TeamName.clear();
		GameNo.clear();
		PlayWin.clear();
		PlayEqual.clear();
		PlayFaild.clear();
		GoaleZade.clear();
		GoaleKhorde.clear();
		Tafazol.clear();
		Score.clear();
	}	
}