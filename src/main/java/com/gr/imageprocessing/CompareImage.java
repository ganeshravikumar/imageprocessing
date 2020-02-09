package com.gr.imageprocessing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class CompareImage {
    public static void main(String args[]) throws IOException {
        System.out.println("hello");
        BufferedImage noiseImg = null;
        BufferedImage noiseImg2 = null;
        noiseImg = ImageIO.read(new File("/Users/ganeshravikumar/Downloads/DAckathon-Image_Enrichment-Dataset/Noise/noise-4.jpg"));
        noiseImg2 = ImageIO.read(new File("/Users/ganeshravikumar/Downloads/DAckathon-Image_Enrichment-Dataset/Noise/noise-fix.jpg"));
        Raster a = noiseImg.getData();
        //noiseImg.
        int count = 0;
        int i = 2243;
        int j = 37;

        printPixelARGB(noiseImg.getRGB(i, j));
        printPixelARGB(noiseImg2.getRGB(i, j));
        System.out.println(noiseImg.getData() + "--" + count +"--"+noiseImg.getRGB(12, 2243));
    }
    public static void printPixelARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
    }
}