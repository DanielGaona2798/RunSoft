package models.entities;

import struct.Queue;

public class Stage {

	private int id;
	private String name;
	private Queue<Runner> runnerList;
	
	public Stage(int id, String name) {
		this.id = id;
		this.name = name;
		runnerList = new Queue<>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Queue<Runner> getRunnerList() {
		return runnerList;
	}
	
}
