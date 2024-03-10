package org.devster.Game;

import org.devster.AbstractGameTest;
import org.devster.graphics.ImageSprite;
import org.devster.graphics.ImageTile;
import org.devster.mythosMain;
import org.devster.mythosRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * The type Game manager.
 */
public class GameManager extends AbstractGameTest {

	private ImageTile sprite;

	/**
	 * Instantiates a new Game manager.
	 */
	public GameManager() {
		this.sprite = new ImageTile("/testtile.png", 16, 16);
	}

	@Override
	public void update(mythosMain mm, float dt) {
		if(mm.getInputHandler().isKeyDown(KeyEvent.VK_A)) {
			System.out.println("yeeaaa");
		}
		temp += dt * 20;
		if(temp > 4) {
			temp = 0;
		}
	}

	/**
	 * The Temp.
	 */
	float temp;

	@Override
	public void render(mythosMain mm, mythosRenderer r) {
		r.drawImageTile(sprite, mm.getInputHandler().getMouseX() - 8, mm.getInputHandler().getMouseY() - 16, (int)temp, 0);
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
