package com.opentrafficsimulation.screen.report;

import java.util.List;
import javax.swing.table.*;

public class EmissionTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 11232312312L;
	private List<EmissionInfo> list;
	
	public EmissionTableModel(List<EmissionInfo> list) {
		this.list = list;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		EmissionInfo emissionInfo = list.get(arg0);
		switch(arg1) {
			case 0: return emissionInfo.id;
			case 1: return emissionInfo.depart;
			case 2: return emissionInfo.departLane;
			case 3: return emissionInfo.departPos;
			case 4: return emissionInfo.departSpeed;
			case 5: return emissionInfo.departDelay;
			case 6: return emissionInfo.arrival;
			case 7: return emissionInfo.arrivalLane;
			case 8: return emissionInfo.arrivalPos;
			case 9: return emissionInfo.arrivalSpeed;
			case 10: return emissionInfo.duration;
			case 11: return emissionInfo.routeLength;
			case 12: return emissionInfo.waitSteps;
			case 13: return emissionInfo.rerouteNo;
			case 14: return emissionInfo.devices;
			case 15: return emissionInfo.vType;
			case 16: return emissionInfo.vaporized;
		}
		return null;
	}
	
	public void setList(List<EmissionInfo> list) {
		this.list = list;
	}


}
