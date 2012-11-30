package game;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class GameControlPanel extends JPanel {
	private static final int MAX_ANGLE = 90;
	private static final int MIN_ANGLE = 0;
	private static final int INIT_ANGLE = 45;
	private static final int MAX_POWER = 100;
	private static final int MIN_POWER = 0;
	private static final int INIT_POWER = 50;
	private JSlider angleSlider, powerSlider;
	private JButton shootButton;
	private PaperBasketballGUI pbGUI;
	
	public GameControlPanel(PaperBasketballGUI pbGUI) {
		this.pbGUI = pbGUI;
		setLayout(new GridLayout(1, 4));
		
		//Angle Slider
		angleSlider = createAngleSlider("Angle");
		angleSlider.setMajorTickSpacing(10);
		angleSlider.setMinorTickSpacing(1);
		angleSlider.setPaintTicks(true);
		angleSlider.setPaintLabels(true);
		SliderListener angleSliderListener = new SliderListener();
		angleSlider.addChangeListener(angleSliderListener);
		
		//Power Slider
		powerSlider = createPowerSlider("Power");
		powerSlider.setMajorTickSpacing(10);
		powerSlider.setMinorTickSpacing(1);
		powerSlider.setPaintTicks(true);
		powerSlider.setPaintLabels(true);
		SliderListener powerSliderListener = new SliderListener();
		powerSlider.addChangeListener(powerSliderListener);
		
		//Shoot Button
		ButtonListener shootButtonListener = new ButtonListener();
		shootButton = new JButton("Shoot");
		shootButton.addActionListener(shootButtonListener);
		
		//Adding components to GameControlPanel
		add(shootButton);
		add(powerSlider);
		add(angleSlider);
	}
	
	/** Creates the JSlider for the Angle */
	public JSlider createAngleSlider(String borderTitle) {
		JSlider slider = new JSlider(JSlider.HORIZONTAL, MIN_ANGLE, MAX_ANGLE, INIT_ANGLE);
		TitledBorder powerSliderTitle = new TitledBorder(borderTitle);
		slider.setBorder(powerSliderTitle);
		return slider;
	}
	
	/** Creates the JSlider for the Power */
	public JSlider createPowerSlider(String borderTitle) {
		JSlider slider = new JSlider(JSlider.HORIZONTAL, MIN_POWER, MAX_POWER, INIT_POWER);
		TitledBorder powerSliderTitle = new TitledBorder(borderTitle);
		slider.setBorder(powerSliderTitle);
		return slider;
	}
	
	/** Action Listener for shoot button */
	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == shootButton) {
				pbGUI.getCourt().shoot();
				System.out.println("Shooting");
			}
		}
	}
	
	/** Action Listener for both sliders (angle and power) */
	public class SliderListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() == angleSlider) {
				pbGUI.getCourt().getBball().setAngle(angleSlider.getValue());
				System.out.println("angle = " + pbGUI.getCourt().getBball().getAngle());
			} else if (e.getSource() == powerSlider) {
				pbGUI.getCourt().setPower(powerSlider.getValue());
				System.out.println("power = " + powerSlider.getValue());
			}
		}
	}
}
