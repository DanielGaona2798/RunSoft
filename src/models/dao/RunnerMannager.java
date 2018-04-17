package models.dao;

import models.entities.Runner;
import struct.Queue;

public class RunnerMannager {

	private Queue<Runner> runnerList;
	
	public RunnerMannager() {
		runnerList = new Queue<>();
	}
	
	public void addRunner(Runner runner){
		runnerList.enqueue(runner);
	}

	public Queue<Runner> getRunnerList() {
		return runnerList;
	}
	
}