package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import models.dao.RunnerMannager;
import models.dao.StageMannager;
import views.MainWindow;
import views.PanelTable;

public class Controller implements ActionListener{

	private RunnerMannager runnerMannager;
	private StageMannager stageMannager;
	private MainWindow mainWindow;
	private PanelTable panelTable;

	public Controller() {
		runnerMannager = new RunnerMannager();
		stageMannager = new StageMannager();
		mainWindow = new MainWindow(runnerMannager.getRunnerList(), this);
		panelTable = new PanelTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand().toString())) {
		case START:
			changePosition();
			break;
		case SHOW_WINNERS:
			showDialog();
			break;
		}
	}

	private void showDialog() {
		panelTable.refreshTable(mainWindow.getWinList());
		panelTable.setVisible(true);
	}

	private void changePosition() {
		Timer timer = new Timer(40, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.changePosition();
			}
		});
		timer.start();
	}




}
