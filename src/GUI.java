import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GUI {
	private JFrame mainFrame = new JFrame("The Dankest Scouting App");
	private JTabbedPane tabs = new JTabbedPane();
	private JPanel pitData = new JPanel(new GridLayout(3, 3));
	private JPanel teamMatchData = new JPanel(new GridLayout(3, 3));
	private JPanel fullMatchData = new JPanel(new GridLayout(3, 3));
	private JPanel basicStatPanel = new JPanel(new GridLayout(3, 3));

	private ImageIcon pitDataIcon = new ImageIcon("FIRST Logo.gif");
	private ImageIcon teamMatchDataIcon = new ImageIcon("FIRST Logo.gif");
	private ImageIcon fullMatchDataIcon = new ImageIcon("FIRST Logo.gif");
	private ImageIcon basicStatPanelIcon = new ImageIcon("FIRST Logo.gif");

	public GUI() {

		tabs.addTab("Pit Data", pitDataIcon, pitData, "Enter pit data here.");
		tabs.setMnemonicAt(0, KeyEvent.VK_P);
		tabs.addTab("Team Match Data", teamMatchDataIcon, teamMatchData, "Enter individual team match data here.");
		tabs.setMnemonicAt(1, KeyEvent.VK_T);
		tabs.addTab("Full Match Data", fullMatchDataIcon, fullMatchData, "Enter full match data here.");
		tabs.setMnemonicAt(2, KeyEvent.VK_F);
		tabs.addTab("Individual Team Statistics", basicStatPanelIcon, basicStatPanel,
				"See data about an individual team here.");
		tabs.setMnemonicAt(3, KeyEvent.VK_S);

		mainFrame.add(tabs);
		mainFrame.setSize(1000, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);

	}

}
