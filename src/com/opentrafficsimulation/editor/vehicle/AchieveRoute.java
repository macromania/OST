package com.opentrafficsimulation.editor.vehicle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.opentrafficsimulation.connector.Connector;
import com.opentrafficsimulation.connector.utility.ConnectorType;
import com.opentrafficsimulation.editor.road.RoadEditor;

 
public class AchieveRoute {
	
	
	public static void getFile() throws IOException{		
//  generate trip from net	
	Connector connector = new Connector(ConnectorType.CONNECTOR_PYTHON);
	String net=RoadEditor.getInstance().netgenerate_file + ".net.xml" ;

	String Option;	
	{	
	Option = connector.getToolsDir()+"sumolib\\trip\\randomTrips.py -n "+connector.getOutputDir()+net;
	//RoadEditor.getInstance().netgenerate_file+ net.XML";
	Option +=" -e 50 -l";
	//Option +=" -o "+ connector.getOutputDir()+ "trip.trips.xml";
	Option +=" -o "+ connector.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +".trips.xml";
	connector.runCommand(Option);
}
		
//  transfer trip to route file
	Connector connector1 = new Connector(ConnectorType.CONNECTOR_ROUTER);
	String Options1;	
	{
	Options1 = "-n " + connector1.getOutputDir()+RoadEditor.getInstance().netgenerate_file +".net.xml";
	//Options1 += net;
	Options1 +=" -t "+ connector1.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +".trips.xml";
	Options1 +=" -o "+ connector1.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +"Original.rou.xml";
	System.out.println("Original route file is "+connector1.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +"Original.rou.xml"+" OVER");
	connector1.runCommand(Options1);
    }
	
    // create new route file
	   Document document=DocumentHelper.createDocument();
	   Element routesElement=document.addElement("routes");
	// set type element  
	// set attributes of private car
	   Element typeElement1=routesElement.addElement("vType");
	   typeElement1.addAttribute("id","type1"); 
	   typeElement1.addAttribute("maxSpeed","100");
	 
	// set attributes of bus
	   Element typeElement2=routesElement.addElement("vType");
	   typeElement2.addAttribute("id","type2"); 
	   typeElement2.addAttribute("maxSpeed","60");
	   
	// set attributes of taxi
	   Element typeElement3=routesElement.addElement("vType");
	   typeElement3.addAttribute("id","type3"); 
	   typeElement3.addAttribute("maxSpeed","80");
	   
	// set attributes of lorry
	   Element typeElement4=routesElement.addElement("vType");
	   typeElement4.addAttribute("id","type4"); 
	   typeElement4.addAttribute("maxSpeed","50");
	 
	// write xml file
	   Connector connector2 = new Connector(ConnectorType.CONNECTOR_ROUTER);
	   String con=connector.getOutputDir();
	   String road=RoadEditor.getInstance().netgenerate_file;
	   System.out.println(connector.getOutputDir());
	   System.out.println("0000000000");
	   System.out.println(road);
	 System.out.println("0000000000");
	   File inputXML=new File(con + road + ".rou.xml");
  //File inputXML=new File(connector.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +".rou.xml");
  System.out.println("New generated route file "+ connector.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +".rou.xml");
  //File inputXML=new File("ResultGrid.rou.xml"); 
	 Writer writer = new FileWriter(inputXML);            
  OutputFormat format= OutputFormat.createPrettyPrint();        
  XMLWriter xmlWriter = new XMLWriter(writer,format);            
  xmlWriter.write(document);            
  xmlWriter.close(); 
		
	}
	
}	
	
	


