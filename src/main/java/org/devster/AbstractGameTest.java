package org.devster;

/**
 * The type Abstract game test.
 */
public abstract class AbstractGameTest {
	/**
	 * Update.
	 *
	 * @param mm the mm
	 * @param dt the dt
	 */
	public abstract void update(mythosMain mm, float dt);

	/**
	 * Render.
	 *
	 * @param mm the mm
	 * @param r  the r
	 */
	public abstract void render(mythosMain mm, mythosRenderer r);
}
