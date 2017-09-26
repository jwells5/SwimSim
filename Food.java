
public class Food {

	private PApplet processing;
	private PImage foodImage;
	private int width;
	private int height;

	public Food(PApplet processing) {
		this.processing = processing;
		width = Utility.randomInt(processing.width);
		height = Utility.randomInt(processing.height);
		foodImage = processing.loadImage("images" + java.io.File.separator + "FOOD.png");

		}

	public void update() {
		width--;
		height++;
		if (width <= 0)
			width = processing.width;
		if (height >= processing.height) {
			height = 0;
		}
		processing.image(foodImage, width, height);
		
	}
	public float distanceTo(int x, int y) {
		float distance = (float) Math.sqrt(Math.pow(width - x, 2) + Math.pow(height - y, 2));
		return distance;
	}
	
	public void getEaten() {
		width = Utility.randomInt(processing.width);
		height = 0;
	}
}
