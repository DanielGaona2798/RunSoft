package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


import models.entities.Runner;
import struct.Node;
import struct.Queue;

public class PanelGraphics extends JPanel{

	private static final long serialVersionUID = 1L;


	private Queue<Runner> runnerList;
	private Rectangle rectangle;
	private Queue<Runner> winList;

	public PanelGraphics(Queue<Runner> runnerList) {
		this.runnerList = runnerList;
		winList = new Queue<>();
	}
	
	public void setRunnerList(Queue<Runner> runnerList){
		this.runnerList = runnerList;
		repaint();
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
			if (head.getInformation().getRectangle().getX() < getWidth()-140) {
				head.getInformation().getRectangle().setBounds(head.getInformation().getRectangle().x + head.getInformation().getRun(), head.getInformation().getRectangle().y, head.getInformation().getRectangle().height, head.getInformation().getRectangle().width);
			}
			head = head.getNext();
		}
		repaint();
	}
	public void manageCoalition() {
		Node<Runner> runner = runnerList.getHead(); 
		while (runner != null) {
			if (runner.getInformation().getRectangle().intersects(rectangle)) {
				winList.enqueue(runner.getInformation());
				runner.getInformation().getRectangle().setBounds(runner.getInformation().getRectangle().x + 300, runner.getInformation().getRectangle().y, runner.getInformation().getRectangle().height, runner.getInformation().getRectangle().width);
			}
			runner = runner.getNext();
		}
	}

	public Queue<Runner> getWinList() {
		return winList;
	}

	public void clearWinnerList() {
		winList = null;
		winList = new Queue<>();
	}
	
	
}
