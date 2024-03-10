package org.devster.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageSprite {
	private int w, h;
	private int[] p;

	public ImageSprite(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		w = image.getWidth();
		h = image.getHeight();
		p = image.getRGB(0,0, w, h, null, 0, w);
		image.flush();
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}
}
