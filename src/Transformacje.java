import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void rozjasnianiePrzyciemnianieNegatyw(int choice) throws IOException {
        //odczyt pixeli obrazu w dwóch pętlach po kolumnach i wierszach
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //odczyt składowych koloru RGB
                Color c = new Color(image.getRGB(j, i));
                int red = (int) (c.getRed());
                int green = (int) (c.getGreen());
                int blue = (int) (c.getBlue());
                int x = 30;

                // Rozjaśnianie
                if (choice == 1) {
                    if (red + x >= 255) red = 255;
                    if (red + x <= 255) red += x;
                    if (green + x >= 255) green = 255;
                    if (green + x <= 255) green += x;
                    if (blue + x >= 255) blue = 255;
                    if (blue + x <= 255) blue += x;
                }
                //Przyciemnianie
                else if (choice == 2) {
                    if (red - x >= 0) red -= x;
                    if (red - x <= 0) red = 0;
                    if (green - x >= 0) green -= x;
                    if (green - x <= 0) green = 0;
                    if (blue - x >= 0) blue -= x;
                    if (blue - x <= 0) blue = 0;
                }
                // Negatyw
                else if (choice == 3){
                    if (255 - red >= 0) red = 255 - red;
                    if (255 - green >= 0) green = 255 - green;
                    if (255 - blue >= 0) green = 255 - blue;
                }

                /*
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
                */

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
        //koniec dwóch pętli po kolumnach i wierszach obrazu
        //zapis do pliku zmodyfikowanego obrazu
        File ouptut = new File("grayscale.jpg");
        ImageIO.write(image, "jpg", ouptut);
    }

    static public void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Transformacje obj = new Transformacje();

        System.out.println("Rozjasnianie - 1");
        System.out.println("Przyciemnianie - 2");
        System.out.println("Negatyw - 3");
        System.out.print("wybierz: ");
        int choice = scanner.nextInt();
        obj.rozjasnianiePrzyciemnianieNegatyw(choice);
    }
}
