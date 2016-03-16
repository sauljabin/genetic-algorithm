/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public abstract class HelperImage {

	/**
	 * Lee una imagen desde el disco
	 * 
	 * @param file
	 *            Archivo a leer
	 * @return Imagen en formato BufferedImage
	 * @throws IOException
	 */
	public static BufferedImage readImage(String path) throws IOException {
		return readImage(new File(path));
	}

	/**
	 * Lee una imagen desde el disco
	 * 
	 * @param file
	 *            Archivo a leer
	 * @return Imagen en formato BufferedImage
	 * @throws IOException
	 */
	public static BufferedImage readImage(File file) throws IOException {
		return ImageIO.read(file);
	}

	/**
	 * Escribir imagen en disco
	 * 
	 * @param image
	 *            Imagen a escribir
	 * @param path
	 *            Ruta a gurdar
	 * @return Verdadero si fue escrita satisfactoriamente
	 * @throws IOException
	 */
	public static boolean writeImage(BufferedImage image, String path)
			throws IOException {
		return writeImage(image, new File(path));
	}

	/**
	 * Escribir imagen en disco
	 * 
	 * @param image
	 *            Imagen a escribir
	 * @param file
	 *            Archivo a guardar
	 * @return Verdadero si fue escrita satisfactoriamente
	 * @throws IOException
	 */
	public static boolean writeImage(BufferedImage image, File file)
			throws IOException {
		String fileName = file.getName();
		String extension = fileName.substring(fileName.lastIndexOf('.') + 1,
				fileName.length());
		return ImageIO.write(image, extension, file);
	}

	/**
	 * Toma una imagen en formato BufferedImage y la transforma en binario
	 * 
	 * @param image
	 *            Imagen a transformar
	 * @param extension
	 *            Extension de la imagen
	 * @return Imagen en formato binario
	 * @throws IOException
	 */
	public static byte[] bufferedImageToByteArray(BufferedImage image,
			String extension) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, extension, baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
	}

	/**
	 * Toma una imagen como arreglo binario y lo transforma en BufferedImage
	 * 
	 * @param image
	 *            Imagen en binario
	 * @return Una imagen tipo BufferedImage
	 * @throws IOException
	 */
	public static BufferedImage byteArrayToBufferedImage(byte[] image)
			throws IOException {
		InputStream in = new ByteArrayInputStream(image);
		return ImageIO.read(in);
	}

	/**
	 * Esta funcion redimensiona una imagen, sin perdida
	 * <p>
	 * Reescala la imagen segun un porcentage
	 * 
	 * @param image
	 *            Imagen a redimensionar
	 * @param percent
	 *            Porcentaje
	 * @return Imagen reescalada
	 */
	public static BufferedImage resizePercent(BufferedImage image, float percent) {
		if (percent > 1) {
			percent = percent / 100;
		}
		int width = (int) (image.getWidth() * percent);
		int height = (int) (image.getHeight() * percent);
		return resize(image, width, height);
	}

	/**
	 * Esta funcion redimensiona una imagen, sin perdida
	 * <p>
	 * Toma un alto maximo y proporciona el ancho de la imagen
	 * 
	 * @param image
	 *            Imagen a redimensionar
	 * @param height
	 *            Ancho de la imagen
	 * @return Imagen reescalada
	 */
	public static BufferedImage resizeMaxHeight(BufferedImage image, int height) {
		int width = (int) (image.getWidth()
				* (height * 100 / image.getHeight()) / 100);
		return resize(image, width, height);
	}

	/**
	 * Esta funcion redimensiona una imagen, sin perdida
	 * <p>
	 * Toma un ancho maximo y proporciona el alto de la imagen
	 * 
	 * @param image
	 *            Imagen a redimensionar
	 * @param width
	 *            Ancho de la imagen
	 * @return Imagen reescalada
	 */
	public static BufferedImage resizeMaxWidth(BufferedImage image, int width) {
		int height = (int) (image.getHeight()
				* (width * 100 / image.getWidth()) / 100);
		return resize(image, width, height);
	}

	/**
	 * Esta funcion redimensiona una imagen, sin perdida
	 * 
	 * @param image
	 *            Imagen a redimensionar
	 * @param width
	 *            Ancho de la imagen
	 * @param height
	 *            Alto de la imagen
	 * @return Imagen reescalada
	 */
	public static BufferedImage resize(BufferedImage image, int width,
			int height) {
		int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image
				.getType();
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);

		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();
		return resizedImage;
	}
}
