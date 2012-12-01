package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class PaperBasketballGUI extends JFrame implements MouseListener {
	private JMenuItem exit;
	private Court court;
	private GameControlPanel gameControlPanel;
	
	//Constructor for the JFrame
	public PaperBasketballGUI() {
		court = new Court();
		gameControlPanel = new GameControlPanel(this);
		//GUI
		setSize(new Dimension(720, 625));
		setTitle("Paper Basketball!");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		add(court);
		addMouseListener(this);
		add(gameControlPanel, BorderLayout.SOUTH);
	}

	/**GUI components ******************************************/
	/** Creates File menu */
	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File"); 
		menu.add(createFileExitItem());
		return menu;
	}

	/** Creates Exit option */
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
	
	
	/** Main */
	public static void main(String[] args) {
		PaperBasketballGUI pbGUI = new PaperBasketballGUI();
		pbGUI.setVisible(true);
		JOptionPane.showMessageDialog(pbGUI, "Score 10 baskets in a minute to win! Press OK to start the clock!", "Paper Basketball", JOptionPane.INFORMATION_MESSAGE);
		//TODO start the timer
		//startTimer();
	}


	/**Mouse Listener********************************************/
	public void mouseClicked(MouseEvent event) { 
		System.out.println("Mouse clicked. x = "
				+ event.getX() + " y = " + event.getY());
	} 
	public void mousePressed(MouseEvent event) {} 
	public void mouseReleased(MouseEvent event) {} 
	public void mouseEntered(MouseEvent event) {} 
	public void mouseExited(MouseEvent event){}

	/**Getters and Setters***************************************/
	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

}
