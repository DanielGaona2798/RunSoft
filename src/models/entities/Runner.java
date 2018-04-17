package models.entities;

public class Runner {

	private int id;
	private String name;
	private int x;
	private int y;
	
	
	public Runner(int id, String name, int x, int y) {
		super();
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}
