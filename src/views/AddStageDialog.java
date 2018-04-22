package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Actions;
import controller.ContantsUi;
import controller.Controller;
import models.entities.Stage;
import struct.MyList;
import struct.Node;

public class AddStageDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;

	public AddStageDialog(Controller controller) {
		setLayout(new BorderLayout());

		setTitle("Runner Soft");
		setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
		setSize(400,500);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"ID","NAME"});

		table = new JTable(model);
		table.setRowHeight(25);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(Color.decode("#088A85"));

		table.setFont(new Font("Arial", Font.BOLD, 18));
		table.setBackground(Color.WHITE);

		scroll = new JScrollPane(table);

		add(scroll, BorderLayout.CENTER);

		JButton btnStage = new JButton("VIEW WINNERS");
		btnStage.setActionCommand(Actions.VIEW_WINNERS.toString());
		btnStage.addActionListener(controller);
		btnStage.setBackground(ContantsUi.COLOR_BTN);
		btnStage.setForeground(ContantsUi.COLOR_FORGROUND_BTN);
		add(btnStage, BorderLayout.SOUTH);
	}

	public void refreshTable(MyList<Stage> runnerList) {
		model.setRowCount(0);
		Node<Stage> runner = runnerList.getHead();
		while (runner != null) {
			model.addRow(runner.getInformation().getObjectVector());
			runner = runner.getNext();
		}
		table.setModel(model);
	}

	public int getSelectedId(){
		return (int) table.getValueAt(table.getSelectedRow(), 0);
	}
}
