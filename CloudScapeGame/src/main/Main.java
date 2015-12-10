package main;

import screen.render.KeyListenerEvent;
import screen.render.Render;
import game.events.Events;
import game.worldmap.camara.Camara;

public class Main
{
	public static Events events = new Events();
	public static Map map;
	public static Render render;
	
	public static void main(String[] args)
	{
		map = new Map();
		Player player = new Player(map);
		Camara camara = new PlayerCamara(player);
		render = new Render(camara);
		
		map.addEntity(player);
		
		addEvents();
		addListeners();
	}

	private static void addEvents()
	{
		events.add(new TimerEvent(1.0));
		events.add(render.getKeyListenerEvent());
	}

	private static void addListeners()
	{
		events.add(new GameLoop(render, map), TimerEvent.class);
	}
	
}
