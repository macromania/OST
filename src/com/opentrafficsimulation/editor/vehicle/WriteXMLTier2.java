package com.opentrafficsimulation.editor.vehicle;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

import com.opentrafficsimulation.connector.Connector;
import com.opentrafficsimulation.connector.utility.ConnectorType;
import com.opentrafficsimulation.editor.road.RoadEditor;

public class WriteXMLTier2  {
    
    static DocumentBuilderFactory documentBuilderFactory;
    static DocumentBuilder documentBuilder;
    static Document document;
    
    
	
	
    static int x=0;
    static Deleted del=new Deleted();
	private static int o=del.getnum();
	
	int y=0;
    static String veh0[][]= new String[o][4];
    
    public static void writeXML() {
    	System.out.print(o);
       // veh[x][y]=VehicleEditor.getArray(x, y);
    	Deleted del=new Deleted();
    	veh0= del.get();
    	//int UserAdd=v1.UserAdd; 	
    	int ArrayLength=veh0.length;
 //   	System.out.println(UserInput);
        try {
//      Creating an empty XML Document
 
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.newDocument();
        
//      Creating XML tree
//      create the root element and add it to the document
 
        Element routesElement = document.createElement("routes");
        document.appendChild(routesElement);
        
        Element typeElement1 = document.createElement("vType");
        routesElement.appendChild(typeElement1);
        typeElement1.setAttribute("id","type1");
        typeElement1.setAttribute("maxSpeed","100");
        
        Element typeElement2 = document.createElement("vType");
        routesElement.appendChild(typeElement2);
        typeElement2.setAttribute("id","type2");
        typeElement2.setAttribute("maxSpeed","60");

        Element typeElement3 = document.createElement("vType");
        routesElement.appendChild(typeElement3);
        typeElement3.setAttribute("id","type3");
        typeElement3.setAttribute("maxSpeed","80");
        
        Element typeElement4 = document.createElement("vType");
        routesElement.appendChild(typeElement4);
        typeElement4.setAttribute("id","type4");
        typeElement4.setAttribute("maxSpeed","50");
        
        
        
        
        
        
        
        for (int i = 0; i < ArrayLength; i++) {
 
//      create vehicle element and add attributes
        Element vehicleElement =document.createElement("vehicle");
        routesElement.appendChild(vehicleElement);
        
        Element routeElement = document.createElement("route");
        vehicleElement.appendChild(routeElement);
        
        //Element veh0;
        //String veh0[] = (String[]) vehicle.get(i);
        
        System.out.println(veh0[i][0]);
        System.out.println(veh0[i][1]);
        System.out.println(veh0[i][2]);
        System.out.println(veh0[i][3]);
       
        vehicleElement.setAttribute("depart",veh0[i][0]);
        vehicleElement.setAttribute("id",veh0[i][1]);
        vehicleElement.setAttribute("type",veh0[i][3]);
        routeElement.setAttribute("edges",veh0[i][2]);
 
       }
            
//      create XML file
        Connector connector = new Connector(ConnectorType.CONNECTOR_PYTHON);
        File xmlFile = new File(connector.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +".rou.xml");
        //File xmlFile = new File("ResultGrid.rou.xml");
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

    
       
    public static void WriteOnly() {

        WriteXMLTier2 XML = new WriteXMLTier2();  
        //System.out.println(UserInput);
		WriteXMLTier2.writeXML();
          
    }




}