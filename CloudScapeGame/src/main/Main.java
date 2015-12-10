package main;

import screen.Render;
import game.events.Events;
import game.worldmap.camara.Camara;

public class Main
{
	public static Events events = new Events();
	public static Map map;
	
	public static void main(String[] args)
	{
		map = new Map();
		
		Player player = new Player(map);
		map.addEntity(player);
		
		Camara camara = new PlayerCamara(player);
		Render render = new Render(camara);
		
		events.add(new TimerEvent(1.0));
		//TODO pass in the stuff for the TimerListener to be able to update the map and render it
		events.add(new TimerListener(render, map), TimerEvent.class);
	}
	
}
