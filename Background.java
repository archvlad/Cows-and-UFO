import java.awt.image.*;
import java.awt.*;

public class Background {
	
	BufferedImage image;
	
	public Background() {
		image = ImageLoader.getImageLoader().load("back.png");
	}
	
	public void render(Graphics2D g) {
		g.drawImage(image, 0, 0 , null);
	}
	
}