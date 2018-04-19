package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import models.dao.RunnerMannager;
import models.dao.StageMannager;
import views.MainWindow;

public class Controller implements ActionListener{
	
	private RunnerMannager runnerMannager;
	private StageMannager stageMannager;
	private MainWindow mainWindow;
	
	public Controller() {
		runnerMannager = new RunnerMannager();
		stageMannager = new StageMannager();
		mainWindow = new MainWindow(runnerMannager.getRunnerList(), this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand().toString())) {
		case START:
			mainWindow.changePosition();
			break;
		}
	}
	

}
