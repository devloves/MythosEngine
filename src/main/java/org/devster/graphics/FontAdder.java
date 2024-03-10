package org.devster.graphics;

import java.awt.*;

/**
 * The type Font adder.
 */
public class FontAdder {

	/**
	 * The constant STANDARD.
	 */
	public static final FontAdder STANDARD = new FontAdder("/font.png");

	private ImageSprite fontImage;
	private int[] offsets;
	private int[] widths;

	/**
	 * Instantiates a new Font adder.
	 *
	 * @param path the path
	 */
	public FontAdder(String path) {
		fontImage = new ImageSprite(path);
		offsets = new int[59];
		widths = new int[59];

		int unicode = 0;

		for(int i = 0; i < fontImage.getW(); i++) {
			if(fontImage.getP()[i] == 0xff0000ff) {
				offsets[unicode] = i;
			}

			if(fontImage.getP()[i] == 0xffffff00) {
				widths[unicode] = i - offsets[unicode];
				unicode++;
			}
		}
	}

	/**
	 * Gets font image.
	 *
	 * @return the font image
	 */
	public ImageSprite getFontImage() {
		return fontImage;
	}

	/**
	 * Sets font image.
	 *
	 * @param fontImage the font image
	 */
	public void setFontImage(ImageSprite fontImage) {
		this.fontImage = fontImage;
	}

	/**
	 * Get offsets int [ ].
	 *
	 * @return the int [ ]
	 */
	public int[] getOffsets() {
		return offsets;
	}

	/**
	 * Sets offsets.
	 *
	 * @param offsets the offsets
	 */
	public void setOffsets(int[] offsets) {
		this.offsets = offsets;
	}

	/**
	 * Get widths int [ ].
	 *
	 * @return the int [ ]
	 */
	public int[] getWidths() {
		return widths;
	}

	/**
	 * Sets widths.
	 *
	 * @param widths the widths
	 */
	public void setWidths(int[] widths) {
		this.widths = widths;
	}
}
