package models.dao;

import models.entities.Stage;
import struct.MyList;
import struct.Node;

public class StageMannager {

	private MyList<Stage> stageList;
	
	public StageMannager() {
		stageList = new MyList<>();
	}

	public void addStage(Stage stage){
		stageList.add(stage);
	}
	
	public MyList<Stage> getStageList() {
		return stageList;
	}

	public Stage getStageForId(int selectedId) {
		Stage a = null;
		Node<Stage> head = stageList.getHead();
		while (head != null) {
			if (head.getInformation().getId() == selectedId) {
				a = head.getInformation();
			}
			head = head.getNext();
		}
		return a;
	}
	
	
}
