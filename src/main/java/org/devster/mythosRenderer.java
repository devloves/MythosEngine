package org.devster;

import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class mythosRenderer {
	private int pW, pH; // Stands for Pixel Width and Pixel Height
	private int[] p;

	public mythosRenderer(mythosMain em) {
		pW = em.getWidth();
		pH = em.getHeight();
		p = ((DataBufferInt)em.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}

	public void clear() {
		Arrays.fill(p, 0);
	}

}
