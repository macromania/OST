package com.opentrafficsimulation.screen.report;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EmissReport {
	public ArrayList<EmissionInfo> readEmissionReport(String emissionFile) {
		ArrayList<EmissionInfo> tripInfoList = new ArrayList<EmissionInfo>();
		try {
			File nodes = new File(emissionFile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(nodes);
			document.getDocumentElement().normalize();
			NodeList tripInfoElements = document.getElementsByTagName("emission-export");
			for (int i = 0; i < tripInfoElements.getLength(); i++) {
				Node node = tripInfoElements.item(i);
				Element element = (Element) node;
				EmissionInfo emissionInfo = new EmissionInfo();
				emissionInfo.id = element.getAttribute("time");
				emissionInfo.depart = element.getAttribute("id");
				emissionInfo.departLane = element.getAttribute("eclass");
				emissionInfo.departPos = element.getAttribute("co2");
				emissionInfo.departSpeed = element.getAttribute("co");
				emissionInfo.departDelay = element.getAttribute("hc");
				emissionInfo.arrival = element.getAttribute("nox");
				emissionInfo.arrivalLane = element.getAttribute("pmx");
				emissionInfo.arrivalPos = element.getAttribute("noise");
				emissionInfo.arrivalSpeed = element.getAttribute("route");
				emissionInfo.duration = element.getAttribute("type");
				emissionInfo.routeLength = element.getAttribute("waiting");
				emissionInfo.waitSteps = element.getAttribute("lane");
				emissionInfo.rerouteNo = element.getAttribute("pos");
				emissionInfo.devices = element.getAttribute("speed");
				emissionInfo.vType = element.getAttribute("angle");
				emissionInfo.vaporized = element.getAttribute("x");
                                emissionInfo.vaporized = element.getAttribute("y");
				tripInfoList.add(emissionInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tripInfoList;
	}
	
	/*
	public static void main(String[] args) {
		new EmissReport().readEmissionReport("C:\\SUMO\\docs\\tutorial\\quickstart\\data\\trip.xml");
	}
	*/
	
}
