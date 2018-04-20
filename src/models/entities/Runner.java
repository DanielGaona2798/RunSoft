package models.entities;

import java.awt.Rectangle;

public class Runner {

	private int id;
	private String name;
	private Rectangle rectangle;
	private int run;
	
	
	public Runner(int id, String name, int x, int y) {
		super();
		this.id = id;
		this.name = name;
		rectangle = new Rectangle(x, y, 50, 50);
		run = (int) (Math.random()*10)+1;
		
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public Rectangle getRectangle() {
		return rectangle;
	}


	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}
	
	
}
