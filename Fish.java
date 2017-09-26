
public class Fish {

	private PApplet processing;
	private PImage fishImage;
	private int width;
	private int height;

	public Fish(PApplet processing) {
		this.processing = processing;
		width = Utility.randomInt(processing.width);
		height = Utility.randomInt(processing.height);
		fishImage = processing.loadImage("images" + java.io.File.separator + "FISH.png");
	}

	public void update() {
		width++;
		if (width >= processing.width)
			width = 0;
		processing.image(fishImage, width, height);
	}

	public void tryToEat(Food food) {
		if (food.distanceTo(width, height) <= 40) {
			food.getEaten();
		}
	}

	public void getCaught() {
		width = 0;
		height = Utility.randomInt(processing.height);
	}

	public float distanceTo(int x, int y) {
		float distance = (float) Math.sqrt(Math.pow(width - x, 2) + Math.pow(height - y, 2));
		return distance;
	}
}
