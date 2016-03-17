import com.frc2367.api.WebApi;
import com.frc2367.gui.GUI;

public class Main {
	public static void main(String[] args) {
		WebApi api = new WebApi("2016sac");
		api.getTeams();
		api.getEvents();
		api.getMatchDetails("CAMA", 254, "qual");
		new GUI();
	}
}
