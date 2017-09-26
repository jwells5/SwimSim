
public class Hook {

	private PApplet processing;
	private PImage hookImage;
	private int width;
	private int height;

	public Hook(PApplet processing) {
		this.processing = processing;
		width = Utility.randomInt(processing.width);
		height = Utility.randomInt(processing.height);
		hookImage = processing.loadImage("images" + java.io.File.separator + "HOOK.png");

	}

	public void update() {
		int dyHook = -(processing.height + 50 - height) / 50;
		height = height + dyHook;
		if (height <= 0)
			height = processing.height;
		float topy = 0;
		processing.line(width, height, width, topy);
		processing.image(hookImage, width, height);
	}

	public void handleClick(int mouseX, int mouseY) {
		width = mouseX;
		height = processing.height;
	}

	public void tryToCatch(Fish fish) {
		if (fish.distanceTo(width, height) <= 40) {
			fish.getCaught();
			
		}

	}
}
