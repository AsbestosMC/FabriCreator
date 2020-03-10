package io.github.asbestosmc.fabricreator.metadata;

import org.inventivetalent.nbt.annotation.NBT;

public class ProjectMeta {
	@NBT("namespace")
	private String namespace;
	@NBT("side")
	private String side;
	@NBT("modname")
	private String modName;
	@NBT("modid")
	private String modId;

	public String getNamespace() {
		return this.namespace;
	}

	public String getSide() {
		return this.side;
	}

	public String getModName() {
		return this.modName;
	}

	public String getModId() {
		return this.modId;
	}
}
