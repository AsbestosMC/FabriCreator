package io.github.asbestosmc.fabricreator;

import io.github.asbestosmc.fabricreator.gui.selection.ProjectSelectionPanel;
import org.inventivetalent.nbt.stream.NBTInputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.io.*;

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
		File setting = new File(file, "fabricreator_metadata.nbt");

		try (NBTInputStream input = new NBTInputStream(new FileInputStream(setting))) {

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No.");
			e.printStackTrace();
		}
	}

	public static void createMeta() {

	}
}
