package io.github.asbestosmc.fabricreator;

import io.github.asbestosmc.fabricreator.gui.selection.ProjectCreationPanel;
import io.github.asbestosmc.fabricreator.gui.selection.ProjectSelectionPanel;
import io.github.asbestosmc.fabricreator.metadata.ProjectMeta;
import org.inventivetalent.nbt.CompoundTag;
import org.inventivetalent.nbt.annotation.AnnotatedNBTHandler;
import org.inventivetalent.nbt.stream.NBTInputStream;
import org.inventivetalent.nbt.stream.NBTOutputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FabriCreator {
	public static final ProjectMeta PROJECT_METADATA;
	public static final File METADATA_FILE;

	static {
		JFrame projectSelection = new JFrame("Project Selection");
		projectSelection.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		ProjectMeta[] meta = {null};
		File[] files = {null};
		boolean[] lock = {false};
		projectSelection.getContentPane().add(new ProjectSelectionPanel(f -> {
			projectSelection.dispose();
			File setting = new File(f, "fabricreator_metadata.nbt");
			meta[0] = initProject(setting);
			lock[0] = true;
			files[0] = setting;
		}
		));
		projectSelection.pack();
		projectSelection.setVisible(true);

		while (!lock[0]) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException ignored) {}
		}

		PROJECT_METADATA = meta[0];
		METADATA_FILE = files[0];
	}

	public static void main(String[] args) throws InterruptedException {

	}

	public static ProjectMeta initProject(File setting) {
		if (setting.exists()) {
			try (NBTInputStream input = new NBTInputStream(new FileInputStream(setting))) {
				ProjectMeta meta = new ProjectMeta();
				AnnotatedNBTHandler nbtHandler = new AnnotatedNBTHandler(meta);
				nbtHandler.onRead((CompoundTag) input.readNBTTag());
				return meta;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No.");
				throw new RuntimeException(e);
			}
		} else {
			try {
				return createMeta(setting);
			} catch (InterruptedException ignored) {}
		}
		throw new IllegalStateException("bruh");
	}

	public static ProjectMeta createMeta(File setting) throws InterruptedException {
		JFrame selection = new JFrame("Project Selection");
		selection.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ProjectMeta[] meta = new ProjectMeta[1];
		boolean[] bool = new boolean[1];
		selection.getContentPane().add(new ProjectCreationPanel(m -> {
			selection.dispose();
			bool[0] = true;
			meta[0] = m;
			m.save(setting);
		}
		));
		selection.pack();
		selection.setVisible(true);
		while (!bool[0]) {
			Thread.sleep(500); // wait for
		}

		if (meta[0] == null) {
			JOptionPane.showMessageDialog(null, "Invalid Project Metadata");
			System.exit(0); // yeet
		}
		return meta[0];
	}

}
