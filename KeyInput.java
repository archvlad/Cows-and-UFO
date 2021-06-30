import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	public static boolean[] key = new boolean[256]; 
	
	public void keyPressed(KeyEvent e) {
		key[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e) {
		key[e.getKeyCode()] = false;
	}

}