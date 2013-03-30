OST - The Open Traffic Simulation
===

The Open Trafic Simulation is a project meant to be used as an extension to advance SUMO simulation tool. It is a JAVA application that provides user friendly
interface and allows users to control some aspects of SUMO simulation easily. The reason for development is to add functionality yet to be provided in a user friendly way, by other applications like the SUMO GUI. Separate windows within the main application
window neatly arranged and tie together all the functionality that is provided to the user.

One of the main functions provided is to allow the user to easily create various
types of maps. These can be configured in a multitude ways (e.g. grid map with configurable grid length, spider map with configurable number of arms, and random map
with configurable number of maximum distance).

Other functionality provided by Open Trafic Simulation is trafic light controller.
The trafic light controller allows the user to see the list of junctions and trafic lights,
convert any selected junction to a trafic light. Also convert a random number of junctions to trafic lights. 
It provides a way to change the trafic light state while simulation is active as well. 
If the user selects a junction while the simulation is running, the user will be navigated to the visualized screen to show where that junction or trafic light
is located on the map via SUMO GUI. This makes it easy for the user to navigate to different trafic lights and change their state.

Open Trafic Simulation has been designed to allow adding vehicles to the map
(e.g. private car, bus, taxi). This makes it easy to create complex maps, with densely
populated trafic with a specific set of trafic lights. A user can then look at how trafic ows by adjusting the states of various trafic lights, adding and removing trafic lights,
as well as adding more vehicles to be simulated.

Open Trafic Simulation uses the functionality provided by the SUMO binaries and
the running simulation. It interacts with the running SUMO simulation using the a
socket connector between our software and SUMO. Thus our software is used to create
a more user-friendly interface for users to interact with, simpler way of creating and
interacting with a map to be used for simulation (e.g. Open street maps).
