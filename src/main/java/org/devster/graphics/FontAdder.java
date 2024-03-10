package org.devster.graphics;

import java.awt.*;

public class FontAdder {

	public static final FontAdder STANDARD = new FontAdder("/font.png");

	private ImageSprite fontImage;
	private int[] offsets;
	private int[] widths;

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

	public ImageSprite getFontImage() {
		return fontImage;
	}

	public void setFontImage(ImageSprite fontImage) {
		this.fontImage = fontImage;
	}

	public int[] getOffsets() {
		return offsets;
	}

	public void setOffsets(int[] offsets) {
		this.offsets = offsets;
	}

	public int[] getWidths() {
		return widths;
	}

	public void setWidths(int[] widths) {
		this.widths = widths;
	}
}
