package org.devster.graphics;

/**
 * The type Image tile.
 */
public class ImageTile extends ImageSprite {
	private int tileW, tileH;

	/**
	 * Instantiates a new Image tile.
	 *
	 * @param path  the path
	 * @param tileW the tile w
	 * @param tileH the tile h
	 */
	public ImageTile(String path, int tileW, int tileH) {
		super(path);
		this.tileW = tileW;
		this.tileH = tileH;
	}

	/**
	 * Gets tile w.
	 *
	 * @return the tile w
	 */
	public int getTileW() {
		return tileW;
	}

	/**
	 * Sets tile w.
	 *
	 * @param tileW the tile w
	 */
	public void setTileW(int tileW) {
		this.tileW = tileW;
	}

	/**
	 * Gets tile h.
	 *
	 * @return the tile h
	 */
	public int getTileH() {
		return tileH;
	}

	/**
	 * Sets tile h.
	 *
	 * @param tileH the tile h
	 */
	public void setTileH(int tileH) {
		this.tileH = tileH;
	}
}
