
public class SwimSimulation {

	private PApplet processing;
	private int[][] fishPositions;
	private int[][] foodPositions;
	private int[][] hookPositions;

	public SwimSimulation(PApplet processing) {
		this.processing = processing;
		fishPositions = Main.generateRandomPositions(4, processing.width, processing.height);
		foodPositions = Main.generateRandomPositions(6, processing.width, processing.height);
		hookPositions = Main.generateRandomPositions(1, processing.width, processing.height);
	}
	
	public void handleClick(int mouseX, int mouseY) {
		hookPositions[0][0] = mouseX;
		hookPositions[0][1] = processing.height;

	}

	public void update() {
		String fish = "><(('>";
		String food = "*";
		String hook = "J";
		// char water = '~';
		int ypos;
		int xpos;
		PApplet processing = this.processing;

		processing.background(0, 255, 255);// makes background cyan
		for (int row = 0; row < fishPositions.length; row++) {
			xpos = fishPositions[row][0];
			ypos = fishPositions[row][1];
			Main.placeObjectInTank(fish, processing, xpos, ypos);
		}

		for (int row = 0; row < foodPositions.length; row++) {
			xpos = foodPositions[row][0];
			ypos = foodPositions[row][1];
			// System.out.println(ypos+","+xpos);
			Main.placeObjectInTank(food, processing, xpos, ypos);
		}
		for (int row = 0; row < hookPositions.length; row++) {
			xpos = hookPositions[0][0];
			ypos = hookPositions[0][1];
			Main.placeObjectInTank(hook, processing, xpos, ypos);
		}

		Main.moveAllObjects(foodPositions, -1, 1, processing.width, processing.height);

		Main.moveAllObjects(fishPositions, 1, 0, processing.width, processing.height);

		int dyHook = -(processing.height + 50 - hookPositions[0][1]) / 50;
		Main.moveAllObjects(hookPositions, 0, dyHook, processing.width, processing.height);
		// debugging statements
	}
}
