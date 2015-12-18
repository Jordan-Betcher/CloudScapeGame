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
import game.worldmap.Position3D;

public class Player implements Drawable
{
	private PlayerData playerData;
	private EventListenerHolder<MouseEvent> mouseEvent;
	private KeyEventHandler keyButtons;

	public Player(PlayerData playerData, Events events)
	{
		this.playerData = playerData;
		this.mouseEvent = new EventListenerHolder<MouseEvent>();
		this.keyButtons = new KeyEventHandler();
		
		events.add(this.mouseEvent, MouseKeyPressedEvent.class);
		events.add(keyButtons, KeyListenerEvent.class);
		
	}
	
	public void update()
	{
		ArrayList<Character> keysPressed = keyButtons.get();
		MouseEvent mouse = mouseEvent.get();
		
		if(mouse == null)
		{
			
		}
		else
		{
			for(int i = 1; i < main.Main.times.size(); i++)
			{
				System.out.println(main.Main.times.get(i) - main.Main.times.get(i-1));
			}
			playerData.position = new Position3D(mouse.getX(), mouse.getY(), 0);
			//System.out.println("X: " + mouse.getX() + " Y: " + mouse.getY());
		}
	}

	public void draw(Graphics2D graphics2D)
	{
		playerData.draw(graphics2D);
	}
	
}
