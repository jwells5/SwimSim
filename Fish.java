
public class Fish {

	private PApplet processing;
	
	private Fish fish1 = new Fish(processing);
	private Fish fish2 = new Fish(processing);
	private Fish fish3 = new Fish(processing);
	private Fish fish4 = new Fish(processing);
	private int width;
	private int height;

	public Fish(PApplet processing) {
		this.processing = processing;
		String fishSym = "><(('>";
		int x;
		int y;
		PImage fishImage = processing.loadImage("images" + java.io.File.separator + "FISH.png");
		x = Utility.randomInt(width);
		y = Utility.randomInt(height);
	}

	public void update() {
		fish1.height = Utility.randomInt(height);
		fish1.width = Utility.randomInt(width);
		fish2.height = Utility.randomInt(height);
		fish2.width = Utility.randomInt(width);
		fish3.height = Utility.randomInt(height);
		fish3.width = Utility.randomInt(width);
		fish4.height = Utility.randomInt(height);
		fish4.width = Utility.randomInt(width);
		
		for (int i = 0; i < processing.width; i++) {
			if (width <= 0) {
				width = width - 1;
			}
		}
		processing.image(fishImage, width, height);
	}
}
