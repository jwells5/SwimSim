public class Main {

	public static void main(String[] args) {
		Utility.startSimulation();
	}

	private static SwimSimulation tank;

	public static void setup(Data swimSim) {
		tank = new SwimSimulation(swimSim.processing);
	}

	public static void update(Data swimSim) {
		tank.update();
	}

	public static void fillTank(char[][] tank, char water) {
		for (int row = 0; row < tank.length; row++) {
			for (int column = 0; column < tank[row].length; column++) {
				tank[row][column] = water;
			}
		}
	}

	public static void onClick(Data data, int mouseX, int mouseY) {// This method is continuously called in the main
		tank.handleClick(mouseX, mouseX);
	}

}