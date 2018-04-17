package models.dao;

import models.entities.Stage;
import struct.MyList;

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
	
	
}
