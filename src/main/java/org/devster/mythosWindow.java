package org.devster;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class mythosWindow {

	private JFrame frame;
	private BufferedImage image;
	private Canvas canvas;
	private Graphics g;
	private BufferStrategy bs;

	public mythosWindow(mythosMain em) {
		image = new BufferedImage(em.getWidth(), em.getHeight(), BufferedImage.TYPE_INT_RGB);
		canvas = new Canvas();
		Dimension canvasSize = new Dimension((int) (em.getWidth() * em.getScale()), (int) ((em.getHeight() * em.getScale())));
		canvas.setMaximumSize(canvasSize);
		canvas.setMaximumSize(canvasSize);
		canvas.setFocusable(true);

		frame = new JFrame("Mythos Engine v1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.setPreferredSize(canvasSize);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		canvas.createBufferStrategy(2);
		bs = canvas.getBufferStrategy();
		g = bs.getDrawGraphics();
	}

	public void update() {
		g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		bs.show();
	}

	public BufferedImage getImage() {
		return image;
	}

	public JFrame getFrame() {
		return frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}
}
