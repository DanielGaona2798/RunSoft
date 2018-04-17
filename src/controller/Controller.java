package controller;

import models.dao.RunnerMannager;
import models.dao.StageMannager;
import views.MainWindow;

public class Controller {
	
	private RunnerMannager runnerMannager;
	private StageMannager stageMannager;
	private MainWindow mainWindow;
	
	public Controller() {
		runnerMannager = new RunnerMannager();
		stageMannager = new StageMannager();
		mainWindow = new MainWindow(runnerMannager.getRunnerList());
	}
	

}
