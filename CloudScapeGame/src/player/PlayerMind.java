package player;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import screen.render.events.KeyListenerEvent;
import screen.render.events.MouseKeyPressedEvent;
import game.events.EventListenerHolder;
import game.events.Events;
import game.worldmap.Drawable;
import game.worldmap.Position3D;

public class PlayerMind implements Drawable
{
	private Player player;
	private EventListenerHolder<MouseEvent> mouseEvent;
	private EventListenerHolder<ArrayList<Character>> keyButtons;

	public PlayerMind(Player player, Events events)
	{
		this.player = player;
		this.mouseEvent = new EventListenerHolder<MouseEvent>();
		this.keyButtons = new EventListenerHolder<ArrayList<Character>>();
		
		events.add(this.mouseEvent, MouseKeyPressedEvent.class);
		events.add(keyButtons, KeyListenerEvent.class);
		
	}
	
	public void update()
	{
		if(keyButtons.get() == null)
		{
			
		}
		else if(keyButtons.get().contains('w'))
		{
			player.position = new Position3D(player.position.getX(), player.position.getY(), player.position.getZ() - 10);
		}
	}

	public void draw(Graphics2D graphics2D)
	{
		player.draw(graphics2D);
	}
	
}
