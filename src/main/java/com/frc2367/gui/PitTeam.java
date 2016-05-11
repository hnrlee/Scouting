package com.frc2367.gui;

public class PitTeam {

	int teamNumber;
	int autoBalls;
	int autoCapabilities;
	int teleCapabilities;
	int towerAttack;
	String robotName;
	double speed1;
	double speed2;
	String note;
	boolean[] autoDefenses;
	boolean[] teleDefenses;
	boolean teleHigh;
	boolean teleLow;
	int autoShooter;
	int autoDefenseReach;
	String notes;
	String teamName;

	public PitTeam(boolean[] autoDef, boolean[] teleDef, boolean tH, boolean tL, int autoShoot, int autoDefReach,
			int towerAtt, double sp1, double sp2, String robName, int teamN, String teamName, String note) {
		autoDefenses = autoDef;
		teleDefenses = teleDef;
		teleHigh = tH;
		teleLow = tL;
		autoShooter = autoShoot;
		autoDefenseReach = autoDefReach;
		towerAttack = towerAtt;
		teamNumber = teamN;
		speed1 = sp1;
		speed2 = sp2;
		robotName = robName;
		this.teamName = teamName;
		notes = note;

	}

	// list goes port, cdf, moat, ramp, draw, sally, wall, terr, lowbar
	public boolean[] getAutoDefenses() {
		return autoDefenses;
	}

	public boolean[] getTeleDefenses() {
		return teleDefenses;
	}

	public boolean getTeleHigh() {
		return teleHigh;
	}

	public boolean getTeleLow() {
		return teleLow;
	}

	public int getAutoShooter() {
		return autoShooter;
	}

	public int getAutoDefenseReach() {
		return autoDefenseReach;
	}

	public int getTowerAttackCapability() {
		return towerAttack;
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public double getSpeed1() {
		return speed1;
	}

	public double getSpeed2() {
		return speed2;
	}

	public String getRobotName() {
		return robotName;
	}

	public String getTeamName() {
		return teamName;
	}

	public String getNotes() {
		return notes;
	}

}
