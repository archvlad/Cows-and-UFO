import java.awt.image.*;
import java.awt.*;

public class Tele extends GameObject {
	
	BufferedImage image2;
	
	public Tele() {
		image = ImageLoader.getImageLoader().load("tele.png");
		image2 = ImageLoader.getImageLoader().load("tele2.png");
	}
	
	public void tick(double delta) {
		
	}
	
	public void render(Graphics2D g) {
		g.drawImage(image, 0, 0, null);
		g.drawImage(image2, 0, 0, null);
	}
	
}