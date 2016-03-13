package gui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

		class KeyboardListen implements KeyListener {

			boolean ctrl = false;

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL)
					ctrl = true;
				if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
					if (ctrl)
						tabs.setSelectedIndex(0);
				}
				if (e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
					if (ctrl)
						tabs.setSelectedIndex(1);
				}
				if (e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
					if (ctrl)
						tabs.setSelectedIndex(2);
				}
				if (e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
					if (ctrl)
						tabs.setSelectedIndex(3);
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL)
					ctrl = false;
			}

		}
		tabs.addKeyListener(new KeyboardListen());

	}

	public void setupPitData() {

	}

}
