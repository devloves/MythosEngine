package org.devster.graphics;

import org.devster.Game.GameManager;
import org.devster.mythosMain;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

/**
 * The type Tilemap.
 */
public class Tilemap {
	private final HashMap<Integer, ImageSprite> tileTextures;

	/**
	 * Instantiates a new Tilemap.
	 */
	public Tilemap() {
		tileTextures = new HashMap<>();
	}

	/**
	 * Add tile texture.
	 *
	 * @param tileId  the tile id
	 * @param texture the texture
	 */
	public void addTileTexture(int tileId, ImageSprite texture) {
		tileTextures.put(tileId, texture);
	}

	/**
	 * Gets tile texture.
	 *
	 * @param tileId the tile id
	 * @return the tile texture
	 */
	public ImageSprite getTileTexture(int tileId) {
		return tileTextures.get(tileId);
	}



}
