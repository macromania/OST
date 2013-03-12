package com.opentrafficsimulation.connector;

import it.polito.appeal.traci.SumoTraciConnection;
import it.polito.appeal.traci.Vehicle;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;

import com.opentrafficsimulation.editor.light.LightEditor;
import com.opentrafficsimulation.editor.light.ReadTrafficLightState;
import com.opentrafficsimulation.screen.simulation.SimulationScreen;

public class TraciConnector {
	
	public SumoTraciConnection conn;

	public void runSimulation(String conf){
		System.out.println("Running a new simulation using config file " + conf);
		
		BasicConfigurator.configure();
		
		conn = new SumoTraciConnection(
				conf,  									// config file
				12345,                                 	// random seed
				false                                  	// look for geolocalization info in the map
				);
		
		try {
			conn.runServer();
			
			
			
			LightEditor.getInstance().isSimulationRunnig = true;
			LightEditor.getInstance().PORT_NUMBER = SimulationScreen.getInstance().portNumber;
			
			
			
			System.out.println("Map bounds are: " + conn.queryBounds());

			for (int i = 0; i < SimulationScreen.SIMULATION_TIME; i++) {
				int time = conn.getCurrentSimStep();
				/*Set<String> vehicles = conn.getActiveVehicles();

				System.out.println("At time step " + time + ", there are "
						+ vehicles.size() + " vehicles: " + vehicles);
				Iterator<String> itr = vehicles.iterator();*/
				
				/*if(i == 5)
				{
					try {
						
						ReadTrafficLightState r = new ReadTrafficLightState(conn.socket);
						String id = LightEditor.getInstance().trafficLightIDs.get(0);
						System.out.println("Connecting to traffic light:" + id);
						r.readTLState(id);
						r.chageTLState(id, "RGRGRG");
						r.readTLState(id);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}*/

				/*if (itr.hasNext()) {

					while (itr.hasNext()) {
						String vehicleID = itr.next();
						Vehicle vhc = conn.getVehicle(vehicleID);
						System.out.println(vhc.queryCurrentPosition2D());
					}
				}*/
				conn.nextSimStep();

			}

			conn.close();
		} catch (Exception e) {
			LightEditor.getInstance().isSimulationRunnig = false;
			e.printStackTrace();
		}
	}
}
