package org.devster.graphics;

import org.devster.Game.GameManager;
import org.devster.mythosMain;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class Tilemap {
	private final HashMap<Integer, ImageSprite> tileTextures;

	public Tilemap() {
		tileTextures = new HashMap<>();
	}

	public void addTileTexture(int tileId, ImageSprite texture) {
		tileTextures.put(tileId, texture);
	}

	public ImageSprite getTileTexture(int tileId) {
		return tileTextures.get(tileId);
	}



}
