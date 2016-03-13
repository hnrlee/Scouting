package team;

public class Team {

	// Defense Booleans
	// Underscore denotes autonomous ability

	// Cat A
	private boolean port, cdf, port_, cdf_;
	// Cat B
	private boolean moat, ramp, moat_, ramp_;
	// Cat C
	private boolean draw, sally, draw_, sally_;
	// Cat D
	private boolean wall, terr, wall_, terr_;
	// Cat E
	private boolean lowbar, lowbar_;

	// Game Functions
	// Underscore denotes autonomous ability
	private boolean climb, highGoal, lowGoal, highGoal_, lowGoal_, autoReachDef;

	// Robot Info
	private String name, notes;
	private double speed1, speed2;// (in feet per second)
	private int teamNum;

	/*
	 * TODO: Add match data, not just pit data
	 */

	private void autoCapability(boolean p, boolean c, boolean m, boolean r, boolean d, boolean s, boolean w, boolean t,
			boolean l) {
		setPort_(p);
		setCdf_(c);
		setMoat_(m);
		setRamp_(r);
		setDraw_(d);
		setSally_(s);
		setWall_(w);
		setTerr_(t);
		setLowbar_(l);
	}

	private void teleCapability(boolean p, boolean c, boolean m, boolean r, boolean d, boolean s, boolean w, boolean t,
			boolean l) {
		setPort(p);
		setCdf(c);
		setMoat(m);
		setRamp(r);
		setDraw(d);
		setSally(s);
		setWall(w);
		setTerr(t);
		setLowbar(l);
	}

	public boolean isPort() {
		return port;
	}

	public void setPort(boolean port) {
		this.port = port;
	}

	public boolean isCdf() {
		return cdf;
	}

	public void setCdf(boolean cdf) {
		this.cdf = cdf;
	}

	public boolean isPort_() {
		return port_;
	}

	public void setPort_(boolean port_) {
		this.port_ = port_;
	}

	public boolean isCdf_() {
		return cdf_;
	}

	public void setCdf_(boolean cdf_) {
		this.cdf_ = cdf_;
	}

	public boolean isMoat() {
		return moat;
	}

	public void setMoat(boolean moat) {
		this.moat = moat;
	}

	public boolean isRamp() {
		return ramp;
	}

	public void setRamp(boolean ramp) {
		this.ramp = ramp;
	}

	public boolean isMoat_() {
		return moat_;
	}

	public void setMoat_(boolean moat_) {
		this.moat_ = moat_;
	}

	public boolean isRamp_() {
		return ramp_;
	}

	public void setRamp_(boolean ramp_) {
		this.ramp_ = ramp_;
	}

	public boolean isDraw() {
		return draw;
	}

	public void setDraw(boolean draw) {
		this.draw = draw;
	}

	public boolean isSally() {
		return sally;
	}

	public void setSally(boolean sally) {
		this.sally = sally;
	}

	public boolean isDraw_() {
		return draw_;
	}

	public void setDraw_(boolean draw_) {
		this.draw_ = draw_;
	}

	public boolean isSally_() {
		return sally_;
	}

	public void setSally_(boolean sally_) {
		this.sally_ = sally_;
	}

	public boolean isWall() {
		return wall;
	}

	public void setWall(boolean wall) {
		this.wall = wall;
	}

	public boolean isTerr() {
		return terr;
	}

	public void setTerr(boolean terr) {
		this.terr = terr;
	}

	public boolean isWall_() {
		return wall_;
	}

	public void setWall_(boolean wall_) {
		this.wall_ = wall_;
	}

	public boolean isTerr_() {
		return terr_;
	}

	public void setTerr_(boolean terr_) {
		this.terr_ = terr_;
	}

	public boolean isLowbar() {
		return lowbar;
	}

	public void setLowbar(boolean lowbar) {
		this.lowbar = lowbar;
	}

	public boolean isLowbar_() {
		return lowbar_;
	}

	public void setLowbar_(boolean lowbar_) {
		this.lowbar_ = lowbar_;
	}

	public boolean isClimb() {
		return climb;
	}

	public void setClimb(boolean climb) {
		this.climb = climb;
	}

	public boolean isHighGoal() {
		return highGoal;
	}

	public void setHighGoal(boolean highGoal) {
		this.highGoal = highGoal;
	}

	public boolean isLowGoal() {
		return lowGoal;
	}

	public void setLowGoal(boolean lowGoal) {
		this.lowGoal = lowGoal;
	}

	public boolean isHighGoal_() {
		return highGoal_;
	}

	public void setHighGoal_(boolean highGoal_) {
		this.highGoal_ = highGoal_;
	}

	public boolean isLowGoal_() {
		return lowGoal_;
	}

	public void setLowGoal_(boolean lowGoal_) {
		this.lowGoal_ = lowGoal_;
	}

	public boolean isAutoReachDef() {
		return autoReachDef;
	}

	public void setAutoReachDef(boolean autoReachDef) {
		this.autoReachDef = autoReachDef;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getSpeed1() {
		return speed1;
	}

	public void setSpeed1(double speed1) {
		this.speed1 = speed1;
	}

	public double getSpeed2() {
		return speed2;
	}

	public void setSpeed2(double speed2) {
		this.speed2 = speed2;
	}

	public int getTeamNum() {
		return teamNum;
	}

	public void setTeamNum(int teamNum) {
		this.teamNum = teamNum;
	}

}
