package views;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.entities.Runner;
import struct.Node;
import struct.Queue;

public class PanelGraphics extends JPanel{

	private static final long serialVersionUID = 1L;

	private Queue<Runner> runnerList;
	
	public PanelGraphics(Queue<Runner> runnerList) {
		this.runnerList = runnerList;
	}
	
	public void paint(Graphics g){
		Node<Runner> head = runnerList.getHead();
		super.paint(g);
		while (head != null) {
			g.drawImage(new ImageIcon(getClass().getResource("img/ruuner.png")).getImage(), head.getInformation().getX(), head.getInformation().getY(), this);
			head = head.getNext();
		}
	}
}
