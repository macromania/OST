package com.opentrafficsimulation.editor.vehicle;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;

public class XMLDel {
	int UserDel=VehicleEditor.getDel();
	static String[][] veh= new String[3800][3];	
	
	public static void Del() throws DocumentException,IOException{

		
	   	   SAXReader reader=new SAXReader();
	       OutputFormat format = OutputFormat.createPrettyPrint();
	       
//	     set xml file's coding format
	       format.setEncoding("GBK");
	       String filePath = "ResultGrid.rou.xml";
	       //String filePath = "ResultSpider.rou.xml";
	       //String filePath = "ResultRandom.rou.xml";

	       File file = new File(filePath);	              
	       if (file.exists()) {
	    	   
//	     read xml file
	       Document document = reader.read(file);
	       Element routes =document.getRootElement();
	       Element vehicle=routes.element("vehicle");
	       boolean bl = false;
	       
//	     traverse vehicle
	       List nodes = routes.elements("vehicle");     	   
	      
	       int i=0;
	       for (Iterator it = nodes.iterator(); it.hasNext();) {
	    	       
	    	       Element ele = (Element) it.next();		  	        	   	        	        	    	       
	    	       i++;		
	}
	       System.out.println(i);
	       // get the del num and run the current mun
	       int UserDel=VehicleEditor.getDel();
	       int current=i-UserDel-1;
	       System.out.println(current);
	       
	       WriteXMLTier1 XML = new WriteXMLTier1();  
	       XML.writeXML(current);
	   

	       
	       }
	}

	
	


}
