
public class SwimSimulation {

	private PApplet processing;
	private Hook hook;
	private Fish[] fish;
	private Food[] food;

	public SwimSimulation(PApplet processing) {
		this.processing = processing;
		fish = new Fish[4];
		for (int i = 0; i < 4; i++) {
			fish[i] = new Fish(processing);
		}
		food = new Food[6];
		for (int i = 0; i < 6; i++) {
			food[i] = new Food(processing);
		}
		hook = new Hook(processing);
	}

	public void handleClick(int mouseX, int mouseY) {
		hook.handleClick(mouseX, mouseY);
	}

	public void update() {
		processing.background(0, 255, 255); 
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
}
