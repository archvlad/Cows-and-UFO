import java.awt.image.*;
import java.awt.*;

import java.awt.event.KeyEvent;

public class Player extends GameObject {

	BufferedImage light;
	
	public double vX = 0;
	public double vY = 0;
	
	public boolean up, down, right, left, rightDrag, leftDrag = false;
	
	public Player(BufferedImage image) {
		this.image = image;
		light = ImageLoader.getImageLoader().load("light.png");
	}
	
	public void input() {
		right = false;
		left = false;
		up = false;
		down = false;
		leftDrag = false;
		rightDrag = false;
		if (KeyInput.key[KeyEvent.VK_D]) {
			right = true;
		} 
		if (KeyInput.key[KeyEvent.VK_A]) {
			left = true;
		} 
		if (KeyInput.key[KeyEvent.VK_W]) {
			up = true;
		} 
		if (KeyInput.key[KeyEvent.VK_S]) {
			down = true;
		} 
		if (KeyInput.key[KeyEvent.VK_Q]) {
			leftDrag = true;
		} 
		if (KeyInput.key[KeyEvent.VK_E]) {
			rightDrag = true;
		} 
	}
	double a = 6;
	public void tick(double delta) {
		input();
		if (vX != 0) {
			if (vX > 0) {
				vX-=a;
				if (vX < 0) {
				vX = 0;
			}
			}
			if (vX < 0) {
				vX+=a;
				if (vX > 0) {
				vX = 0;
				}
			}
		}
		if (vY != 0) {
			if (vY > 0) {
				vY-=a;
				if (vY < 0) {
				vY = 0;
				}
			}
			if (vY < 0) {
				vY+=a;
				if (vY > 0) {
				vY = 0;
				}
			}
		}
		if (right) {
			vX = 100;
		} else if (left) {
			vX = -100;
		}
		if (up) {
			vY = -100;
		} else if (down) {
			vY = 100;
		}
		x += vX * delta / 1000;
		y += vY * delta / 1000;
		if (x < 0) {
			x = 0;
		}
		if (x > GameContainer.width - size) {
			x = GameContainer.width - size;
		}
		if (y < 0) {
			y = 0;
		}
		if (y > GameContainer.height - 130) {
			y = GameContainer.height - 130;
		}
	}
	
	public void render(Graphics2D g) {
		g.drawImage(light, (int)x, (int)y, null);
		g.drawImage(image, (int)x, (int)y, null);
	}

}