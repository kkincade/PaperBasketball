package game;

import java.awt.Color;

public class Player {
	private String name;
	private Color color;
	
	//Constructor
	public Player() {
		super();
	}

	public void shoot(double angle, double power) {
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
