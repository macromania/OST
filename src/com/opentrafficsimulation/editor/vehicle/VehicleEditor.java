package com.opentrafficsimulation.editor.vehicle;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.opentrafficsimulation.connector.Connector;
import com.opentrafficsimulation.connector.utility.ConnectorType;
import com.opentrafficsimulation.editor.road.RoadEditor;
import com.opentrafficsimulation.utility.constants.AppConstants;

public class VehicleEditor extends JPanel {
	
	

	// define public adding value from user 

	 static int UserAdd;
	 static int UserDel;
	 static String select;
	
	static String[][] veh= new String[3800][4];
	
	private static final long serialVersionUID = -7292254993717333286L;

	// Singleton instance
	private static VehicleEditor VehicleEditor = new VehicleEditor();
	
	// Main pane
	private Container pane;
	
	// Main panel
	private JPanel welcomePanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	
	// Content wrapper
	private JScrollPane scrollPane;
	private JPanel content;
	
	// Create buttons
	private JButton ButtonAdd = new JButton("add vehicle");
	private JButton ButtonDel = new JButton("delete vehicle");
	
	// Create TextField
    private static JTextField TextAdd = new JTextField("");
    private static JTextField TextDel = new JTextField("");
    
    //Creat JRatioButton
    public static JRadioButton jb1=new JRadioButton("Private Car");
    public static JRadioButton jb2=new JRadioButton("Bus");
    public static JRadioButton jb3=new JRadioButton("Taxi");
    public static JRadioButton jb4=new JRadioButton("Lorry");
    
    
	public static int getDel(){
		UserDel=Integer.parseInt(TextDel.getText());
		
		return UserDel;
	}
	public static int getAdd(){
		
		UserAdd=Integer.parseInt(TextAdd.getText());
	
		return UserAdd;
	}	
	
        		
	// Show new frame
	public VehicleEditor(){
		
		ButtonDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				
				UserDel=Integer.parseInt(TextDel.getText());
			 try {      			  
			     Deleted.Read();       	
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  
		 
		  
	}		
		});
		
        ButtonAdd.addActionListener(new ActionListener()
        {

        	@Override
			public void actionPerformed(ActionEvent ae){
        	UserAdd =  Integer.parseInt(TextAdd.getText()); 
        	Connector connector = new Connector(ConnectorType.CONNECTOR_ROUTER);
            String filePath = connector.getOutputDir()+ RoadEditor.getInstance().netgenerate_file +".rou.xml";
 	       //String filePath = "ResultGrid.rou.xml";
 	       
 	       File file = new File(filePath);
 	       if (file.exists()){
 	    	   
 	    	   	
                try {      			  
        			  Add.read();   	
     		  } catch (Exception e) {
     		   e.printStackTrace();
     		  }	  
 	       }
 	       
 	       
          else{
        		
        		try{
        	         AchieveRoute.getFile();
        	  } catch(Exception e){
        	  e.printStackTrace();
        	  }
        		
        		try {      			  
      			  Add.read();   	
   		      } catch (Exception e) {
   		      e.printStackTrace();
   		      }	  
	          }
 	      
        	//UserAdd =  Integer.parseInt(TextAdd.getText()); 	  
     		  
        	}
        	
        	
        });
	}
	   
	/**
	 * Used for invoking instance
	 * 
	 * @return
	 */
	public static VehicleEditor getInstance() {
		return VehicleEditor;
	}
	
	/**
	 * Initialises an instance of Main GUI
	 * @throws IOException 
	 */
	public void init() throws IOException {	
			
		// Set size
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBorder(new TitledBorder("Vehicles"));
		setPreferredSize(new Dimension(AppConstants.APP_LEFT_COLUMN_WIDGET_WIDTH,AppConstants.APP_LEFT_COLUMN_WIDGET_HEIGHT));	
		
		// Initialize editor content
		content = new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		// Set scroller
		scrollPane = new JScrollPane(content);  
		scrollPane.setSize(AppConstants.APP_LEFT_COLUMN_WIDGET_WIDTH, AppConstants.APP_LEFT_COLUMN_WIDGET_HEIGHT);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		add(scrollPane);
		add(ButtonAdd);
		add(ButtonDel);	
		add(jb1);
		add(jb2);
		add(jb3);
		add(jb4);
		add(TextAdd);
		add(TextDel);
		setVisible(true);
		
		//JRatioButton Actionevent
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				select="type1";
				System.out.print(select);
				jb2.setSelected(false);
				jb3.setSelected(false);
				jb4.setSelected(false);
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				select="type2";
				System.out.print(select);
				jb1.setSelected(false);
				jb3.setSelected(false);
				jb4.setSelected(false);
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				select="type3";
				System.out.print(select);
				jb1.setSelected(false);
				jb2.setSelected(false);
				jb4.setSelected(false);
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				select="type3";
				System.out.print(select);
				jb1.setSelected(false);
				jb2.setSelected(false);
				jb3.setSelected(false);
			}
		});
	
 	   
 
   	  
   	   
	
	}

	/*static void ReadFirst(String[] args) throws DocumentException {
		   int x=0,i=0;
		   
	       SAXReader reader=new SAXReader();
	       OutputFormat format = OutputFormat.createPrettyPrint();
	       
//	     set xml file's coding format
	       format.setEncoding("GBK");
	       String filePath = "sumoGrid.rou.xml";
	       //String filePath = "sumoSpider.rou.xml";
	       //String filePath = "sumoRandom.rou.xml";
	       
	       File file = new File(filePath);	              
	       if (file.exists()) {
	    	   
//	     read xml file
	       Document document = reader.read(file);
	       Element routes =document.getRootElement();
	       Element vehicle=routes.element("vehicle");
	       boolean bl = false;
	       
//	     traverse vehicle
	       List nodes = routes.elements("vehicle");     	   
	      
	       
	       for (Iterator it = nodes.iterator(); it.hasNext();) {
	    	       
	    	       Element ele = (Element) it.next();		  
	               Element route=ele.element("route");       //vehicle's route
	        	   String id=ele.attributeValue("id");
	        	   String depart=ele.attributeValue("depart");
	        	   String edges=route.attributeValue("edges");
	        	   
	    	       veh[x][0]=depart;
	        	   veh[x][1]=id;
	        	   veh[x][2]=edges;
	        	   veh[x][3]=select;
	        	          	  
	    	       //System.out.println(id);
	    	       //System.out.println(depart);
	    	       //System.out.println(edges); 
	    	       
	    	       //System.out.println(veh[x][0]);
	    	       //System.out.println(veh[x][1]);
	    	       //System.out.println(veh[x][2]);
	        	   
	    	       x++;
/*
	    	       i++;
	   	           if(i>=UserAdd){
	    	    	   break;
	 	       }
  */

	public static String Select() {
		// TODO Auto-generated method stub
		return select;
	}
	
	
}

