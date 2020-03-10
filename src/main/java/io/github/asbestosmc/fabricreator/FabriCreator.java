package io.github.asbestosmc.fabricreator;

import io.github.asbestosmc.fabricreator.gui.selection.ProjectSelectionPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.io.File;

public class FabriCreator {
	private static final JFrame PROJECT_SELECTION = new JFrame("Project Selection");
	public static void main(String[] args) throws InterruptedException {
		if (!(args.length == 1 && args[0].equals("iknowwhatamdoingiswear"))) {
			Thread.sleep(100_000); // slow down startup
		}
		PROJECT_SELECTION.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		PROJECT_SELECTION.getContentPane().add(new ProjectSelectionPanel(FabriCreator::initProject));
		PROJECT_SELECTION.pack();
		PROJECT_SELECTION.setVisible(true);
	}

	public static void initProject(File file) {
		PROJECT_SELECTION.dispose();

	}
}
