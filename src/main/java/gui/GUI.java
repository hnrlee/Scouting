package gui;

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
	private ImageIcon teamMatchDataIcon = new ImageIcon("Boulder.png");
	private ImageIcon fullMatchDataIcon = new ImageIcon("portcullis.png");
	private ImageIcon basicStatPanelIcon = new ImageIcon("stronghold.png");

	public GUI() {

		// Tab setup
		tabs.addTab("Pit Data", pitDataIcon, pitData, "Enter pit data here.");
		tabs.setMnemonicAt(0, KeyEvent.VK_1);
		tabs.addTab("Team Match Data", teamMatchDataIcon, teamMatchData, "Enter individual team match data here.");
		tabs.setMnemonicAt(1, KeyEvent.VK_2);
		tabs.addTab("Full Match Data", fullMatchDataIcon, fullMatchData, "Enter full match data here.");
		tabs.setMnemonicAt(2, KeyEvent.VK_3);
		tabs.addTab("Individual Team Statistics", basicStatPanelIcon, basicStatPanel,
				"See data about an individual team here.");
		tabs.setMnemonicAt(3, KeyEvent.VK_4);

		// frame setup
		mainFrame.add(tabs);
		mainFrame.setSize(1000, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);

	}

}
