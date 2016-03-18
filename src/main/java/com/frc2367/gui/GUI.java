package com.frc2367.gui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class GUI {

	private JTabbedPane tabs = new JTabbedPane();
	private JPanel pitData = new JPanel(new GridLayout(2, 2));
	private JPanel teamMatchData = new JPanel(new GridLayout(3, 3));
	private JPanel fullMatchData = new JPanel(new GridLayout(3, 3));
	private JPanel basicStatPanel = new JPanel(new GridLayout(3, 3));
	private ImageIcon pitDataIcon = new ImageIcon("Icons/FIRST Logo.gif");
	private ImageIcon teamMatchDataIcon = new ImageIcon("Icons/Boulder.png");
	private ImageIcon fullMatchDataIcon = new ImageIcon("Icons/portcullis.png");
	private ImageIcon basicStatPanelIcon = new ImageIcon("Icons/stronghold.png");
	private boolean isFullscreen = false;

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

		setupPitData();

		final JFrame mainFrame = new JFrame("The Dankest Scouting App");
		// mainFrame.setUndecorated(true);

		final GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

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
				if (e.getKeyCode() == KeyEvent.VK_F) {
					if (ctrl && !isFullscreen) {
						device.setFullScreenWindow(mainFrame);
						isFullscreen = true;
					} else if (ctrl && isFullscreen) {
						device.setFullScreenWindow(null);
						isFullscreen = false;
					}
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
		// top left, defenses (auto and tele)
		// list goes port, cdf, moat, ramp, draw, sally, wall, terr, lowbar
		int numberOfDefenses = 9;
		JPanel tl = new JPanel(new GridLayout(numberOfDefenses + 1, 2));
		JCheckBoxMenuItem[] autoChecks = new JCheckBoxMenuItem[numberOfDefenses];
		JCheckBoxMenuItem[] teleChecks = new JCheckBoxMenuItem[numberOfDefenses];
		tl.add(new JLabel("Autonomous"));
		tl.add(new JLabel("Teleoperated"));
		for (int i = 0; i < autoChecks.length; i++) {
			switch (i) {
			case 0:
				autoChecks[i] = new JCheckBoxMenuItem("Portcullis", new ImageIcon("Icons/portcullis.png"));
				teleChecks[i] = new JCheckBoxMenuItem("Portcullis", new ImageIcon("Icons/portcullis.png"));
				tl.add(autoChecks[i]);
				tl.add(teleChecks[i]);
				break;
			case 1:
				autoChecks[i] = new JCheckBoxMenuItem("Cheval De Frise", new ImageIcon("Icons/cdf.png"));
				teleChecks[i] = new JCheckBoxMenuItem("Cheval De Frise", new ImageIcon("Icons/cdf.png"));
				tl.add(autoChecks[i]);
				tl.add(teleChecks[i]);
				break;
			case 2:
				autoChecks[i] = new JCheckBoxMenuItem("Moat", new ImageIcon("Icons/moat.png"));
				teleChecks[i] = new JCheckBoxMenuItem("Moat", new ImageIcon("Icons/moat.png"));
				tl.add(autoChecks[i]);
				tl.add(teleChecks[i]);
				break;
			case 3:
				autoChecks[i] = new JCheckBoxMenuItem("Ramparts", new ImageIcon("Icons/ramparts.png"));
				teleChecks[i] = new JCheckBoxMenuItem("Ramparts", new ImageIcon("Icons/ramparts.png"));
				tl.add(autoChecks[i]);
				tl.add(teleChecks[i]);
				break;
			case 4:
				autoChecks[i] = new JCheckBoxMenuItem("Drawbridge", new ImageIcon("Icons/drawbridge.png"));
				teleChecks[i] = new JCheckBoxMenuItem("Drawbridge", new ImageIcon("Icons/drawbridge.png"));
				tl.add(autoChecks[i]);
				tl.add(teleChecks[i]);
				break;
			case 5:
				autoChecks[i] = new JCheckBoxMenuItem("Sally Port", new ImageIcon("Icons/sallyport.png"));
				teleChecks[i] = new JCheckBoxMenuItem("Sally Port", new ImageIcon("Icons/sallyport.png"));
				tl.add(autoChecks[i]);
				tl.add(teleChecks[i]);
				break;
			case 6:
				autoChecks[i] = new JCheckBoxMenuItem("Rock Wall", new ImageIcon("Icons/rockwall.png"));
				teleChecks[i] = new JCheckBoxMenuItem("Rock Wall", new ImageIcon("Icons/rockwall.png"));
				tl.add(autoChecks[i]);
				tl.add(teleChecks[i]);
				break;
			case 7:
				autoChecks[i] = new JCheckBoxMenuItem("Rough Terrain", new ImageIcon("Icons/roughterrain.png"));
				teleChecks[i] = new JCheckBoxMenuItem("Rough Terrain", new ImageIcon("Icons/roughterrain.png"));
				tl.add(autoChecks[i]);
				tl.add(teleChecks[i]);
				break;
			case 8:
				autoChecks[i] = new JCheckBoxMenuItem("Low Bar", new ImageIcon("Icons/lowbar.png"));
				teleChecks[i] = new JCheckBoxMenuItem("Low Bar", new ImageIcon("Icons/lowbar.png"));
				tl.add(autoChecks[i]);
				tl.add(teleChecks[i]);
				break;
			}
		}

		// top right, basic robot functions, autonomous functions,
		// make sure to include 1 ball auto AND 2 ball auto
		JPanel tr = new JPanel(new GridLayout(5, 1));

		// bottom left, data input, speed, tean number, name, etc
		JPanel bl = new JPanel(new GridLayout());
		JLabel teamNumberLabel = new JLabel("Team Number");
		JTextField teamNumberField = new JTextField();
		JLabel robotNameLabel = new JLabel("Robot Name");
		JTextField robotNameField = new JTextField();
		JLabel speed1Label = new JLabel("Speed 1");
		JTextField speed1Field = new JTextField();
		JLabel speed2Label = new JLabel("Speed 2");
		JTextField speed2Field = new JTextField();
		JLabel teamNameLabel = new JLabel("Team Name");
		JTextField teamNameField = new JTextField();

		// bottom right, notes and whatever else i can think of
		JPanel br = new JPanel(new GridLayout());

		pitData.add(tl);
		pitData.add(tr);
		pitData.add(bl);
		pitData.add(br);
	}

}
