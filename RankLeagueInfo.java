package com.example.rank;


public class RankLeagueInfo  {
	private String TeamName = new String();
	private String GameNo = new String();
	private String PlayWin = new String();
	private String PlayEqual = new String();
	private String PlayFaild = new String();
	private String GoaleZade = new String();
	private String GoaleKhorde = new String();
	private String Tafazol = new String();
	private String Score = new String();

	
	public int teamNumber;
	
	public final void appendTeamName(String Teamame) {
		TeamName = Teamame;
	}

	public final String getTeamName() {
		return TeamName;
	}
	
	public final void appendGoaleKhorde(String goal) {
		GoaleKhorde = goal ;
	}

	public final void appendGoaleZade(String goal) {
		GoaleZade = goal;
	}

	public final String getGoaleZade() {
		return GoaleZade;
	}
	public final String getGoaleKhorde() {
		return GoaleKhorde;
	}
	public final String getTafazol() {
		return Tafazol;
	}
	
	public final void appendTafazol(String tafazol) {
		Tafazol = tafazol;
	}
	
	public final String getGameNo() {
		return GameNo;
	}
	public final void appendGameNo(String GamNo) {
		GameNo = GamNo;
	}
	
	public final String getPlayWin() {
		return PlayWin;
	}
	public final void appendPlayWin(String PlaWin) {
		PlayWin = PlaWin;
	}
	
	public final String getPlayEqual() {
		return PlayEqual;
	}
	public final void appendPlayEqual(String PlaEqual) {
		PlayEqual = PlaEqual;
	}
	
	public final String getPlayFaild() {
		return PlayFaild;
	}
	public final void appendPlayFaild(String PlaFaild) {
		PlayFaild = PlaFaild;
	}
	
	public final String getScore() {
		return Score;
	}
	public final void appendScore(String Emtia) {
		Score = Emtia;
	}

	public final void clear() {
		TeamName = "";
		GameNo = "";
		PlayWin = "";
		PlayEqual = "";
		PlayFaild = "";
		GoaleZade = "";
		GoaleKhorde = "";
		Tafazol = "";
		Score = "";
	}	
}