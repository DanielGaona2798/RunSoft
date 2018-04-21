package views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Actions;
import controller.ContantsUi;
import controller.Controller;

public class PanelLow extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField txtRunner;
	private JSpinner spinnerIdRunner;
	private JSpinner spinnerIdStage;
	private JTextField txtStage;

	public PanelLow(Controller controller) {
		setLayout(new GridLayout(1, 3));
		
		JPanel pnlLeft = new JPanel();
		pnlLeft.setLayout(new GridLayout(3,1));
		pnlLeft.setBorder(new TitledBorder("New Runner"));
		spinnerIdRunner = new JSpinner();
		pnlLeft.add(spinnerIdRunner);
		txtRunner = new JTextField();
		pnlLeft.add(txtRunner);
		
		JButton btnRunner = new JButton("ADD_RUNNER");
		btnRunner.setActionCommand(Actions.ADD_RUNNER.toString());
		btnRunner.addActionListener(controller);
		btnRunner.setBackground(ContantsUi.COLOR_BTN);
		btnRunner.setForeground(ContantsUi.COLOR_FORGROUND_BTN);
		pnlLeft.add(btnRunner);
		
		add(pnlLeft);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(3,1));
		pnlCenter.setBorder(new TitledBorder("End Stage"));
		spinnerIdStage = new JSpinner();
		pnlCenter.add(spinnerIdStage);
	
		txtStage = new JTextField();
		pnlCenter.add(txtStage);
		
		JButton btnStage = new JButton("Add Stage");
		btnStage.setActionCommand(Actions.ADD_STAGE.toString());
		btnStage.addActionListener(controller);
		btnStage.setBackground(ContantsUi.COLOR_BTN);
		btnStage.setForeground(ContantsUi.COLOR_FORGROUND_BTN);
		pnlCenter.add(btnStage);
		
		add(pnlCenter);
		
		JPanel pnlRigth = new JPanel();
		pnlRigth.setLayout(new GridLayout(3,1));
		
		pnlRigth.setBorder(new TitledBorder("Start Simulation"));
		JButton btnStart = new JButton("START");
		btnStart.setActionCommand(Actions.START.toString());
		btnStart.addActionListener(controller);
		btnStart.setBackground(ContantsUi.COLOR_BTN);
		btnStart.setForeground(ContantsUi.COLOR_FORGROUND_BTN);
		pnlRigth.add(btnStart);
		
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setActionCommand(Actions.SHOW_WINNERS.toString());
		btnShow.addActionListener(controller);
		btnShow.setBackground(ContantsUi.COLOR_BTN);
		btnShow.setForeground(ContantsUi.COLOR_FORGROUND_BTN);
		pnlRigth.add(btnShow);
		
		JButton btnStop = new JButton("STOP");
		btnStop.setActionCommand(Actions.STOP.toString());
		btnStop.addActionListener(controller);
		btnStop.setBackground(ContantsUi.COLOR_BTN);
		btnStop.setForeground(ContantsUi.COLOR_FORGROUND_BTN);
		pnlRigth.add(btnStop);
		
		add(pnlRigth);
		
	}
}
