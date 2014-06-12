package cpup.littleBoxes;

import cpup.littleBoxes.gui.GameGUI;
import cpup.littleBoxes.gui.MainWindow;

public class Start {
	public static void main(String[] args) {
		final MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		final Game game = new Game(new Box[][]{
			{ new Box(1), new Box(2), new Box(3), new Box(4) },
			{ new Box(4), new Box(3), new Box(2), new Box(1) },
			{ new Box(2), new Box(4), new Box(1), new Box(3) },
			{ new Box(3), new Box(1), new Box(4), new Box(2) }
		});
		mainWindow.getContentPane().add(new GameGUI(game));
	}
}