package player;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import screen.render.events.KeyListenerEvent;
import screen.render.events.MouseKeyPressedEvent;
import game.events.EventListenerHolder;
import game.events.Events;
import game.worldmap.Drawable;
import game.worldmap.XY;
import game.worldmap.XYZ;

public class Player implements Drawable
{
	private PlayerData playerData;
	public EventListenerHolder<MouseEvent> mouseEvent;
	public KeyEventHandler keyButtons;
	private XY destination;

	public Player(PlayerData playerData, Events events)
	{
		this.playerData = playerData;
		this.mouseEvent = new EventListenerHolder<MouseEvent>();
		this.keyButtons = new KeyEventHandler();
		this.destination = new XY(this.playerData.getPosition());
		
		events.add(this.mouseEvent, MouseKeyPressedEvent.class);
		events.add(keyButtons, KeyListenerEvent.class);
		
	}
	
	public void update()
	{
		
		this.getInput();
		this.Move();
		
	}

	private void getInput()
	{
		ArrayList<Character> keysPressed = keyButtons.get();
		MouseEvent mouse = mouseEvent.get();
		
		if(mouse != null)
		{
			this.destination = new XY(mouse.getX(), mouse.getY());
		}
	}

	private void Move()
	{
		XY playerPosition = new XY(this.playerData.getPosition());
		
		if(playerPosition != this.destination)
		{
			//Change 20 to a variable like speed?
			if(this.distanceBetween(playerPosition, this.destination) < 20)
			{
				this.playerData.setPosition(new XYZ(this.destination, this.playerData.getPosition().getZ()));
			}
		}
	}

	private double distanceBetween(XY xy1, XY xy2)
	{
		
		int x1 = xy1.getX();
		int x2 = xy2.getX();
		
		int y1 = xy1.getY();
		int y2 = xy2.getY();
		
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}

	public void draw(Graphics2D graphics2D)
	{
		playerData.draw(graphics2D);
	}
	
}
