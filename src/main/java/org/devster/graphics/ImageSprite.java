package org.devster.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The type Image sprite.
 */
public class ImageSprite {
	private int w, h;
	private int[] p;

	/**
	 * Instantiates a new Image sprite.
	 *
	 * @param path the path
	 */
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

	/**
	 * Gets w.
	 *
	 * @return the w
	 */
	public int getW() {
		return w;
	}

	/**
	 * Sets w.
	 *
	 * @param w the w
	 */
	public void setW(int w) {
		this.w = w;
	}

	/**
	 * Gets h.
	 *
	 * @return the h
	 */
	public int getH() {
		return h;
	}

	/**
	 * Sets h.
	 *
	 * @param h the h
	 */
	public void setH(int h) {
		this.h = h;
	}

	/**
	 * Get p int [ ].
	 *
	 * @return the int [ ]
	 */
	public int[] getP() {
		return p;
	}

	/**
	 * Sets p.
	 *
	 * @param p the p
	 */
	public void setP(int[] p) {
		this.p = p;
	}
}
