
public class SwimSimulation {

	private PApplet processing;
	private Hook hook;
	private Fish[] fish;
	private Food[] food;

	public SwimSimulation(PApplet processing) {
		this.processing = processing;
		fish = new Fish[4];
		for (int i = 0; i < 4; i++) {
			fish[i] = new Fish(this.processing);
		}
		food = new Food[6];
		for (int i = 0; i < 6; i++) {
			food[i] = new Food(this.processing);
		}
		hook = new Hook(this.processing);

	}

	public void handleClick(int mouseX, int mouseY) {
		hook.handleClick(mouseX, mouseY);

	}

	public void update() {
		this.processing.background(0, 255, 255); // creates background
		int ypos;
		int xpos;
		for (int i = 0; i < fish.length; i++) {
			for (int j = 0; j < food.length; j++) {
				fish[i].tryToEat(food[j]);
			}
		}
		for (int i = 0; i < fish.length; i++) {
			hook.tryToCatch(fish[i]);
		}
		
		for (int i = 0; i < 4; i++) {
			fish[i].update();
		}
		for (int i = 0; i < 6; i++) {
			food[i].update();
		}
		hook.update();
		
	}

	// for (int row = 0; row < fishPositions.length; row++) {
	// xpos = fishPositions[row][0];
	// ypos = fishPositions[row][1];
	// Main.placeObjectInTank(fish, processing, xpos, ypos);
	// }

	// for (int row = 0; row < foodPositions.length; row++) {
	// xpos = foodPositions[row][0];
	// ypos = foodPositions[row][1];
	// System.out.println(ypos+","+xpos);
	// Main.placeObjectInTank(food , this.processing, xpos, ypos);
	// }
	// for (int row = 0; row < hookPositions.length; row++) {
	// xpos = hookPositions[0][0];
	// ypos = hookPositions[0][1];
	// Main.placeObjectInTank(hook, this.processing, xpos, ypos);
}

// Main.moveAllObjects(foodPositions, -1, 1, this.processing.width,
// this.processing.height);

// Main.moveAllObjects(fishPositions, 1, 0, processing.width,
// processing.height);

// int dyHook = -(this.processing.height + 50 - hookPositions[0][1]) / 50;
// Main.moveAllObjects(hookPositions, 0, dyHook, this.processing.width,
// this.processing.height);
// debugging statements
