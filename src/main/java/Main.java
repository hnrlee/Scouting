import com.frc2367.api.WebApi;
import com.frc2367.gui.GUI;

public class Main {
	public static void main(String[] args) {
		WebApi api = new WebApi();
		api.getTeams("2010sac");
		new GUI();
	}
}
