package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import models.entities.Runner;
import struct.Queue;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private PanelGraphics graphics;
	
	public MainWindow(Queue<Runner> runnerList) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		graphics = new PanelGraphics(runnerList);
		
		add(graphics, BorderLayout.CENTER);
		setVisible(true);
	}
}
