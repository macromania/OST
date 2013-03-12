package com.opentrafficsimulation.editor.vehicle;

import java.io.FileWriter;
import java.io.Writer;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opentrafficsimulation.connector.Connector;
import com.opentrafficsimulation.connector.utility.ConnectorType;
import com.opentrafficsimulation.editor.road.RoadEditor;

public class Add {
     static int n1=0;
	 int n2;
	 static VehicleEditor v=new VehicleEditor();
	 static int x=v.getAdd();
	 static String veh[][]=new String[x][4];
	 static Connector connector = new Connector(ConnectorType.CONNECTOR_PYTHON);
	    
	/**
	 * @param args
	 */
	public static void read() throws DocumentException, IOException{
		
	       SAXReader reader=new SAXReader();
	       OutputFormat format = OutputFormat.createPrettyPrint();
	       format.setEncoding("GBK");
	       String filePath = connector.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +".rou.xml";
	       //String filePath = "ResultGrid.rou.xml";
	       
	       File file = new File(filePath);
	       if (file.exists()){
		       Document document = (Document) reader.read(file);
		       Element routes =document.getRootElement();
		       Element vehicle=routes.element("vehicle");
		       boolean bl = false;
		       
		       List nodes = routes.elements("vehicle"); 
		       for (Iterator it = nodes.iterator(); it.hasNext();){
		    	   Element ele = (Element) it.next();
		    	   n1++;
		       }
	       }
	       
	      if(n1==0){
	    	  n1=1;
	      }
	       Add.read2();
	}
	
	
	public static void read2() throws DocumentException, IOException{
		
	       
	       
	       int n = 0,m=0;
	       String select=VehicleEditor.select;
	       int n2=n1-1;
		
	       SAXReader reader=new SAXReader();
	       OutputFormat format = OutputFormat.createPrettyPrint();
	       format.setEncoding("GBK");
	       String filePath = connector.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +"Original.rou.xml";
	       //String filePath = "sumoGrid.rou.xml";
	       
	       File file = new File(filePath);	
	       
	       if (file.exists()){
		       Document document = (Document) reader.read(file);
		     // set format
		       Element routesElement =document.getRootElement();

		       Element vehicleElement=routesElement.element("vehicle");
		       boolean bl = false;
		       
		       List nodes = routesElement.elements("vehicle"); 
		       for (Iterator it = nodes.iterator(); it.hasNext();){
		    	   
	    	       Element ele = (Element) it.next();		  
	               Element route=ele.element("route");       //vehicle's route
	        	//   String id=ele.attributeValue("id");
	        	   String depart=ele.attributeValue("depart");
	        	   String edges=route.attributeValue("edges");
	        	   String id=Integer.toString(n2);
	        	   n2++;
    	           veh[m][0]=depart;
	        	   veh[m][1]=id;
	        	   veh[m][2]=edges;
	        	   veh[m][3]=select;
	        	   
	        	   n++;
	        	   m++;
	        	   
	   	           if(n>=x){
	    	    	   break;
	 	                   }    	   
		       }
	       }
		
	       Add.write();
	       
	}
	

	
	public static void write() throws DocumentException, IOException{
		

		
		
         
		for(int b=0;b<x;b++){
	     File inputXML=new File(connector.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +".rou.xml");     
	    // File inputXML=new File("ResultGrid.rou.xml");     
		 SAXReader saxReader=new SAXReader();            
		 Document document=saxReader.read(inputXML);

		 Element routesElement=document.getRootElement();                     
		 Element vehicle = routesElement.addElement("vehicle");
		 Element route=vehicle.addElement("route");
	
		 vehicle.addAttribute("type", veh[b][3]);
		 vehicle.addAttribute("id",veh[b][1]);
		 vehicle.addAttribute("depart",veh[b][0]);
		 route.addAttribute("edges",veh[b][2]);
		 
		 
		 
	     Writer writer = new FileWriter(inputXML);            
	     OutputFormat format= OutputFormat.createPrettyPrint();        
	     XMLWriter xmlWriter = new XMLWriter(writer,format);            
	     xmlWriter.write(document);            
	     xmlWriter.close(); 
	     
		}
	     

	}	 
		 
		 
	

}
