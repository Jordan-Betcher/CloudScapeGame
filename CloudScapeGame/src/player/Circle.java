package player;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circle extends Ellipse2D
{
	private double x;
	private double y;
	private double radius;
	
	public Circle(double x, double y, double radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	@Override
	public Rectangle2D getBounds2D()
	{
		return new Rectangle((int)this.getX(), (int)this.getY(), (int)this.getHeight(), (int)this.getWidth());
	}
	
	@Override
	public double getHeight()
	{
		return radius * 2;
	}
	
	@Override
	public double getWidth()
	{
		return radius * 2;
	}
	
	@Override
	public double getX()
	{
		return this.x;
	}
	
	@Override
	public double getY()
	{
		return this.y;
	}
	
	@Override
	public double getCenterX()
	{
		return this.x + this.radius;
	}
	
	@Override
	public double getCenterY()
	{
		return this.y + this.radius;
	}
	
	@Override
	public boolean isEmpty()
	{
		//I don't know what this is suppose to do...
		return false;
	}
	
	@Override
	public void setFrame(double arg0, double arg1, double arg2, double arg3)
	{
		//I don't know what this is suppose to do...
	}
	
	public double getRadius()
	{
		return this.radius;
	}
}
