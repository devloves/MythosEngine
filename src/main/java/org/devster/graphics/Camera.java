package org.devster.graphics;

/**
 * The type Camera.
 */
public class Camera {
	private float x, y;

	/**
	 * Instantiates a new Camera.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets x.
	 *
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets x.
	 *
	 * @param x the x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Gets y.
	 *
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets y.
	 *
	 * @param y the y
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Move.
	 *
	 * @param dx the dx
	 * @param dy the dy
	 */
	public void move(float dx, float dy) {
		x += dx;
		y += dy;
	}
}
