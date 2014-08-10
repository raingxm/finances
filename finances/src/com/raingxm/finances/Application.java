package com.raingxm.finances;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Application extends JFrame {
	
	public Application() {
		this.setSize(1000, 400);
		this.setLocation(400, 300);
		
		Container container = this.getContentPane();
		container.add(table());
	}

	private JScrollPane table() {
		String[] titles = {"Year", "Starting Balance", "Starting Principal", "Withdrawals", "Appreciation", "Deposits", "Ending Balance"};
		DefaultTableModel model = new DefaultTableModel(titles, 0);
		JTable table = new JTable(model);
		model.addRow(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		return new JScrollPane(table);
	}
	
	public static void main(String[] args) {
		new Application().setVisible(true);
		System.out.println("Hello,world!");
	}
}
