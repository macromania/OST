
package com.opentrafficsimulation.screen.simulation;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import com.opentrafficsimulation.connector.Connector;
import com.opentrafficsimulation.connector.TraciConnector;
import com.opentrafficsimulation.connector.utility.ConnectorType;
import com.opentrafficsimulation.editor.road.RoadEditor;
import com.opentrafficsimulation.gui.MainGUI;
import com.opentrafficsimulation.screen.report.ReportScreen;

import java.awt.Dimension;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SimulationScreen {

	// Singleton instance
	private static SimulationScreen simulationScreen = new SimulationScreen();

	public static int SIMULATION_TIME = 10;
	
	public int portNumber;
	
	public TraciConnector traciConnector;

	private SimulationScreen() {

	}

	public static SimulationScreen getInstance() {
		return simulationScreen;
	}

	public void runSimulation() {
		
		if (RoadEditor.getInstance().netgenerate_file != null) {
			
			try {
				
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				
				// config element
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("configuration");				
				rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
				rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "http://sumo.sf.net/xsd/sumoConfiguration.xsd");
				doc.appendChild(rootElement);
				
				// input element
				Element inputElement = doc.createElement("input");
				
				// net file value
				Element netFile = doc.createElement("net-file");
				netFile.setAttribute("value", RoadEditor.getInstance().netgenerate_file + ".net.xml");
				
				// rou file value
				Element rouFile = doc.createElement("route-files");
				rouFile.setAttribute("value", RoadEditor.getInstance().netgenerate_file + ".rou.xml");
				
				// appending rou and net file to input element
				inputElement.appendChild(netFile);
				inputElement.appendChild(rouFile);
				
				// appending input element to config element
				rootElement.appendChild(inputElement);
				
				// time element
				Element timeElement = doc.createElement("time");
				
				// begin time
				Element beginTime = doc.createElement("begin");
				beginTime.setAttribute("value", "0");
				
				// TO-DO: adding report tags for report screen
				
				// end time
				Element endTime = doc.createElement("end");
				endTime.setAttribute("value", String.valueOf(SIMULATION_TIME));
				
				// append begin and end time to time element
				timeElement.appendChild(beginTime);
				timeElement.appendChild(endTime);
				
				// append time element to config element
				rootElement.appendChild(timeElement);
				
				// write the content into xml file with the net file name
				String configurationFileName = new Connector(ConnectorType.CONNECTOR_NETCONVERT).getOutputDir() + RoadEditor.getInstance().netgenerate_file + ".sumo.cfg";
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(configurationFileName));
		 
				// Output to console for testing
				transformer.transform(source, result);
				
				
				// Run the simulation with the configuration
				// Run the simulation with the configuration		
				SwingWorker worker = new SwingWorker<String, Object>() {
				    @Override
				    public String doInBackground() {
				    	
				    	String configurationFileName = new Connector(ConnectorType.CONNECTOR_NETCONVERT).getOutputDir() + RoadEditor.getInstance().netgenerate_file + ".sumo.cfg";
						traciConnector = new TraciConnector();
						traciConnector.runSimulation(configurationFileName);
						
						
				    	return "running";
				    }

				    @Override
				    public void done() {
				    	System.out.println("simalation screen closed / simulation completed");
				    	
				    	String filename = new Connector(ConnectorType.CONNECTOR_NETCONVERT).getOutputDir() + RoadEditor.getInstance().netgenerate_file + Integer.toString(portNumber)+".trip.xml";
				    	new ReportScreen(filename);
				    }
				};
				
				
				worker.execute();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
				
			}
			
		}
		else
		{
			JDialog errorDialog = new JDialog(MainGUI.getInstance(),true);
			errorDialog.setPreferredSize(new Dimension(300, 200));
			errorDialog.setSize(300, 200);
			errorDialog.setTitle("Missing files for configuration");
			
			JLabel errorLabel = new JLabel();
			errorLabel.setText("<html><p>Please check net and rou files<br/>before running simulation!</p></html>");
			errorDialog.add(errorLabel);
			
			errorDialog.setVisible(true);
		}
	}
}