package game;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener; 
/**
This listener simply prints out the listener method name
and the x- and y-coordinate of the mouse position.
 */
public class MouseSpy implements MouseListener { 
	public void mousePressed(MouseEvent event) { 
		System.out.println("Mouse pressed. x = "
				+ event.getX() + " y = " + event.getY());
	} 
	public void mouseReleased(MouseEvent event) { 
		System.out.println("Mouse released. x = "
				+ event.getX() + " y = " + event.getY());
	} 
	public void mouseClicked(MouseEvent event)
	{ 
		System.out.println("Mouse clicked. x = "
				+ event.getX() + " y = " + event.getY());
	} 
	public void mouseEntered(MouseEvent event)
	{ 
		System.out.println("Mouse entered. x = "
				+ event.getX() + " y = " + event.getY());
	} 
	public void mouseExited(MouseEvent event)
	{ 
		System.out.println("Mouse exited. x = "
				+ event.getX() + " y = " + event.getY());
	}
}