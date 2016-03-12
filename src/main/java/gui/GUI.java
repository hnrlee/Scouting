package gui;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

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

	private ImageIcon pitDataIcon = getScaledIcon("FIRST Logo.gif");
	private ImageIcon teamMatchDataIcon = getScaledIcon("Boulder.png");
	private ImageIcon fullMatchDataIcon = getScaledIcon("portcullis.png");
	private ImageIcon basicStatPanelIcon = getScaledIcon("stronghold.png");

	public GUI() {

		tabs.addTab("Pit Data", pitDataIcon, pitData, "Enter pit data here.");
		tabs.setMnemonicAt(0, KeyEvent.VK_1);
		tabs.addTab("Team Match Data", teamMatchDataIcon, teamMatchData, "Enter individual team match data here.");
		tabs.setMnemonicAt(1, KeyEvent.VK_2);
		tabs.addTab("Full Match Data", fullMatchDataIcon, fullMatchData, "Enter full match data here.");
		tabs.setMnemonicAt(2, KeyEvent.VK_3);
		tabs.addTab("Individual Team Statistics", basicStatPanelIcon, basicStatPanel,
				"See data about an individual team here.");
		tabs.setMnemonicAt(3, KeyEvent.VK_4);

		mainFrame.add(tabs);
		mainFrame.setSize(1000, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);

	}

	public ImageIcon getScaledIcon(String filename) {
		BufferedImage buff = new BufferedImage(new ImageIcon(filename).getImage().getWidth(null),
				new ImageIcon(filename).getImage().getHeight(null), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = buff.createGraphics();
		g.drawImage(new ImageIcon(filename).getImage(), 0, 0, 20, 20, null);
		return new ImageIcon(buff);

	}

}
