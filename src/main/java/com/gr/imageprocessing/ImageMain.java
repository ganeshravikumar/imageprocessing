package com.gr.imageprocessing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class ImageMain {
    public static void main(String args[]) throws IOException {
        BufferedImage noiseImg = null;
        BufferedImage noiseImgC = null;
        noiseImg = ImageIO.read(new File("/Users/ganeshravikumar/Downloads/DAckathon-Image_Enrichment-Dataset/Noise/noise-fix_replace_with_plus_one_2.jpg"));
        Raster a = noiseImg.getData();
        int count=0;
        int w = noiseImg.getWidth();
        int h = noiseImg.getHeight();
        for (int i = 2; i < w-2; i++) {
            for (int j = 2; j < h-2; j++) {
                System.out.println("x,y: " + i + ", " + j);
                int pixel = noiseImg.getRGB(i, j);
               // if(noiseImg.getRGB(i+2, j+2)==noiseImg.getRGB(i+1, j+1)){
                if(noiseImg.getRGB(i, j)!=noiseImg.getRGB(i+1, j+1)){
                   //  if(noiseImg.getRGB(i-2, j-2)==noiseImg.getRGB(i-1, j-1)){
                            if(noiseImg.getRGB(i, j)!=noiseImg.getRGB(i-1, j-1)) {
                                System.out.println("not equal"+i+"--"+j);
                                count=count+1;
                                noiseImg.setRGB(i,j,noiseImg.getRGB(i+2, j+2));
                            }

                    }

               // }}
                printPixelARGB(pixel);

            }
        }
        ImageIO.write(noiseImg, "PNG", new File("/Users/ganeshravikumar/Downloads/DAckathon-Image_Enrichment-Dataset/Noise/noise-fix_replace_with_plus_one_3.jpg"));
        System.out.println(noiseImg.getData()+ "--"+count);
    }

    public static void printPixelARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
    }
}