public class Main {

	public static void main(String[] args) {
		Utility.startSimulation();
		// Do we need to properly comment??
	}

	private static SwimSimulation tank;

	public static void setup(Data swimSim) {
		tank = new SwimSimulation(swimSim.processing);
		

		// swimSim.fishPositions = Main.generateRandomPositions(4,
		// swimSim.processing.width, swimSim.processing.height);
		// swimSim.foodPositions = Main.generateRandomPositions(6,
		// swimSim.processing.width, swimSim.processing.height);
		// swimSim.hookPositions = Main.generateRandomPositions(1,
		// swimSim.processing.width, swimSim.processing.height);

	}

	public static void update(Data swimSim) {
		tank.update();
		
		//SwimSimulation.update();
	}

	/*
	 * String fish = "><(('>"; String food = "*"; String hook = "J"; // char water =
	 * '~'; int ypos; int xpos; PApplet processing = swimSim.processing;
	 * 
	 * swimSim.processing.background(0, 255, 255);// makes background cyan for (int
	 * row = 0; row < swimSim.fishPositions.length; row++) { xpos =
	 * swimSim.fishPositions[row][0]; ypos = swimSim.fishPositions[row][1];
	 * Main.placeObjectInTank(fish, processing, xpos, ypos); }
	 * 
	 * for (int row = 0; row < swimSim.foodPositions.length; row++) { xpos =
	 * swimSim.foodPositions[row][0]; ypos = swimSim.foodPositions[row][1]; //
	 * System.out.println(ypos+","+xpos); Main.placeObjectInTank(food, processing,
	 * xpos, ypos); } for (int row = 0; row < swimSim.hookPositions.length; row++) {
	 * xpos = swimSim.hookPositions[0][0]; ypos = swimSim.hookPositions[0][1];
	 * Main.placeObjectInTank(hook, processing, xpos, ypos); }
	 * 
	 * Main.moveAllObjects(swimSim.foodPositions, -1, 1, swimSim.processing.width,
	 * swimSim.processing.height);
	 * 
	 * Main.moveAllObjects(swimSim.fishPositions, 1, 0, swimSim.processing.width,
	 * swimSim.processing.height);
	 * 
	 * int dyHook = -(processing.height + 50 - swimSim.hookPositions[0][1]) / 50;
	 * Main.moveAllObjects(swimSim.hookPositions, 0, dyHook,
	 * swimSim.processing.width, swimSim.processing.height); // debugging statements
	 * // System.out.println(Arrays.deepToString(swimSim.fishPositions));// seems
	 * good // //
	 * System.out.println(Arrays.deepToString(swimSim.foodPositions));//seems //
	 * good // System.out.println("Hook Position: " + //
	 * Arrays.deepToString(swimSim.hookPositions));// failed test 3 because of //
	 * this // possible error: hook never reaches top (0 coordinate) because it
	 * moves too // fast // Should final pixels be 599 and 799?? }
	 */
	public static void fillTank(char[][] tank, char water) {
		for (int row = 0; row < tank.length; row++) {
			for (int column = 0; column < tank[row].length; column++) {
				tank[row][column] = water;
			}
		}
	}

	/*
	 * This method fills each row and column with the water char
	 * 
	 * @param tank contains the characters that are printed to the console
	 */
	public static void renderTank(char[][] tank) {
		for (int row = 0; row < tank.length; row++) {
			for (int column = 0; column < tank[row].length; column++) {
				System.out.print(tank[row][column]);
			}
			System.out.println();
		}
	}

	public static int[][] generateRandomPositions(int number, int width, int height) {
		int widthPos = 0;
		int heightPos = 0;
		int[][] positions = new int[number][2];
		for (int i = 0; i < number; i++) {
			widthPos = Utility.randomInt(width);
			heightPos = Utility.randomInt(height);
			positions[i][0] = widthPos;// this was changed
			positions[i][1] = heightPos;
		}
		return positions;
	}

	// Main.placeObjectInTank("*", tank, ypos, xpos);
	public static void placeObjectInTank(String object, PApplet processing, int headColPos, int headRowPos) {
		String thing = object;
		String fish = "><(('>";
		String food = "*";
		String hook = "J";
		int colCurrPos = headColPos;
		int rowCurrPos = headRowPos;
		PImage fishImage = processing.loadImage("images" + java.io.File.separator + "FISH.png");
		PImage foodImage = processing.loadImage("images" + java.io.File.separator + "FOOD.png");
		PImage hookImage = processing.loadImage("images" + java.io.File.separator + "HOOK.png");
		processing.fill(0);

		/*
		 * for (int i = thing.length() - 1; i >= 0; i--) {//Do we need to update this
		 * from P1? //Does this whole thing even do anything??
		 * 
		 * if (colCurrPos > processing.width ) { //should it be processing.width
		 * -1?????? colCurrPos = 0; } if (colCurrPos < 0) { colCurrPos =
		 * processing.width ; } if (rowCurrPos < 0) { rowCurrPos = processing.width ; }
		 * if (rowCurrPos > processing.width ) { rowCurrPos = 0; }
		 */
		// colCurrPos = colCurrPos - 1;
		if (fish.equals(object)) {
			processing.image(fishImage, colCurrPos, rowCurrPos);
		}
		if (food.equals(object)) {
			processing.image(foodImage, colCurrPos, rowCurrPos);
		}
		if (hook.equals(object)) {
			processing.image(hookImage, colCurrPos, rowCurrPos);
			processing.line(headColPos + 4, headRowPos - 8, processing.screenX(headColPos, 0),
					processing.screenX(0, headRowPos));
		}

	}

	public static void moveAllObjects(int[][] randomPositions, int dx, int dy, int width, int height) {
		for (int i = 0; i < randomPositions.length; i++) {

			if (randomPositions[i][0] <= 0 && dx < 0) {// does the wrap around effect
				randomPositions[i][0] = width - 1;
				// something weird is happening without minus one works for fish but not hook
				// and food? Why?
			}

			else if (randomPositions[i][0] >= width && dx > 0) {
				randomPositions[i][0] = 0;
			} else {
				randomPositions[i][0] = randomPositions[i][0] + dx;
			}

			if (randomPositions[i][1] <= 0 && dy < 0) {
				randomPositions[i][1] = height - 1;
			} else if (randomPositions[i][1] >= height && dy > 0) {
				randomPositions[i][1] = 0;
			} else {
				randomPositions[i][1] = randomPositions[i][1] + dy;
			}
			// if (randomPositions.length == 5) {
			// System.out.println("move: " + randomPositions[i][0] + ',' +
			// randomPositions[i][1]);
		}
	}

	public static void onClick(Data data, int mouseX, int mouseY) {// This method is continuously called in the main
		tank.handleClick(mouseX, mouseX);
		/*
		 * data.hookPositions[0][0] = mouseX; data.hookPositions[0][1] =
		 * data.processing.height;
		 */
	}

}