package com.opentrafficsimulation.editor.vehicle;

import com.opentrafficsimulation.connector.Connector;
import com.opentrafficsimulation.connector.utility.ConnectorType;

public class createTripeFile {
	public static void main(String[] args) {
		createTrip();
		
	}
	
	public static void createTrip()
	{
		Connector connector = new Connector(ConnectorType.CONNECTOR_PYTHON);
		String Option;
		
		{	
		Option = connector.getToolsDir()+"sumolib\\trip\\randomTrips.py -n "+connector.getOutputDir()+"myNet.net.xml";
				//RoadEditor.getInstance().netgenerate_file+".net.XML";
		Option +=" -e 50 -l";
		Option +=" -o "+ connector.getOutputDir()+ "rout.trip.xml";
		connector.runCommand(Option);
	}
	}
}
