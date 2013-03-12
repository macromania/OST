package com.opentrafficsimulation.editor.vehicle;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLTier1  {
    
    DocumentBuilderFactory documentBuilderFactory;
    DocumentBuilder documentBuilder;
    Document document;
    static String[][] veh0= new String[3800][4];
    int x=0,y=0;
    
    
    public void writeXML(int UserInput) {
       // veh[x][y]=VehicleEditor.getArray(x, y);
    	VehicleEditor v1=new VehicleEditor();
    	veh0=VehicleEditor.veh;
    	//int UserAdd=v1.UserAdd; 	
    	int ArrayLength=veh0.length;
    	System.out.println(UserInput);
        try {
//      Creating an empty XML Document
 
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.newDocument();
        
//      Creating XML tree
//      create the root element and add it to the document
 
        Element routesElement = document.createElement("routes");
        document.appendChild(routesElement);
        //int ArrayLength=VehicleEditor.getArrayLength();
        
        for (int i = 0; i < ArrayLength; i++) {
 
//      create vehicle element and add attributes
        Element vehicleElement =document.createElement("vehicle");
        routesElement.appendChild(vehicleElement);
        
        Element routeElement = document.createElement("route");
        vehicleElement.appendChild(routeElement);
        
        //Element veh0;
        //String veh0[] = (String[]) vehicle.get(i);
        
        //System.out.println(veh0[x][0]);
        //System.out.println(veh0[x][1]);
        //System.out.println(veh0[x][2]);
        //System.out.println(veh0[x][3]);
       
        vehicleElement.setAttribute("depart",veh0[x][0]);
        vehicleElement.setAttribute("id",veh0[x][1]);
        vehicleElement.setAttribute("Type",veh0[x][3]);
        routeElement.setAttribute("edges",veh0[x][2]);
        x++;
         if(i>=UserInput){
        	 break;
         } 
       }
            
//      create XML file
        //File xmlFile = new File("route.rou.xml");
        File xmlFile = new File("ResultGrid.rou.xml");
        //File xmlFile = new File("ResultSpider.rou.xml");
        //File xmlFile = new File("ResultRandom.rou.xml");


        xmlFile.createNewFile();
        FileOutputStream isod = new FileOutputStream(xmlFile);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(isod);
        transformer.transform(source, result);
        isod.flush();
        isod.close();
 
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (TransformerException ex) {
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
 
   }

    
       
    public static void WriteOnly(int UserInput) {

        WriteXMLTier1 XML = new WriteXMLTier1();  
        System.out.println(UserInput);
		XML.writeXML(UserInput);
          
    }
}