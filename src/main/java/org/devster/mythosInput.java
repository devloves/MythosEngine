package org.devster;

import java.awt.event.*;

/**
 * The type Mythos input.
 */
public class mythosInput implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener {

	private final int NUM_KEYS = 256;
	private boolean[] keys = new boolean[NUM_KEYS];
	private boolean[] keysLast = new boolean[NUM_KEYS];

	private final int NUM_BUTTONS = 5;
	private boolean[] buttons = new boolean[NUM_KEYS];
	private boolean[] buttonsLast = new boolean[NUM_KEYS];

	private int mouseX, mouseY;
	private int scroll;
	private mythosMain em;

	/**
	 * Instantiates a new Mythos input.
	 *
	 * @param main the main
	 */
	public mythosInput(mythosMain main) {
		this.em = main;
		mouseX = 0;
		mouseY = 0;
		scroll = 0;

		em.getWindow().getCanvas().addKeyListener(this);
		em.getWindow().getCanvas().addMouseListener(this);
		em.getWindow().getCanvas().addMouseMotionListener(this);
		em.getWindow().getCanvas().addMouseWheelListener(this);
	}

	/**
	 * Update.
	 */
	public void update() {
		for (int i = 0; i < NUM_KEYS; i ++) {
			keysLast[i] = keys[i];
		}
		for (int i = 0; i < NUM_BUTTONS; i ++) {
			buttonsLast[i] = buttons[i];
		}
	}

	/**
	 * Is key boolean.
	 *
	 * @param keyCode the key code
	 * @return the boolean
	 */
	public boolean isKey(int keyCode) {
		return keys[keyCode];
	}

	/**
	 * Is key up boolean.
	 *
	 * @param keyCode the key code
	 * @return the boolean
	 */
	public boolean isKeyUp(int keyCode) {
		return !keys[keyCode] && keysLast[keyCode];
	}

	/**
	 * Is key down boolean.
	 *
	 * @param keyCode the key code
	 * @return the boolean
	 */
	public boolean isKeyDown(int keyCode) {
		return keys[keyCode] && !keysLast[keyCode];
	}

	/**
	 * Is button boolean.
	 *
	 * @param button the button
	 * @return the boolean
	 */
	public boolean isButton(int button) {
		return buttons[button];
	}

	/**
	 * Is button up boolean.
	 *
	 * @param button the button
	 * @return the boolean
	 */
	public boolean isButtonUp(int button) {
		return !buttons[button] && buttonsLast[button];
	}

	/**
	 * Is button down boolean.
	 *
	 * @param button the button
	 * @return the boolean
	 */
	public boolean isButtonDown(int button) {
		return buttons[button] && !buttonsLast[button];
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX =  (int)(e.getX() / em.getScale());
		mouseY =  (int)(e.getY() / em.getScale());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX =  (int)(e.getX() / em.getScale());
		mouseY =  (int)(e.getY() / em.getScale());
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll = e.getWheelRotation();
	}

	/**
	 * Gets num keys.
	 *
	 * @return the num keys
	 */
	public int getNUM_KEYS() {
		return NUM_KEYS;
	}

	/**
	 * Gets mouse x.
	 *
	 * @return the mouse x
	 */
	public int getMouseX() {
		return mouseX;
	}

	/**
	 * Gets mouse y.
	 *
	 * @return the mouse y
	 */
	public int getMouseY() {
		return mouseY;
	}

	/**
	 * Gets scroll.
	 *
	 * @return the scroll
	 */
	public int getScroll() {
		return scroll;
	}
}
