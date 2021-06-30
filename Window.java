import javax.swing.JFrame;

import java.awt.*;

class Window {
	
	public JFrame frame;
	public Canvas canvas;
	
	public void create(int w, int h, int s, String t) {
		canvas = new Canvas();
		canvas.setSize(w * s, h * s);
		frame = new JFrame();
		frame.add(canvas);
		frame.pack();
		frame.setTitle(t);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}