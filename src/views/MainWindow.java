package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.Controller;
import models.entities.Runner;
import struct.Queue;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private PanelGraphics graphics;
	private PanelLow panelLow;
	
	public MainWindow(Queue<Runner> runnerList, Controller controller) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		graphics = new PanelGraphics(runnerList);
		
		panelLow = new PanelLow(controller);
		
		add(panelLow, BorderLayout.SOUTH);
		add(graphics, BorderLayout.CENTER);
		setVisible(true);
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
	
}
