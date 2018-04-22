package models.dao;

import controller.ContantsUi;
import models.entities.Runner;
import struct.Queue;

public class RunnerMannager {

	private Queue<Runner> runnerList;
	private int y = 10;
	
	public RunnerMannager() {
		runnerList = new Queue<>();
		runnerList.enqueue(new Runner(1, "Basic Runner", ContantsUi.POSITION_X, y));
	}	
	public void addRunner(int id, String name){
		y+=75;
		runnerList.enqueue(new Runner(id, name, ContantsUi.POSITION_X, y));
	}

	public Queue<Runner> getRunnerList() {
		return runnerList;
	}
	public void initVarY() {
		y=10;
		runnerList.enqueue(new Runner(1, "Basic Runner", ContantsUi.POSITION_X, y));
	}
	
}