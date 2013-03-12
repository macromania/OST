package com.opentrafficsimulation.screen.report;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ReportScreen extends JFrame {
	
	private String fileName;

	public ReportScreen(String fileName){
		this.fileName = fileName;
		init(new TripReport());
	}
	
	
	private static final long serialVersionUID = -4520562052355452085L;

	public void init(TripReport tripReport) {
		
		List<TripInfo> l = new TripReport().readTripReport(fileName);
		JTable table = new JTable(new TripTableModel(l));
		add(new JScrollPane(table));
		pack();
		setVisible(true);
	}
	
	/*public static void main(String[] args) {
		new ReportScreen().init(new TripReport());
	}*/
}
