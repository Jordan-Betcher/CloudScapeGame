package main;

import player.Player;
import player.PlayerMind;
import player.PlayerCamara;
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
		
		PlayerMind playerMind = new PlayerMind(player);
		
		map.addEntity(playerMind);
		
		events.add(new TimerEvent(1.0));
		events.add(new GameLoop(render, map), TimerEvent.class);
		
		events.add(render.getKeyListenerEvent());
		events.add(playerMind, KeyListenerEvent.class);
	}
	
}
