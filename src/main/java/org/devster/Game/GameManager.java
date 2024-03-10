package org.devster.Game;

import org.devster.AbstractGameTest;
import org.devster.graphics.ImageSprite;
import org.devster.graphics.ImageTile;
import org.devster.mythosMain;
import org.devster.mythosRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameManager extends AbstractGameTest {

	private ImageTile sprite;

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

	float temp;

	@Override
	public void render(mythosMain mm, mythosRenderer r) {
		r.drawImageTile(sprite, mm.getInputHandler().getMouseX() - 8, mm.getInputHandler().getMouseY() - 16, (int)temp, 0);
	}

	public static void main(String[] args) {
		mythosMain mm = new mythosMain(new GameManager());
		mm.engineStart();
	}
}
