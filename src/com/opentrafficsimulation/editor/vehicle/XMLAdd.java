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

public class XMLAdd {
	
	static int  current;
public static void Add() throws DocumentException,IOException{
//  identify the num of records in result file and add records required
	
	       int i=0;
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
	       
//	     calculate the number of current records i before add operation
	       
	       for (Iterator it = nodes.iterator(); it.hasNext();) {
	    	       
	    	       Element ele = (Element) it.next();		  	        	   	        	        	    	       
	    	       i++;		
	}
	    
	       // get the required add value and run the current one
	       int UserAdd=VehicleEditor.getAdd();
	       current=i+UserAdd;
	     //  System.out.println(i);
	         System.out.println(UserAdd);
	         
	         //System.out.print(current);
	         
		       WriteXMLTier1 XML = new WriteXMLTier1();
		       current=current-1;
		       XML.writeXML(current);
		       //XML.writeXML(UserAdd);
	        
}
	      
	     
}
  // static int a=current; 
   public static int getCurrent(){
	   		return current;
	   	}
 


}