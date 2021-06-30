import java.awt.image.*;
import java.awt.*;

import java.awt.geom.AffineTransform;

public class Cow extends GameObject {
	
	Player p;
	
	public Cow(BufferedImage image, Player p) {
		this.image = image;
		x = 100;
		y = 190;
		this.p = p;
	}
	double v = 0;
	public void tick(double delta) {
		if (x >= p.x - 29 + 15 - 16 && x <= p.x + 29 + 1 + 15 - 16 && (y + size - 1) - p.y <= 146) {
			System.out.println(find());
			if (p.leftDrag) {
				x-=10 * delta / 1000;
			}
			if (p.rightDrag) {
				x+=10 * delta / 1000;
			}
			y-=10 * delta / 1000;
			v = 0;
			if (y < p.y + 24 + 10 - 5) {
				y = p.y + 24 + 10 - 5;
			}
		} else {
			y+=v * delta / 1000;
			v+=5;
			if (y > GameContainer.height - size) {
				y = GameContainer.height - size;
			}
		}
	}
	
	public void render(Graphics2D g) {
		g.drawImage(image, (int)x, (int)y, null);
			
	}
	
	public double find() {
		return ((y + size - 1) - (p.y)) / 5;
	}

}