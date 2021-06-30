import javax.swing.JFrame;

import java.awt.*;
import java.awt.image.*; 

public class GameContainer {
	
	public static int width = 320;
	public static int height = 240;
	public static int scale = 3;
	public static String title = "Space Adventure";
	
	public Window window;
	public BufferStrategy bs;
	public Graphics2D g;
	
	public GameManager gm; 
	
	public KeyInput ki;
	
	public void start() {
		window.canvas.requestFocus();
		long previous = System.currentTimeMillis();
		long current = 0;
		double elapsed = 0;
		double timePerTick = 1000.0 / 60;
		int ticks = 0;
		int frames = 0;
		long timer = previous;
		while (true) {
			current = System.currentTimeMillis();
			elapsed += (current - previous) / timePerTick;
			previous = current;
			while (elapsed >= 1) {
				tick(timePerTick);
				ticks++;
				elapsed -= 1;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer >= 1000) {
				System.out.printf("UPS: %3d, FPS: %3d%n", ticks, frames);
				timer += 1000;
				ticks = 0;
				frames = 0;
			}
		}
	}
	
	public void tick(double delta) {
		gm.tick(delta);
	}
	
	public void render() {
		bs = window.canvas.getBufferStrategy();
		if (bs == null) {
			window.canvas.createBufferStrategy(3);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
		
		g.scale(scale, scale);
		gm.render(g);
		g.dispose();
		bs.show();
	}
	
	public void init(GameManager gm) {
		window = new Window();
		window.create(width , height, scale, title);
		this.gm = gm;
		ki = new KeyInput();
		window.canvas.addKeyListener(ki);
	}
	
}