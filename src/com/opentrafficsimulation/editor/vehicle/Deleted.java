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

import com.opentrafficsimulation.connector.Connector;
import com.opentrafficsimulation.connector.utility.ConnectorType;
import com.opentrafficsimulation.editor.road.RoadEditor;

public class Deleted {
	    int n;
	    static int num = 0;
    	static int f = 0;
	    static String veh[][] = new String[3800][4];
	    static Connector connector = new Connector(ConnectorType.CONNECTOR_PYTHON);   
	
	    public static void Read() throws DocumentException,IOException{


	
	   	   SAXReader reader=new SAXReader();
	       OutputFormat format = OutputFormat.createPrettyPrint();
	       format.setEncoding("GBK");
	       
	       String filePath = connector.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +".rou.xml";
	       //String filePath = "ResultGrid.rou.xml";
	       
	       String userdel=VehicleEditor.Select();
	       File file = new File(filePath);
	       
	       if (file.exists()){
		       Document document = (Document) reader.read(file);
		       // set xml format
		       Element routesElement =document.getRootElement();
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
		       Element vehicle=routesElement.element("vehicle");
		       
		       
		       List nodes = routesElement.elements("vehicle");     	     
		       int i=0;
		       for (Iterator it = nodes.iterator(); it.hasNext();){
	    	       Element ele = (Element) it.next();		  
	               Element route=ele.element("route");       //vehicle's route
	        	   String id=ele.attributeValue("id");
	        	   String depart=ele.attributeValue("depart");
	        	   String edges=route.attributeValue("edges");
	        	   String type=ele.attributeValue("type");
	        	   f=i;
	    	       veh[f][0]=depart;
	        	   veh[f][1]=id;
	        	   veh[f][2]=edges;
	        	   veh[f][3]=type;
	        	   
	        //	   System.out.print(veh[f][0]);
	        	   i++;
		       }
		       VehicleEditor v=new VehicleEditor();
		       int y=VehicleEditor.getDel();
		       String selecttype=VehicleEditor.Select();
		      
		       if(y<i){
		           for (int m = 0; m < y; m++) {
		               
		               if (veh[m][3]==selecttype ) {
		                   veh[m][0]=null;
		                   veh[m][1]=null;
		                   veh[m][2]=null;
		                   veh[m][3]=null;
		           }
               num=i-y;
               System.out.print(veh[m][0]);
		       WriteXMLTier2 XML = new WriteXMLTier2();  
		       WriteXMLTier2.WriteOnly();         
		       System.out.print(num);
		       }
		       
		       
		     }
		       
		       
		       
	       }
	
    }


    public String[][] get(){
	      String veh1[][] = new String[num][4];
	      VehicleEditor v=new VehicleEditor();
	      String selecttype=VehicleEditor.Select();
	       int nx=0,ny=0,k=0;
	       while(nx<num){
	    	   if(ny<=num){
	               veh1[nx][0]=veh[ny][0];
	               veh1[nx][1]=veh[ny][1];
	               veh1[nx][2]=veh[ny][2];
	               veh1[nx][3]=veh[ny][3];
	               //System.out.println(veh1[ny][0]);
	               nx++;
	    	   }
	    	   ny++;
	       }
    	
		return veh1;
    	
    }


	public int getnum() {

		return num;
	}

	
}