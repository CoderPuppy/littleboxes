package cpup.littleBoxes.gui;

import cpup.littleBoxes.Box;
import cpup.littleBoxes.BoxPos;
import cpup.littleBoxes.Game;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JPanel {
	protected final Game game;
	protected final Box[][] boxes;

	public GameGUI(Game _game) {
		game = _game;
		boxes = game.getBoxes();
		setLayout(new GridLayout(boxes.length, boxes.length));
		for(int x = 0; x < boxes.length; x++) {
			for(int y = 0; y < boxes.length; y++) {
				final Box box = boxes[x][y];
				add(new BoxGUI(box));
			}
		}
	}

	// Getters and Setters
	public Game getGame() {
		return game;
	}
}
