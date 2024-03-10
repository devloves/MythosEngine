package org.devster.audio;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * The type Sound clip.
 */
public class SoundClip {

	private Clip clip;
	private FloatControl gainControl;

	/**
	 * Instantiates a new Sound clip.
	 *
	 * @param path the path
	 */
	public SoundClip(String path) {
		try {
			InputStream audioSrc = getClass().getResourceAsStream(path);
			InputStream bufferdIn = new BufferedInputStream(audioSrc);
			AudioInputStream ais = AudioSystem.getAudioInputStream(bufferdIn);
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(),
					16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);

			gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);

		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Play.
	 */
	public void play() {
		if (clip == null) {return;}

		stop();
		clip.setFramePosition(0);
		while(!clip.isRunning()) {
			clip.start();
		}
	}

	/**
	 * Stop.
	 */
	public void stop() {
		if(clip.isRunning()) {
			clip.stop();
		}
	}

	/**
	 * Close.
	 */
	public void close() {
		stop();
		clip.drain();
		clip.close();
	}

	/**
	 * Loop.
	 */
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		play();
	}

	/**
	 * Sets volume.
	 *
	 * @param value the value
	 */
	public void setVolume(float value) {
		gainControl.setValue(value);
	}

	/**
	 * Is running boolean.
	 *
	 * @return the boolean
	 */
	public boolean isRunning() {
		return clip.isRunning();
	}
}
