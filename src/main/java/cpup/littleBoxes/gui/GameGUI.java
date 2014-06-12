package cpup.littleBoxes.gui;

import cpup.littleBoxes.Box;
import cpup.littleBoxes.Game;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JComponent {
	protected final Game game;

	protected final Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);

	public GameGUI(Game _game) {
		game = _game;
		setFont(font);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		final FontMetrics fontMetrics = getFontMetrics(font);
		final int charWidth = fontMetrics.getWidths()[0];
		final int charHeight = fontMetrics.getHeight();
		final int boxSize = Math.max(charWidth, charHeight) * 4 + 4;

		g.setFont(font);
		final Box[][] boxes = game.getBoxes();
		for(int x = 0; x < boxes.length; x++) {
			for(int y = 0; y < boxes.length; y++) {
				final Box box = boxes[x][y];
				g.drawRoundRect(
					x * (boxSize + 2) + 10,
					y * (boxSize + 2) + 10,
					boxSize,
					boxSize,
					boxSize / 8,
					boxSize / 8
				);
				g.drawString(
					Integer.toString(box.getValue()),
					x * (boxSize + 2) + (boxSize - charWidth) / 2 + 1 + 10,
					y * (boxSize + 2) + (boxSize - charHeight) / 2 + 2 + 20
				);
			}
		}
	}

	// Getters and Setters
	public Game getGame() {
		return game;
	}
}
