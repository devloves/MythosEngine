package org.devster.Game;

import org.devster.AbstractGameTest;
import org.devster.audio.SoundClip;
import org.devster.graphics.*;
import org.devster.mythosMain;
import org.devster.mythosRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

/**
 * The type Game manager.
 */
public class GameManager extends AbstractGameTest {

	private ImageTile sprite;
	private SoundClip shootSound;

	private int spriteX = 0; // Initial position
	private int spriteY = 0; // Initial position

	private Tilemap tilemap = new Tilemap();
	private List<Integer> tilemapData;

	private Camera camera;

	/**
	 * The enum Movement.
	 */
	enum Movement {
		/**
		 * Left movement.
		 */
		LEFT,
		/**
		 * Right movement.
		 */
		RIGHT,
		/**
		 * Up movement.
		 */
		UP,
		/**
		 * Down movement.
		 */
		DOWN
	}

	/**
	 * The Current.
	 */
	Movement current = null;

	/**
	 * Instantiates a new Game manager.
	 */
	public GameManager() {
		this.sprite = new ImageTile("/testplayer.png", 32, 32);
		this.shootSound = new SoundClip("/test.wav");
		this.camera = new Camera(0, 0);
		ImageSprite grassTexture = new ImageSprite("/grass.png");
		ImageSprite stoneTexture = new ImageSprite("/stone.png");
		ImageSprite sandTexture = new ImageSprite("/sand.png");
		tilemap.addTileTexture(0, grassTexture);
		tilemap.addTileTexture(1, stoneTexture);
		tilemap.addTileTexture(2, sandTexture);
		this.current = Movement.UP;
		try {
			this.tilemapData = TileDataLoader.loadTileMap("map.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(mythosMain mm, float dt) {
		float moveSpeed = 5.0f; // Adjust this value to change the camera's movement speed

		if (mm.getInputHandler().isKeyDown(KeyEvent.VK_UP)) {
			camera.move(0, -moveSpeed * dt * 20);
			tempTile = 2;
			this.current = Movement.UP;
		}
		if (mm.getInputHandler().isKeyDown(KeyEvent.VK_DOWN)) {
			camera.move(0, moveSpeed * dt * 20);
			tempTile = 0;
			this.current = Movement.DOWN;
		}
		if (mm.getInputHandler().isKeyDown(KeyEvent.VK_LEFT)) {
			camera.move(-moveSpeed * dt * 20, 0);
			tempTile = 3;
			this.current = Movement.LEFT;
		}
		if (mm.getInputHandler().isKeyDown(KeyEvent.VK_RIGHT)) {
			camera.move(moveSpeed * dt * 20, 0);
			tempTile = 1;
			this.current = Movement.RIGHT;
		}

		temp += dt * 10;
		if(temp > 3) {
			temp = 1;
		}
	}

	/**
	 * The Temp.
	 */
	float temp;
	/**
	 * The Temp tile.
	 */
	int tempTile;

	@Override
	public void render(mythosMain mm, mythosRenderer r) {
		if(mm.getInputHandler().isButton(MouseEvent.BUTTON1)) {
			shootSound.play();
		}
		int cameraX = (int)camera.getX();
		int cameraY = (int)camera.getY();
		r.drawTilemap(tilemap, tilemapData, 32, 32 * 40, cameraX, cameraY);
		r.drawImageTile(sprite, mm.getWidth() / 2, mm.getHeight() / 2, (int)temp, tempTile);
		r.drawText(current.name(), 0, 6, 0xff00ff0f);
	}

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		mythosMain mm = new mythosMain(new GameManager());
		mm.engineStart();
	}
}
