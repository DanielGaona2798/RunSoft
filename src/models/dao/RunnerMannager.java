package models.dao;

import models.entities.Runner;
import struct.Queue;

public class RunnerMannager {

	private Queue<Runner> runnerList;
	
	public RunnerMannager() {
		runnerList = new Queue<>();
		runnerList.enqueue(new Runner(1, "gaona", 10, 10));
		runnerList.enqueue(new Runner(2, "gaona", 10, 80));
		runnerList.enqueue(new Runner(3, "gaona", 10, 150));
		runnerList.enqueue(new Runner(4, "gaona", 10, 230));
	}
	
	public void addRunner(Runner runner){
		runnerList.enqueue(runner);
	}

	public Queue<Runner> getRunnerList() {
		return runnerList;
	}
	
}