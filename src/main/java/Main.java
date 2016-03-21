import java.util.ArrayList;

import com.frc2367.api.WebApi;
import com.frc2367.data.ScoutedTeam;
import com.frc2367.gui.GUI;

public class Main {
	public static void main(String[] args) {
		ArrayList<ScoutedTeam> teams = new ArrayList<ScoutedTeam>();
		WebApi api = new WebApi("cada", true, teams);
		api.updateData();
		new GUI();
	}
}
