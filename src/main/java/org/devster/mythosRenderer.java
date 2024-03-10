package org.devster;

import org.devster.graphics.FontAdder;
import org.devster.graphics.ImageSprite;
import org.devster.graphics.ImageTile;

import java.awt.*;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class mythosRenderer {
	private int pW, pH; // Stands for Pixel Width and Pixel Height
	private int[] p;
	private FontAdder font = FontAdder.STANDARD;

	public mythosRenderer(mythosMain em) {
		pW = em.getWidth();
		pH = em.getHeight();
		p = ((DataBufferInt)em.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}

	public void setPixel(int x, int y, int value) {
		if(x < 0 || x >= pW || y < 0 || y >= pH || value == 0xffff00ff) {
			return;
		}

		p[x + y * pW] = value;
	}

	public void drawImage(ImageSprite image, int offX, int offY) {
		// Don't Render Code
		if(offX < -image.getW()) return;
		if(offY < -image.getH()) return;
		if(offX >= pW) return;
		if(offY >= pH) return;

		// Declaring Variables.
		int newX = 0;
		int newY = 0;
		int newWidth = image.getW();
		int newHeight = image.getH();

		// Clipping Code
		if(newWidth + offX > pW) {newWidth -= newWidth + offX - pW;}
		if(newHeight + offY > pH) {newHeight -= newHeight + offY - pH;}
		if(offX < 0) {newX -= offX;}
		if(offY < 0) {newY -= offY;}

		for(int y = newY; y < newHeight; y++)
		{
			for(int x = newX; x < newWidth; x++){
				setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
			}
		}
	}

	public void drawText(String text, int offX, int offY, int color) {
		ImageSprite fontImage = font.getFontImage();
		text = text.toUpperCase(); // Change if your font is Lowercase
		int offSet = 0;
		for(int i = 0;  i < text.length(); i++) {
			int unicode = text.codePointAt(i) - 32;
			for(int y = 0; y < fontImage.getH();  y++) {
				for(int x = 0; x < font.getWidths()[unicode]; x++) {
					if(font.getFontImage().getP()[x + font.getOffsets()[unicode] + y * font.getFontImage().getW()] == 0xffffffff) {
						setPixel(x + offX + offSet, y + offY, color);
					}
				}
			}
			offSet += font.getWidths()[unicode];
		}

	}

	public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY) {
		// Don't Render Code
		if(offX < -image.getTileW()) return;
		if(offY < -image.getTileH()) return;
		if(offX >= pW) return;
		if(offY >= pH) return;

		// Declaring Variables.
		int newX = 0;
		int newY = 0;
		int newWidth = image.getTileW();
		int newHeight = image.getTileH();

		// Clipping Code
		if(offX < 0) {newX -= offX;}
		if(offY < 0) {newY -= offY;}
		if(newWidth + offX > pW) {newWidth -= newWidth + offX - pW;}
		if(newHeight + offY > pH) {newHeight -= newHeight + offY - pH;}

		for(int y = newY; y < newHeight; y++)
		{
			for(int x = newX; x < newWidth; x++){
				setPixel(x + offX, y + offY, image.getP()[(x + tileX * image.getTileW()) + (y + tileY * image.getTileH()) * image.getW()]);
			}
		}
	}

	public void clear() {
		Arrays.fill(p, 0);
	}

}
