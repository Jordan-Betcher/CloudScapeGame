package player;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import screen.render.events.KeyListenerEvent;
import screen.render.events.MouseKeyPressedEvent;
import game.events.EventListenerHolder;
import game.events.Events;
import game.worldmap.Collision2D;
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
			//After the camara starts moving, you will have to add the camaras position too
			this.destination = new XY(mouse.getX(), mouse.getY());
		}
	}

	private void Move()
	{
		XY playerPosition = new XY(this.playerData.getPosition());
		
		if(playerPosition != this.destination)
		{
			//TODO make it so that it stops when an edge touches instead of if the upper-right corner touches
			if(Collision2D.distanceBetween(playerPosition, this.destination) <= this.playerData.getSpeed())
			{
				this.playerData.setPosition(new XYZ(this.destination, this.playerData.getPosition().getZ()));
			}
			else
			{
				Move(Collision2D.move(playerPosition, this.destination, this.playerData.getSpeed()));
			}
		}
	}

	private void Move(XY xy)
	{
		XYZ playerPosition = this.playerData.getPosition();
		this.playerData.setPosition(
				new XYZ(
						playerPosition.getX() + xy.getX()
						, playerPosition.getY() + xy.getY()
						, playerPosition.getZ()));
	}

	public void draw(Graphics2D graphics2D)
	{
		playerData.draw(graphics2D);
	}
	
}
