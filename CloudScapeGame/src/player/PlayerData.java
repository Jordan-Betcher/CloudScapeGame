package player;

import game.worldmap.Collision2D;
import game.worldmap.Drawable;
import game.worldmap.Moveable;
import game.worldmap.XYZ;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Map;

public class PlayerData implements Drawable, Moveable
{
	private Map map;
	
	private XYZ position;
	private XYZ previousPosition;
	
	private double speed;
	private double angle;
	//TODO Make hands as well
	
	//Collision and rotation of area example:
	//http://stackoverflow.com/questions/20927189/detecting-collision-of-two-sprites-that-can-rotate/20928531#20928531
	private PlayerBody playerBody;
	
	public PlayerData(Map map)
	{
		this.map = map;
		this.position = new XYZ(0, 0, 0);
		this.previousPosition = this.position;
		this.speed = 20.0;
		this.angle = 0;
		this.playerBody = new PlayerBody();
	}
	
	@Override
	public void draw(Graphics2D graphics2D)
	{
		graphics2D.setColor(Color.red);
		//TODO create actual pic
		//TODO make off set middle? OR do in collision
		
		//TODO make a list of objects
		//Go through each object in the list
		//Draw the object using the properties of PlayerData
		drawPlayer(graphics2D);
	}

	private void drawPlayer(Graphics2D graphics2D)
	{
		this.playerBody.setRotation(Collision2D.getAngle(this.previousPosition.get2DPosition(), this.position.get2DPosition()));
		
		graphics2D.translate(this.position.getX(), this.position.getY());
		
		this.playerBody.draw(graphics2D);
		
		graphics2D.translate(-this.position.getX(), -this.position.getY());
	}

	@Override
	public XYZ getPosition()
	{
		return this.position;
	}
	
	public XYZ getPreviousPosition()
	{
		return this.previousPosition;
	}

	@Override
	public void setPosition(XYZ xyzCoords)
	{
		this.previousPosition = this.position;
		this.position = xyzCoords;		
	}

	public Map getMap()
	{
		return map;
	}

	public double getSpeed()
	{
		return speed;
	}

	public void setAngle(double angle)
	{
		this.angle = angle;
	}
	
}
