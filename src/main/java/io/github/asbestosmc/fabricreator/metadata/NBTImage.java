package io.github.asbestosmc.fabricreator.metadata;

import org.inventivetalent.nbt.annotation.NBT;
import java.awt.image.BufferedImage;

/**
 * a cursed image format powered by nbt
 */
public class NBTImage {
	@NBT("width") private int width;
	@NBT("red") private byte[] red;
	@NBT("green") private byte[] green;
	@NBT("blue") private byte[] blue;
	@NBT("alpha") private byte[] alpha;

	public static NBTImage convert(BufferedImage image) {
		NBTImage texture = new NBTImage();
		texture.width = image.getWidth();
		int size = image.getWidth() * image.getHeight();
		texture.red = new byte[size];
		texture.blue = new byte[size];
		texture.green = new byte[size];
		texture.alpha = new byte[size];
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				int rgb = image.getRGB(x, y);
				int index = x * y;
				texture.alpha[index] = (byte) (rgb >> 24);
				texture.red[index] = (byte) (rgb >> 16);
				texture.green[index] = (byte) (rgb >> 8);
				texture.blue[index] = (byte) rgb;
			}
		}

		return texture;
	}

	public static BufferedImage from(NBTImage texture) {
		BufferedImage image = new BufferedImage(texture.width, texture.alpha.length / texture.width,
		                                        BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				int index = x * y;
				int rgb = texture.blue[index] & 0xFF;
				rgb |= (texture.green[index] & 0xFF) << 8;
				rgb |= (texture.red[index] & 0xFF) << 16;
				rgb |= (texture.alpha[index] & 0xFF) << 24;
				image.setRGB(x, y, rgb);
			}
		}

		return image;
	}
}
