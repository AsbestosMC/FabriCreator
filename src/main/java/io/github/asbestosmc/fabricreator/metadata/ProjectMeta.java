package io.github.asbestosmc.fabricreator.metadata;

import org.inventivetalent.nbt.CompoundTag;
import org.inventivetalent.nbt.annotation.AnnotatedNBTHandler;
import org.inventivetalent.nbt.annotation.NBT;
import org.inventivetalent.nbt.stream.NBTOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class ProjectMeta {
	@NBT ("namespace")
	private final String namespace;
	@NBT("side")
	private final String side;
	@NBT("modname")
	private final String modName;
	@NBT("modid")
	private final String modId;

	public ProjectMeta(String namespace, String side, String modName, String modId) {
		this.namespace = namespace;
		this.side = side;
		this.modName = modName;
		this.modId = modId;
	}

	public ProjectMeta() {
		this(null, null, null, null);
	}

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

	public final void save(File file) {
		try (NBTOutputStream out = new NBTOutputStream(new FileOutputStream(file))) {
			CompoundTag tag = new CompoundTag();
			AnnotatedNBTHandler handler = new AnnotatedNBTHandler(this);
			handler.onWrite(tag);
			out.writeTag(tag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
