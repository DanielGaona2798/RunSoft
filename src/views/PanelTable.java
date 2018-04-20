package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.entities.Runner;
import struct.Node;
import struct.Queue;


public class PanelTable extends JDialog{
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;

	public PanelTable() {
		setLayout(new BorderLayout());

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
	}

	public void refreshTable(Queue<Runner> runnerList) {
		model.setRowCount(0);
		Node<Runner> runner = runnerList.getHead();
		while (runner != null) {
			model.addRow(runner.getInformation().getObjectVector());
			runner = runner.getNext();
		}
		table.setModel(model);
	}


}
