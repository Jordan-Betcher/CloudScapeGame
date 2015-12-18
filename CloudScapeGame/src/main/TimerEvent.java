package main;

import java.util.Timer;
import java.util.TimerTask;

import game.events.Event;

public class TimerEvent extends Event<Integer>
{
	
	private long startTime;
	
	//This variable represents how many seconds or second parts will be done b4 all the listeners are activated
	private double increments;
	
	private final static double milisecondsToSeconds = 1000.0;
	
	//TODO allow it to be paused?
	
	public TimerEvent(double increments)
	{
		this(System.currentTimeMillis(), increments);
	}
	
	public TimerEvent(long startTime, double increments)
	{
		this.startTime = startTime;
		this.increments = increments;
		startTimer();
	}
	
	private void startTimer()
	{
		double timePassed = startTime;
		//TODO create timer using the increments variable
		TimerTask timerTask = new TimerTask()
		{

            @Override
            public void run() 
            {
                Main.events.activate(getTicks(), TimerEvent.class);
            }
        };

        Timer timer = new Timer("TimerPer" + this.increments);//create a new Timer

        //The 0 is delay
        timer.scheduleAtFixedRate(timerTask, 0, (long)(this.increments * milisecondsToSeconds));
	}
	
	public long getStartTime()
	{
		return startTime;
	}
	
	public long getTimeElapsed()
	{
		return System.currentTimeMillis() - this.startTime;
	}
	
	public int getTicks()
	{
		double seconds = getTimeElapsed() / milisecondsToSeconds;
		return (int) (seconds / this.increments);
	}
	
	
}
