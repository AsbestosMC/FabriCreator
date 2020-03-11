package io.github.asbestosmc.fabricreator.gui.project;

import io.github.asbestosmc.fabricreator.FabriCreator;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainMenuPanel extends JPanel {
	// global variables :tiny_potato:
	public static final JProgressBar PROGRESS_BAR = new JProgressBar();

	public MainMenuPanel() {
		//construct preComponents
		JMenu helpMenu = new JMenu("help");
		JMenuItem discordItem = new JMenuItem("discord");
		discordItem.addActionListener(a -> {
			JOptionPane.showMessageDialog(null, "Soon:tm:"); // todo add discord
		});
		helpMenu.add(discordItem);
		JMenuItem wikiItem = new JMenuItem("wiki");
		wikiItem.addActionListener(a -> redirect("https://github.com/AsbestosMC/FabriCreator/wiki"));
		helpMenu.add(wikiItem);
		JMenuItem githubItem = new JMenuItem("github");
		githubItem.addActionListener(a -> redirect("https://github.com/AsbestosMC/FabriCreator/"));
		helpMenu.add(githubItem);
		JMenu saveMenu = new JMenu("save");
		saveMenu.addActionListener(a -> FabriCreator.PROJECT_METADATA.save(FabriCreator.METADATA_FILE));
		JMenu aboutMenu = new JMenu("about");
		JMenu runMenu = new JMenu("run");
		JMenuItem runServer = new JMenuItem("run server");
		runMenu.add(runServer);
		JMenuItem runClient = new JMenuItem("run client");
		runMenu.add(runClient);
		JMenu exportMenu = new JMenu("export");
		JMenuItem exportAsModJar = new JMenuItem("export as mod jar");
		exportMenu.add(exportAsModJar);
		JMenuItem exportAsDevJar = new JMenuItem("export as dev jar");
		exportMenu.add(exportAsDevJar);
		JMenuItem exportAsFabricProject = new JMenuItem("export as fabric project");
		exportMenu.add(exportAsFabricProject);

		//construct components
		JList<String> jcomp1 = new JList<>(new String[] {}); // replace this with selector panel
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(helpMenu);
		menuBar.add(saveMenu);
		menuBar.add(aboutMenu);
		menuBar.add(runMenu);
		menuBar.add(exportMenu);
		JLabel jcomp3 = new JLabel("newLabel"); // replace this with project tree

		// set size
		this.setPreferredSize(new Dimension(1008, 618));
		BorderLayout layout = new BorderLayout(0, 0);
		this.setLayout(layout);
		//add components
		this.add(jcomp1, BorderLayout.CENTER);
		this.add(menuBar, BorderLayout.NORTH);
		this.add(jcomp3, BorderLayout.WEST);
		this.add(PROGRESS_BAR);
	}

	private static void redirect(String url) {
		if(Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				JOptionPane.showMessageDialog(null, "Error");
			}
		} else
			JOptionPane.showMessageDialog(null, url);
	}
}
