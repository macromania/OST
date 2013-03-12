package com.opentrafficsimulation.editor.light;

import it.polito.appeal.traci.protocol.Command;
import it.polito.appeal.traci.protocol.Constants;
import it.polito.appeal.traci.protocol.ResponseContainer;
import it.polito.appeal.traci.protocol.StringList;
import it.polito.appeal.traci.query.Query;

import java.io.IOException;
import java.net.Socket;

public class ReadTrafficLightState extends Query {

	public int portNumber;
	
	public ReadTrafficLightState(Socket sock) throws IOException {
		super(sock);
	}
	
	public void readTrafficLightIds() throws IOException {
		Command cmd = makeReadVarCommand(Constants.CMD_GET_TL_VARIABLE, Constants.ID_LIST, "");
		ResponseContainer respc = queryAndVerifySingle(cmd);
		Command resp = respc.getResponse();
		System.out.println("Variable : " + resp.content().readUnsignedByte());
		System.out.println("TL ID : " + resp.content().readStringASCII());
				
		StringList stringList = new StringList(resp.content(), true);
		for (String s : stringList) {
			System.out.println("S : " + s);
		}
	}
	
	public String readTLState(String id) throws IOException {
		Command cmd = makeReadVarCommand(Constants.CMD_GET_TL_VARIABLE, Constants.TL_RED_YELLOW_GREEN_STATE, id);
		ResponseContainer respc = queryAndVerifySingle(cmd);
		Command resp = respc.getResponse();
		System.out.println("Variable : " + resp.content().readUnsignedByte());
		System.out.println("TL ID : " + resp.content().readStringASCII());
		System.out.println("Return type : " + resp.content().readUnsignedByte());
		String lightState = resp.content().readStringASCII();
		System.out.println("Light state : " + lightState);
		return lightState;
	}
	
	public void chageTLState(String id, String state) throws IOException {
		Command cmd = new Command(Constants.CMD_SET_TL_VARIABLE);
		cmd.content().writeUnsignedByte(Constants.DOMVAR_CO2EMISSION);
		cmd.content().writeStringASCII(id);
		cmd.content().writeUnsignedByte(Constants.TYPE_STRING);
		cmd.content().writeStringASCII(state);
		ResponseContainer respc = queryAndVerifySingle(cmd);
		Command resp = respc.getResponse();
	}
	
	public void goToTrafficLight(String id) throws IOException {
		
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Start");
		Socket s = new Socket("localhost", LightEditor.getInstance().PORT_NUMBER);
		ReadTrafficLightState r = new ReadTrafficLightState(s);
		r.readTLState("1");
		r.chageTLState("1", "RRRRRR");
		r.readTLState("1");
		
		System.out.println("End");
	}

}
