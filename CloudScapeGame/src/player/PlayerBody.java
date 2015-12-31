package player;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import game.worldmap.Drawable;

public class PlayerBody implements Drawable
{
	private int headRadius = 16;
	private int handRadius = 8;
	
	private int distanceFromHeadToHand = 0;
	
	private Circle head = new Circle(0, 0, headRadius);
	private Circle leftHand = new Circle(-handRadius, -head.getRadius(), handRadius);
	private Circle rightHand = new Circle(head.getWidth() - handRadius, -head.getRadius(), handRadius);
	
	private double angle = 0;

	@Override
	public void draw(Graphics2D graphics2D)
	{
		//TODO make it so that you can rotate
		//Change the x/y position of the hands
		graphics2D.draw(head);
		graphics2D.draw(leftHand);
		graphics2D.draw(rightHand);
		
		
		//TODO make eyes
		//TODO make borders
	}
	
	public void setRotation(double angle)
	{
		this.angle = angle;
	}
	
	public Rectangle getBounds2D()
	{
		//TODO create bounds
		return null;
	}
}
