package views;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;
import models.entities.Runner;
import struct.Queue;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private PanelGraphics graphics;
	private PanelLow panelLow;
	
	public MainWindow(Queue<Runner> runnerList,Controller controller) {
		
		setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
		setTitle("Runner Soft");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		graphics = new PanelGraphics(runnerList);
		
		panelLow = new PanelLow(controller);
		
		add(panelLow, BorderLayout.SOUTH);
		add(graphics, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void setRunnerList(Queue<Runner> runnerList){
		graphics.setRunnerList(runnerList);
	}
	public void changePosition() {
		graphics.changeLocation();
	}
	
	public Queue<Runner> getWinList(){
		return graphics.getWinList();
	}
	public void mannageCoaliton() {
		graphics.manageCoalition();
	}

	public int getIdRunner() {
		return panelLow.getIdRunner();
	}

	public String getNameRunner() {
		return panelLow.getNameRunner();
	}

	public void clearRunner() {
		panelLow.clearRunner();
	}

	public int getStageId() {
		return panelLow.getIdStage();
	}

	public String getNameStage() {
		return panelLow.getNameStage();
	}
	
	public void clearStage(){
		panelLow.clearStage();
	}

	public void clearWinnerList() {
		graphics.clearWinnerList();
	}
}
