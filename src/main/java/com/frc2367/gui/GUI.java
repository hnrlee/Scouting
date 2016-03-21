package com.frc2367.gui;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {

	private JTabbedPane tabs = new JTabbedPane();
	private JPanel pitData = new JPanel(new BorderLayout());
	private JPanel pitDataInfo = new JPanel(new GridLayout(2, 2));
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

		setuppitData();

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
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (ctrl)
						if (tabs.getSelectedIndex() < 3)
							tabs.setSelectedIndex(tabs.getSelectedIndex() + 1);
						else
							tabs.setSelectedIndex(0);
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

	public void setuppitData() {
		JButton submitButton = new JButton("Submit");
		pitData.add(pitDataInfo, BorderLayout.CENTER);
		pitData.add(submitButton, BorderLayout.SOUTH);

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
		JPanel tr = new JPanel(new GridLayout(1, 2));
		JPanel autoBallGroupPanel = new JPanel(new GridLayout(7, 1));
		tr.add(autoBallGroupPanel);

		// autonomous Shooter Stuff, radio buttons
		autoBallGroupPanel.add(new JLabel("Autonomous Shooter Capabilities"));
		ButtonGroup autoBallGroup = new ButtonGroup();
		JRadioButtonMenuItem[] autoBalls = new JRadioButtonMenuItem[6];
		autoBalls[0] = new JRadioButtonMenuItem("Zero Boulders");
		autoBalls[1] = new JRadioButtonMenuItem("1 Low Goal");
		autoBalls[2] = new JRadioButtonMenuItem("1 High Goal");
		autoBalls[3] = new JRadioButtonMenuItem("1 Low and 1 High");
		autoBalls[4] = new JRadioButtonMenuItem("2 Low Goals");
		autoBalls[5] = new JRadioButtonMenuItem("2 High Goals");
		for (int i = 0; i < autoBalls.length; i++) {
			autoBallGroup.add(autoBalls[i]);
			autoBallGroupPanel.add(autoBalls[i]);
		}

		JPanel trRightSide = new JPanel(new GridLayout(11, 1));
		tr.add(trRightSide);

		// autonomous defenses
		ButtonGroup autoCapabilitiesGroup = new ButtonGroup();
		JRadioButtonMenuItem[] autoCapabilities = new JRadioButtonMenuItem[3];
		autoCapabilities[0] = new JRadioButtonMenuItem("Does not reach or cross defense");
		autoCapabilities[1] = new JRadioButtonMenuItem("Reach defense");
		autoCapabilities[2] = new JRadioButtonMenuItem("Cross Defense");
		trRightSide.add(new JLabel("Autonomous Capabilities"));
		for (int i = 0; i < autoCapabilities.length; i++) {
			autoCapabilitiesGroup.add(autoCapabilities[i]);
			trRightSide.add(autoCapabilities[i]);
		}

		// teleop shooter capabilities
		JCheckBoxMenuItem[] teleOpCapabilities = new JCheckBoxMenuItem[2];
		teleOpCapabilities[0] = new JCheckBoxMenuItem("Low Goal");
		teleOpCapabilities[1] = new JCheckBoxMenuItem("High Goal");
		trRightSide.add(new JLabel("Teleop Capabilities"));
		for (int i = 0; i < teleOpCapabilities.length; i++) {
			trRightSide.add(teleOpCapabilities[i]);
		}

		// tower abilities
		ButtonGroup towerAttackGroup = new ButtonGroup();
		JRadioButtonMenuItem[] towerAttack = new JRadioButtonMenuItem[3];
		towerAttack[0] = new JRadioButtonMenuItem("Cannot Attack Tower");
		towerAttack[1] = new JRadioButtonMenuItem("Can Challenge");
		towerAttack[2] = new JRadioButtonMenuItem("Can Scale");
		trRightSide.add(new JLabel("Tower Attack Capabilities"));
		for (int i = 0; i < towerAttack.length; i++) {
			towerAttackGroup.add(towerAttack[i]);
			trRightSide.add(towerAttack[i]);
		}

		// bottom left, data input, speed, tean number, name, etc
		JPanel bl = new JPanel(new GridLayout(5, 2));
		JLabel teamNumberLabel = new JLabel("Team Number");
		JTextField teamNumberField = new JTextField("0");
		JLabel robotNameLabel = new JLabel("Robot Name");
		JTextField robotNameField = new JTextField("null");
		JLabel speed1Label = new JLabel("Speed 1 (ft/sec)");
		JTextField speed1Field = new JTextField("0");
		JLabel speed2Label = new JLabel("Speed 2(ft/sec)");
		JTextField speed2Field = new JTextField("0");
		JLabel teamNameLabel = new JLabel("Team Name");
		JTextField teamNameField = new JTextField("null");
		bl.add(teamNumberLabel);
		bl.add(teamNumberField);
		bl.add(robotNameLabel);
		bl.add(robotNameField);
		bl.add(speed1Label);
		bl.add(speed1Field);
		bl.add(speed2Label);
		bl.add(speed2Field);
		bl.add(teamNameLabel);
		bl.add(teamNameField);

		// bottom right, notes and whatever else i can think of
		JPanel br = new JPanel(new BorderLayout());
		br.add(new JLabel("Notes"), BorderLayout.NORTH);
		br.add(new JTextArea(), BorderLayout.CENTER);

		pitDataInfo.add(tl);
		pitDataInfo.add(tr);
		pitDataInfo.add(bl);
		pitDataInfo.add(br);
	}

}
