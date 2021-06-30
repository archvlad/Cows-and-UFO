import java.awt.*;
import java.awt.image.*;

import javax.imageio.ImageIO;


public class ImageLoader {
	
	private static ImageLoader img = new ImageLoader();
	
	public BufferedImage load(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public static ImageLoader getImageLoader() {
		return img;
	}
	
}