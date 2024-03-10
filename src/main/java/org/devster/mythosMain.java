package org.devster;

import java.lang.System;
/**
 * The main class for the MythosEngine.
 */
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
	private AbstractGameTest game;

	private String title = "MythosEngine v1.0";

	/**
	 * Constructs the MythosEngine with a specific game.
	 *
	 * @param game The game to run using this engine.
	 */
	public mythosMain(AbstractGameTest game) {
		this.game = game;
	}

	/**
	 *  Starts the engine.
	 */
	public void engineStart() {
		window = new mythosWindow(this); // Window for rendering
		inputHandler = new mythosInput(this); // Input Handler for window.
		renderer = new mythosRenderer(this); // Renderer for engine window.
		thread = new Thread(this); // Thread initialization
		thread.run();
	}

	/**
	 * Stops the engine.
	 */
	public void engineStop() {

	}

	/**
	 * Code runs the Engine's main loop.
	 */
	public void run() {
		running = true; // Running status boolean
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
				}
				//TODO: update game.
				game.update(this, (float)UPDATE_CAP);
			}

			if(render) {
				//TODO: Render Game.
				window.update();
				renderer.clear();
				renderer.drawText("FPS: " + fps, 0, 0, 0xff00ffff);
				game.render(this, renderer);
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

	/**
	 * Disposes resources used by the engine.
	 */
	public void dispose() {

	}

	/**
	 * Gets the window associated with the engine.
	 *
	 * @return The Window
	 */
	public mythosWindow getWindow() {
		return window;
	}

	/**
	 * Gets the width of the window.
	 *
	 * @return The Width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of the window.
	 *
	 * @param width The new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}


	/**
	 * Gets the height of the window
	 *
	 * @return The height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height of the window
	 *
	 * @param height The new height.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the scale of the window.
	 *
	 * @return The scale.
	 */
	public float getScale() {
		return scale;
	}

	/**
	 * Gets the input handler associated with the engine.
	 *
	 * @return The input handler
	 */
	public mythosInput getInputHandler() {
		return inputHandler;
	}

	/**
	 * Sets the scale of the window.
	 *
	 * @param scale The new scale.
	 */
	public void setScale(float scale) {
		this.scale = scale;
	}
}