
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import models.dao.RunnerMannager;
import models.dao.StageMannager;
import models.entities.Stage;
import views.AddStageDialog;
import views.MainWindow;
import views.PanelTable;
import views.PanelWinners;

public class Controller implements ActionListener{

	private RunnerMannager runnerMannager;
	private StageMannager stageMannager;
	private MainWindow mainWindow;
	private PanelTable panelTable;
	private Timer timer;
	private AddStageDialog stageDialog;
	private PanelWinners panelWinners;

	public Controller() {
		runnerMannager = new RunnerMannager();
		stageMannager = new StageMannager();
		mainWindow = new MainWindow(runnerMannager.getRunnerList(),this);
		panelTable = new PanelTable(this);
		stageDialog = new AddStageDialog(this);
		panelWinners = new PanelWinners();
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
		case ADD_RUNNER:
			addRunner();
			break;
		case ADD_STAGE:
			addStage();
			break;
		case STOP:
			stop();
			break;
		case VIEW_WINNERS:
			viewWinners();
			break;
		case SHOW_STAGES:
			showStages();
			break;
		}
	}

	private void stop() {
		if (timer != null) {
			if (timer.isRunning()) {
				timer.stop();
			}
		}else{
			JOptionPane.showMessageDialog(null, "primero debes iniciar la simulacion");
		}
	}

	private void viewWinners() {
		panelWinners.refreshTable(stageMannager.getStageForId(stageDialog.getSelectedId()).getRunnerList());
		panelWinners.setVisible(true);
	}

	private void showStages() {
		stageDialog.refreshTable(stageMannager.getStageList());
		stageDialog.setVisible(true);
	}

	private void addStage() {
		stageMannager.addStage(new Stage(mainWindow.getStageId(), mainWindow.getNameStage(), mainWindow.getWinList()));
		mainWindow.clearStage();
		mainWindow.clearWinnerList();
		runnerMannager.initVarY();
		panelTable.setVisible(false);
	}

	private void addRunner() {
		runnerMannager.addRunner(mainWindow.getIdRunner(),mainWindow.getNameRunner());
		mainWindow.clearRunner();
		mainWindow.setRunnerList(runnerMannager.getRunnerList());
	}

	private void showDialog() {
		if (timer != null) {
			if (timer.isRunning()) {
				panelTable.refreshTable(mainWindow.getWinList());
				panelTable.setVisible(true);
				timer.stop();

			}
		}else{
			JOptionPane.showMessageDialog(null, "primero debes iniciar la simulacion");
		}
	}

	private void changePosition() {
		timer = new Timer(40, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.mannageCoaliton();
				mainWindow.changePosition();
			}
		});
		timer.start();
	}
}
