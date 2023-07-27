package com.mfrdev.test.comress;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.zip.DeflaterOutputStream;

public class FileCompress {
    public static File fileCompress(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        //Instantiating the FileOutputStream

        FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath());
        //Instantiating the DeflaterOutputStream
        DeflaterOutputStream compresser = new DeflaterOutputStream(outputStream);
        int contents;
        while ((contents = inputStream.read()) != -1) {
            compresser.write(contents);
        }
        compresser.close();
        System.out.println("File compressed.......");
        return file;
    }

    public static File imageCompress(File inputImageFile) throws IOException {
        BufferedImage image = ImageIO.read(inputImageFile);
        File compressedImageFile = new File(inputImageFile.getAbsolutePath());
        OutputStream os = new FileOutputStream(compressedImageFile);
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.05f);  // Change the quality value you prefer
        writer.write(null, new IIOImage(image, null, null), param);
        os.close();
        ios.close();
        writer.dispose();
        return inputImageFile;
    }
}

