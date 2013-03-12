package com.opentrafficsimulation.editor.light;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Dialog.ModalExclusionType;
import java.awt.LayoutManager2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TrafficLighStateWindow extends JFrame {
	private static final long serialVersionUID = 1504275692564132699L;
	ReadTrafficLightState reader;
	JLabel stateLabel = new JLabel();
	String id;

	public TrafficLighStateWindow(String id) throws UnknownHostException, IOException {
		this.id = id;
		Socket s = new Socket("localhost", LightEditor.PORT_NUMBER);
		reader = new ReadTrafficLightState(s);
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(100, 100));
		panel.add(stateLabel);
		JButton red = new JButton("Make Red");
		red.addActionListener(generateListener("RRRRRR"));
		JButton green = new JButton("Make Green");
		green.addActionListener(generateListener("GGGGGG"));
		JButton yellow = new JButton("Make Yellow");
		yellow.addActionListener(generateListener("YYYYYY"));
		panel.add(red);
		panel.add(green);
		panel.add(yellow);
		//setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		getContentPane().add(panel, BorderLayout.CENTER);
		refreshState();
		setVisible(true);
		pack();
	}
	
	private void refreshState() {
		try {
			String state = reader.readTLState(id);
			stateLabel.setText(state);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not read traffic light state");
			e.printStackTrace();
		}
	}
	
	private ActionListener generateListener(final String state) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					reader.chageTLState(id, state);
					refreshState();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Could not change the traffic light state");
					e1.printStackTrace();
				}
			}
		};
	}
}
