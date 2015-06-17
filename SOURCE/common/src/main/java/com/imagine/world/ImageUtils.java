package com.imagine.world;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Directory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by tuanlhd on 5/30/14.
 */
public class ImageUtils {

    /**
     * orientationCode
     * 1: image is Normal-> that’s the orientation value you get when the iphone home button is on the right
     * 2: image is flipped horizontally
     * 3: image is rotated 180° -> that’s the orientation value you get when the iphone home button is on the left
     * 4: image is flipped vertically
     * 5: image is rotated 90° CCW and flipped vertically
     * 6: image is rotated 90° CCW -> that’s the orientation value you get when the iphone home button is upwards
     * 7: image is rotated 90° CW and flipped vertically
     * 8: image is rotated 90° CW -> that’s the orientation value you get when the iphone home button is downwards
     *
     */

    public static boolean processTempImage(File f){
        int orientationCode = -1;
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(f);
            ExifIFD0Directory exifDir = metadata.getDirectory(ExifIFD0Directory.class);
            if (exifDir != null) {
                orientationCode = exifDir.getInt(ExifIFD0Directory.TAG_ORIENTATION); // 274 is the EXIF orientation standard code
                BufferedImage bfImage = null;
                if(orientationCode !=-1 ){
                    bfImage = ImageIO.read(f);
                    bfImage = rotateImage(orientationCode, bfImage);
                }
                if(bfImage != null){
                    ImageIO.write(bfImage, "png", f);
                } else {
                    return false;
                }

            } else // the image has problem with metadata , let it default setting.
                return false;
        } catch (ImageProcessingException e) {
//            log.info("image does not content metadata ".concat(e.getMessage()));
            return false;
        } catch (IOException e) {
//            log.error("image read io exception ".concat(e.getMessage()));
            return false;
        } catch (MetadataException e) {
//            log.info("MetadataException ".concat(e.getMessage()));
            return false;
        }
        return true;

    }

    private static BufferedImage rotateImage(int orientation,BufferedImage imageBf) {
        int degrees = -1;
        if (orientation == 3) degrees = 180;
        else if (orientation == 6) degrees = 90;
        else if (orientation == 8) degrees = -90;

        Image rotatedImage = null;
        if (degrees != -1) {
            rotatedImage = rotate(toImage(imageBf),degrees);
            return toBufferedImage(rotatedImage);
        } else {
            return null;
        }
    }

    private static Image rotate(Image img, double angle)
    {
        double sin = Math.abs(Math.sin(Math.toRadians(angle))),
                cos = Math.abs(Math.cos(Math.toRadians(angle)));

        int w = img.getWidth(null), h = img.getHeight(null);

        int neww = (int) Math.floor(w*cos + h*sin),
                newh = (int) Math.floor(h*cos + w*sin);

        BufferedImage bimg = toBufferedImage(getEmptyImage(neww, newh));
        Graphics2D g = bimg.createGraphics();

        g.translate((neww-w)/2, (newh-h)/2);
        g.rotate(Math.toRadians(angle), w / 2, h / 2);
        g.drawRenderedImage(toBufferedImage(img), null);
        g.dispose();

        return toImage(bimg);
    }

    /**
     * Converts a given Image into a BufferedImage
     *
     * @param img The Image to be converted
     * @return The converted BufferedImage
     */
    private static BufferedImage toBufferedImage(Image img){
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_3BYTE_BGR);
        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        // Return the buffered image
        return bimage;
    }

    /**
     * Creates an empty image with transparency
     *
     * @param width The width of required image
     * @param height The height of required image
     * @return The created image
     */
    private static Image getEmptyImage(int width, int height){
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        return toImage(img);
    }

    /**
     * Converts a given BufferedImage into an Image
     *
     * @param bimage The BufferedImage to be converted
     * @return The converted Image
     */
    private static Image toImage(BufferedImage bimage){
        // Casting is enough to convert from BufferedImage to Image
        Image img = (Image) bimage;
        return img;
    }
}
