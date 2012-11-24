package game;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CourtPanel extends JPanel {
	private ImageIcon courtImage;
	
	public CourtPanel() {
		setSize(new Dimension(700,500));
		courtImage = new ImageIcon(getClass().getResource("/Images/Court (700x500).png"));
		this..setIcon(courtImage);
	}
}
