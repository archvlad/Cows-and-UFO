import java.awt.image.*;
import java.awt.*;

public class GameManager {
	
	Player p;
	Cow c;
	Background b;
	SpriteSheet ss;
	BufferedImage backObj;
	BufferedImage spot;
	Tele tele;
	
	public GameManager() {
		ss = new SpriteSheet(ImageLoader.getImageLoader().load("sprite_sheet.png"));
		p = new Player(ss.getSprite(0, 0, 32));
		c = new Cow(ss.getSprite(1, 0, 32), p);
		b = new Background();
		backObj = ImageLoader.getImageLoader().load("back2.png");
		spot = ImageLoader.getImageLoader().load("light_spot.png");
		tele = new Tele();
	}
	
	public void tick(double delta) {
		p.tick(delta);
		c.tick(delta);
	}
	
	public void render(Graphics2D g) {
		b.render(g);
		g.drawImage(spot, (int)p.x, (int)p.y, null);
		g.drawImage(backObj, 0, 0, null);
		c.render(g);
		p.render(g);
		tele.render(g);
	}
	
	public static void main(String[] args) {
		GameManager gm = new GameManager();
		GameContainer game = new GameContainer();
		game.init(gm);
		game.start();
	}
	
}