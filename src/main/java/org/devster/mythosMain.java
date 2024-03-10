package org.devster;

import java.awt.event.KeyEvent;

public class mythosMain implements Runnable {

	private Thread thread;
	private mythosWindow window;
	private mythosRenderer renderer;
	private mythosInput inputHandler;
	private final double UPDATE_CAP = 1.0/60.0;
	private boolean running = false;
	boolean render = false;
	private int width = 360, height = 240;
	private float scale = 3F;

	private String title = "MythosEngine v1.0";

	public mythosMain() {

	}

	public void engineStart() {
		window = new mythosWindow(this);
		inputHandler = new mythosInput(this);
		renderer = new mythosRenderer(this);
		thread = new Thread(this);
		thread.run();
	}

	public void engineStop() {

	}

	public void run() {
		running = true;
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;

		double frameTime = 0;
		int frames = 0;
		int fps = 0;

		while(running) {
			render = false;

			firstTime = System.nanoTime() / 1000000000.0; // Get Current Time
			passedTime = firstTime - lastTime; // Check How long has it been
			lastTime = firstTime; // Keep Looping it

			unprocessedTime += passedTime;
			frameTime += passedTime;
			while (unprocessedTime >= UPDATE_CAP) {
				unprocessedTime -= UPDATE_CAP;
				render = true;
				if(frameTime >= 1.0) {
					frameTime = 0;
					fps = frames;
					frames = 0;
					System.out.println("FPS: " + fps);
				}
				//TODO: update game.
				System.out.println("X: " + inputHandler.getMouseX() + "Y: "+ inputHandler.getMouseY());
			}

			if(render) {
				//TODO: Render Game.
				window.update();
				renderer.clear();
				frames++;

			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		dispose();
	}

	public void dispose() {

	}

	public mythosWindow getWindow() {
		return window;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public static void main(String[] args) {
		mythosMain mainengine = new mythosMain();
		mainengine.engineStart();
	}
}