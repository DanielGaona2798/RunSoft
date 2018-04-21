package models.entities;

import struct.Queue;

public class Stage {

	private int id;
	private Queue<Runner> runnerList;
	

	public Stage(int id, Queue<Runner> runnerList) {
		super();
		this.id = id;
		this.runnerList = runnerList;
	}

	public int getId() {
		return id;
	}

	public Queue<Runner> getRunnerList() {
		return runnerList;
	}
	
}
