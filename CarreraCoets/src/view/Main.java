package view;

import java.util.LinkedList;
import java.util.List;

import application.RaceController;
import application.dto.CircuitDTO;
import application.dto.RocketDTO;

public class Main {

	private static RaceController controller = RaceController.getInstance();
	private static Observer observer = new Observer();

	public static void main(String[] args) {

		try {
			List<RocketDTO> rocketsListDTO = new LinkedList<RocketDTO>();
			rocketsListDTO = controller.createRockets();		
			CircuitDTO circuitDTO = controller.createCircuit(observer);
			controller.addRockets(rocketsListDTO);
			startRace(circuitDTO);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void startRace(CircuitDTO circuitDTO) throws Exception{
		System.out.println("Starting competition. Circuit length: " + circuitDTO.getCircuitLength() + " Max time: "
				+ circuitDTO.getMaximumTime());
		
		controller.startRace();
	}
	
	public static void updateRace() throws Exception {
		System.out.print(controller.updateRace());
	}
	
}
