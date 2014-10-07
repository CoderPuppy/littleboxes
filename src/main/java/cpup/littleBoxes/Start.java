package cpup.littleBoxes;

import cpup.littleBoxes.gui.GameGUI;
import cpup.littleBoxes.gui.MainWindow;

import java.util.Set;

public class Start {
	public static void main(String[] args) {
		final MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		final Game game = new Game(new Box[][] {
			{ new Box(1), new Box(2), new Box(3), new Box(4) },
			{ new Box(4), new Box(3), new Box(2), new Box(1) },
			{ new Box(2), new Box(4), new Box(1), new Box(3) },
			{ new Box(3), new Box(1), new Box(4), new Box(2) }
//			{ new Box(1), new Box(2), new Box(3), new Box(4), new Box(5), new Box(6), new Box(7), new Box(8), new Box(9) },
//			{ new Box(4), new Box(5), new Box(6), new Box(7), new Box(8), new Box(9), new Box(1), new Box(2), new Box(3) },
//			{ new Box(7), new Box(8), new Box(9), new Box(1), new Box(2), new Box(3), new Box(4), new Box(5), new Box(6) },
//			{ new Box(2), new Box(3), new Box(4), new Box(5), new Box(6), new Box(7), new Box(8), new Box(9), new Box(1) },
//			{ new Box(3), new Box(4), new Box(5), new Box(6), new Box(7), new Box(8), new Box(9), new Box(1), new Box(2) },
//			{ new Box(9), new Box(9), new Box(7), new Box(2), new Box(4), new Box(5), new Box(3), new Box(6), new Box(8) },
//			{ new Box(8), new Box(1), new Box(2), new Box(3), new Box(9), new Box(4), new Box(6), new Box(7), new Box(5) }
		});
		final Set<Integer> littleBoxes = game.getRawBoxes()[0][0].getLittleBoxes();
		littleBoxes.add(1);
		littleBoxes.add(2);
		littleBoxes.add(3);
		littleBoxes.add(4);
		mainWindow.getContentPane().add(new GameGUI(game));
	}
}