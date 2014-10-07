package cpup.littleBoxes.gui;

import cpup.littleBoxes.*;
import cpup.littleBoxes.Box;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JPanel {
	protected final Game game;
	protected final Box[][] boxes;

	public GameGUI(Game _game) {
		game = _game;
		boxes = game.getRawBoxes();
//		setLayout(new GridLayout(boxes.length, boxes.length));
		setLayout(new Layout(boxes.length));
		for(int x = 0; x < boxes.length; x++) {
			for(int y = 0; y < boxes.length; y++) {
				add(new BoxGUI(new BoxPos(game, x, y)));
			}
		}
		for(BigBox[] boxe : game.getBigBoxes()) {
			for(BigBox box : boxe) {
				add(new PartGUI(box, 3));
			}
		}
//		for(Column column : game.getColumns()) {
//			add(new PartGUI(column, 0));
//		}
//		for(Row row : game.getRows()) {
//			add(new PartGUI(row, 0));
//		}
	}

	class Layout implements LayoutManager {
		protected final int numBoxes;

		Layout(int _numBoxes) {
			numBoxes = _numBoxes;
		}

		@Override
		public void addLayoutComponent(String s, Component component) {}

		@Override
		public void removeLayoutComponent(Component component) {}

		@Override
		public Dimension preferredLayoutSize(Container container) {
			return null;
		}

		@Override
		public Dimension minimumLayoutSize(Container container) {
			return null;
		}

		@Override
		public void layoutContainer(Container container) {
			final int offsetX = 0;
			final int offsetY = 0;
			final int boxWidth = (container.getWidth() - offsetX * 2) / numBoxes;
			final int boxHeight = (container.getHeight() - offsetY * 2) / numBoxes;
			for(Component comp : container.getComponents()) {
				if(comp instanceof IPartContainer) {
					Part part = ((IPartContainer) comp).getPart();
					comp.setBounds(
						boxWidth * part.getX() + offsetX,
						boxHeight * part.getY() + offsetY,
						boxWidth * part.getWidth(),
						boxHeight * part.getHeight()
					);
				} else {
					comp.setVisible(false);
				}
			}
		}
	}

	// Getters and Setters
	public Game getGame() {
		return game;
	}
}
