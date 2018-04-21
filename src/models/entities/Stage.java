package models.entities;

import struct.Queue;

public class Stage {

	private int id;
	private String stage;
	private Queue<Runner> runnerList;
	

	public Stage(int id ,String stage, Queue<Runner> runnerList) {
		super();
		this.id = id;
		this.stage =stage;
		this.runnerList = runnerList;
	}

	public int getId() {
		return id;
	}

	public Queue<Runner> getRunnerList() {
		return runnerList;
	}

	public String getStage() {
		return stage;
	}

}
