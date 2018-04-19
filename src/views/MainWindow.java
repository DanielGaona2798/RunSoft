package views;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Actions;
import controller.Controller;
import models.entities.Runner;
import struct.Queue;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private PanelGraphics graphics;
	
	public MainWindow(Queue<Runner> runnerList, Controller controller) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		graphics = new PanelGraphics(runnerList);
		
		JButton btnStart = new JButton("START");
		btnStart.setActionCommand(Actions.START.toString());
		btnStart.addActionListener(controller);
		add(btnStart, BorderLayout.SOUTH);
		add(graphics, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void changePosition() {
		graphics.changeLocation();
	}
	
}
