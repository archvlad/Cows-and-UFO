import java.awt.image.*;
import java.awt.*;

public abstract class GameObject {

	BufferedImage image;
	public double x = 0;
	public double y = 0;
	public int size = 32;
	
	public abstract void tick(double delta);
	
	public abstract void render(Graphics2D g);

}