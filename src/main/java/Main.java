import com.frc2367.api.WebApi;
import com.frc2367.gui.GUI;

public class Main {
	public static void main(String[] args) {
		WebApi api = new WebApi("cada");
		System.out.println("Getting teams");
		api.getTeams();
		System.out.println("Getting events");
		api.getEvents();
		System.out.println("Getting matches");
		api.getMatchDetails("CAMA", 254, "qual");
		System.out.println("Getting ranks");
		api.getRanks("CADA");
		new GUI();
	}
}
