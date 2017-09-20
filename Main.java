import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// Create a 2D array with 8 rows and 32 character in each row
		char[][] tank = new char[8][32];
		
		int[][] fishPositions = Main.generateRandomPositions(4, 32, 8);
		int[][] foodPositions = Main.generateRandomPositions(5, 32, 8);
		int[][] hookPositions = Main.generateRandomPositions(1, 32, 8);
		int xpos;
		int ypos;
		String fish = "><(('>";
		char water = '~';
		while (true) {
			
			Main.fillTank(tank, water);
			for (int row = 0; row < 4; row++) {
					xpos = fishPositions[row][0];
					ypos = fishPositions[row][1];
					Main.placeObjectInTank(fish, tank, xpos, ypos);
			}
			
			for(int row = 0; row < 5; row++) {
					xpos = foodPositions[row][0];
					ypos = foodPositions[row][1];
//					System.out.println(ypos+","+xpos);
					Main.placeObjectInTank("*", tank, xpos, ypos);
			} 
			xpos = hookPositions[0][0];
			ypos = hookPositions[0][1];
//					System.out.println(ypos + "," + xpos);
			Main.placeObjectInTank("J", tank, xpos, ypos);
					
				
			
			Main.moveAllObjects(foodPositions, -1, 1, tank[0].length, tank.length);
//			for (int[] foodPos : foodPositions) System.out.println(foodPos[0] + ", " + foodPos[1]);
			
			Main.moveAllObjects(fishPositions, 1, 0, tank[0].length, tank.length);
			Main.moveAllObjects(hookPositions, 0, -1, tank[0].length , tank.length);
			Main.renderTank(tank);
			Utility.pause(75);
			System.out.println("\n\n\n");
		}
	}


	/*
	 * Creates a water character and fills each row/column with the character
	 * through for loops
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
			positions[i][0] = Utility.randomInt(width); 
			positions[i][1] = heightPos;
		}
		return positions;
	}

//	Main.placeObjectInTank("*", tank, ypos, xpos);
	public static void placeObjectInTank(String object, char[][] tank, int headColPos, int headRowPos) {
//		object = "><(('>" // fish
//	    object = "J"
//	    object = "12345" 
//		object = "><(('>";
//		if (object.equals("*")) System.out.println("---" + headRowPos + "," + headColPos);
		String thing = object;
		int colCurrPos = headColPos;
		int rowCurrPos = headRowPos;
		for(int i = thing.length()-1; i >= 0; i--) {
			if(colCurrPos>tank[0].length - 1) {
				colCurrPos = 0;
			}
			if(colCurrPos<0) {
				colCurrPos = tank[0].length - 1;
			}
			if(rowCurrPos<0) {
				rowCurrPos = tank.length - 1;
			}
			if(rowCurrPos>tank.length - 1) {
				rowCurrPos = 0;
			}
			tank[rowCurrPos][colCurrPos] = thing.charAt(i);
			colCurrPos = colCurrPos -1;
		}
		
	}

	public static void moveAllObjects(int[][] randomPositions, int dx, int dy, int width, int height) {
		for(int i =0; i<randomPositions.length; i++) {
			randomPositions[i][0] = randomPositions[i][0] + dx;
			if(randomPositions[i][0] < 0) {
				randomPositions[i][0] = width-1;
			}
			if(randomPositions[i][0] >= width) {
				randomPositions[i][0] = 0;
			}
			
			randomPositions[i][1] = randomPositions[i][1] + dy;
			if(randomPositions[i][1] < 0) {
				randomPositions[i][1] = height-1;
			}
			if(randomPositions[i][1] >= height) {
				randomPositions[i][1] = 0;
			}
			if (randomPositions.length == 5) {
	//			System.out.println("move: " + randomPositions[i][0] + ',' + randomPositions[i][1]);
			}
		}
	}
}