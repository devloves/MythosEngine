package org.devster.graphics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TileDataLoader {
	public static List<Integer> loadTileMap(String fileName) throws IOException {
		List<Integer> tileMapData = new ArrayList<>();
		InputStream is = TileDataLoader.class.getClassLoader().getResourceAsStream(fileName);
		if (is == null) {
			throw new IllegalArgumentException("File not found! " + fileName);
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		String line;
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(","); // Split by comma instead of space
			for (String part : parts) {
				int tileId = Integer.parseInt(part.trim()); // Trim to remove any leading/trailing spaces
				tileMapData.add(tileId);
			}
		}

		reader.close();
		return tileMapData;
	}
}
