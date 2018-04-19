package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.sun.javafx.geom.Rectangle;

import models.entities.Runner;
import struct.Node;
import struct.Queue;

public class PanelGraphics extends JPanel{

	private static final long serialVersionUID = 1L;

	
	private Queue<Runner> runnerList;
	private Rectangle rectangle;
	
	public PanelGraphics(Queue<Runner> runnerList) {
		this.runnerList = runnerList;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Node<Runner> head = runnerList.getHead();
		while (head != null) {
			g.drawImage(new ImageIcon(getClass().getResource("/img/runner.png")).getImage(), head.getInformation().getRectangle().x, head.getInformation().getRectangle().y, head.getInformation().getRectangle().height,head.getInformation().getRectangle().width , this);
			head = head.getNext();
		}
		g.setColor(Color.BLACK);
		g.fillRect(getWidth()-100, 10, 100, 1000);
		rectangle = new Rectangle(getWidth()-100, 10, 100, 1000);
	}
	
	public void changeLocation() {
		Node<Runner> head = runnerList.getHead();
		while (head != null) {
			head.getInformation().getRectangle().setBounds(head.getInformation().getRectangle().x + head.getInformation().getRun(), head.getInformation().getRectangle().y, head.getInformation().getRectangle().height, head.getInformation().getRectangle().width);
			head = head.getNext();
		}
		repaint();
	}
	
}
