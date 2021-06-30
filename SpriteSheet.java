import java.awt.*;
import java.awt.image.*;

public class SpriteSheet {
	
	BufferedImage image;
	
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage getSprite(int x, int y, int size) {
		return image.getSubimage(x * size, y * size, size, size);
	}
	
}