import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Transformacje {

    int height;
    BufferedImage image;
    int width;

    public Transformacje() {
        try {
            //odczyt obrazu z pliku
            File input = new File("obrazek.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            //odczyt pixeli obrazu w dwóch pętlach po kolumnach i wierszach
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    //odczyt składowych koloru RGB
                    Color c = new Color(image.getRGB(j, i));
                    int red = (int) (c.getRed());
                    int green = (int) (c.getGreen());
                    int blue = (int) (c.getBlue());
                    int x, y, z;
                    x = 0;
                    y = 0;
                    z = 0;
                    if (i >= 1900 && i <= 4000 && j >= 2400 && j <= 4000) {
                        x = 10;
                        y = -240;
                        z = 140;
                    }
                    if (i >= 500 && i <= 3000 && j >= 700 && j <= 4500) {
                        x = -255;
                        y = 240;
                        z = -255;
                    }
                    if (i >= 1700 && i <= 3000 && j >= 200 && j <= 2500) {
                        x = -50;
                        y = 220;
                        z = 10;
                    }

                    if (red + x >= 0 && red + x <= 255) red = red + x;
                    else red = red;
                    if (green + y >= 0 && green + y <= 255) green = green + y;
                    else green = green;
                    if (blue + z >= 0 && blue + z <= 255) blue = blue + z;
                    else blue = blue;
                    Color newColor = new Color(red, green, blue);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }
            //koniec dwóch pętli po kolumnach i wierszach obrazu
            //zapis do pliku zmodyfikowanego obrazu
            File ouptut = new File("grayscale.jpg");
            ImageIO.write(image, "jpg", ouptut);
        } catch (Exception e) {

        }
    }

    static public void main(String args[]) throws Exception {
        Transformacje obj = new Transformacje();
    }
}
