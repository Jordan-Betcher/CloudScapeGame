package main;

import java.util.ArrayList;

import player.PlayerData;
import player.Player;
import player.PlayerCamara;
import screen.render.Render;
import game.events.Events;
import game.worldmap.camara.Camara;

public class Main
{
	public static Events events = new Events();
	public static Map map;
	public static Render render;
	public static ArrayList<Long> times = new ArrayList<Long>();
	
	public static void main(String[] args)
	{
		map = new Map();
		PlayerData playerData = new PlayerData(map);
		Camara camara = new PlayerCamara(playerData);
		render = new Render(camara, events);
		
		Player player = new Player(playerData, events);
		
		map.addEntity(player);
		
		events.add(new TimerEvent(0.1));
		events.add(new GameLoop(render, map), TimerEvent.class);
	}
	
}
