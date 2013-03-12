package com.opentrafficsimulation.editor.light;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class TrafficLightReader {

	/*
	 * This method takes a network file, and retrieves all the junctions
	 * present in the file. The method will return a list of these junctions.
	 * 
	 * @param fileName represents the file with the SUMO network data
	 * 
	 * @return specifies a list of junctions present in the network file
	 */
	public ArrayList<Junction> readNetworkFile(String fileName) {
		ArrayList<Junction> junctionList = new ArrayList<Junction>();
		try {
			File nodes = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(nodes);
			document.getDocumentElement().normalize();
			NodeList junctionElements = document.getElementsByTagName("junction");
			for (int i = 0; i < junctionElements.getLength(); i++) {
				Node node = junctionElements.item(i);
				Element element = (Element) node;
				
				// Only include junctions where there are links
				if (element.getAttribute("intLanes").equals("")) {
					continue;
				}
				
				junctionList.add(new Junction(element.getAttribute("id"), element.getAttribute("type")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return junctionList;
	}
}
