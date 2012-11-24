package game;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Court extends JFrame {
	private Player whoseTurn;
	private Scoreboard scoreboard;
	private Basketball bball;
	private Player player;
	private Hoop hoop;
	private double power;
	private JMenuItem exit;
	private CourtPanel courtPanel;
	private JLabel background;
	
	//Constructor
	public Court() {
		super();
		scoreboard = new Scoreboard();
		bball = new Basketball();
		player = new Player();
		setPower(0);
		
		//GUI
		setSize(new Dimension(700, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		
		//Setting the background image
		courtPanel = new CourtPanel();
		courtPanel.setIcon(courtPanel);
		background.setLocation(0,0);
		background.setSize(700,500);

	}
	
	public void loadConfigFiles() {
		
	}
	
	public boolean checkAngle(double angle) {
		return false;
	}
	
	public boolean checkShot() {
		return false;
	}
	
	public boolean checkWin(int score) {
		return false;
	}
	
	public static void main(String[] args) {
		Court court = new Court();
		court.setVisible(true);
	}

//* GUI components **************************************************
	//Creates File menu
	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File"); 
		menu.add(createFileExitItem());

		return menu;
	}
	
	//Creates Exit option 
	private JMenuItem createFileExitItem() {
		exit = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		exit.addActionListener(new MenuItemListener());
		return exit;
	}
	
//* Getters and Setters *********************************************
	public Player getWhoseTurn() {
		return whoseTurn;
	}

	public Scoreboard getScoreboard() {
		return scoreboard;
	}

	public void setScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}

	public Basketball getBball() {
		return bball;
	}

	public void setBball(Basketball bball) {
		this.bball = bball;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setWhoseTurn(Player whoseTurn) {
		this.whoseTurn = whoseTurn;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public Hoop getHoop() {
		return hoop;
	}

	public void setHoop(Hoop hoop) {
		this.hoop = hoop;
	}

}
