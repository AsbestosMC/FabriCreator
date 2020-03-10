package io.github.asbestosmc.fabricreator;

import io.github.asbestosmc.fabricreator.gui.selection.ProjectSelectionPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.io.File;

public class FabriCreator {
	public static void main(String[] args) throws InterruptedException {
		if (!(args.length == 1 && args[0].equals("iknowwhatamdoingiswear"))) {
			Thread.sleep(100_000); // slow down startup
		}
		JFrame projectSelection = new JFrame("Project Selection");
		projectSelection.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		projectSelection.getContentPane().add(new ProjectSelectionPanel(f -> {
			projectSelection.dispose();
			initProject(f);
		}
		));
		projectSelection.pack();
		projectSelection.setVisible(true);
	}

	public static void initProject(File file) {

	}
}
