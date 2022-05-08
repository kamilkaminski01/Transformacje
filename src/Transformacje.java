import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Transformacje {

    int height, height2;
    int width, width2;
    BufferedImage image, image2;


    public Transformacje() {
        try {
            // Odczyt obrazu z pliku
            File input = new File("obrazek.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            File input2 = new File("obrazek2.jpg");
            image2 = ImageIO.read(input);
            width2 = image2.getWidth();
            height2 = image2.getHeight();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void rozjasnianie(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color c = new Color(image.getRGB(j, i));
                int red = (int) (c.getRed());
                int green = (int) (c.getGreen());
                int blue = (int) (c.getBlue());
                int x = 30;


                if (red + x >= 255) red = 255;
                if (red + x <= 255) red += x;
                if (green + x >= 255) green = 255;
                if (green + x <= 255) green += x;
                if (blue + x >= 255) blue = 255;
                if (blue + x <= 255) blue += x;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void przyciemnianie(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color c = new Color(image.getRGB(j, i));
                int red = (int) (c.getRed());
                int green = (int) (c.getGreen());
                int blue = (int) (c.getBlue());
                int x = 30;

                if (red - x >= 0) red -= x;
                if (red - x <= 0) red = 0;
                if (green - x >= 0) green -= x;
                if (green - x <= 0) green = 0;
                if (blue - x >= 0) blue -= x;
                if (blue - x <= 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void negatyw(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color c = new Color(image.getRGB(j, i));
                int red = (int) (c.getRed());
                int green = (int) (c.getGreen());
                int blue = (int) (c.getBlue());
                int x = 30;

                if (255 - red >= 0) red = 255 - red;
                if (255 - green >= 0) green = 255 - green;
                if (255 - blue >= 0) green = 255 - blue;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void potegowa(double c, double n){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
//                int red = (int) (c.getRed());
//                int green = (int) (c.getGreen());
//                int blue = (int) (c.getBlue());
//                int x = 30;

                int red = (int) Math.pow((color.getRed() * c), n);
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                int green = (int) Math.pow((color.getGreen() * c), n);
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                int blue = (int) Math.pow((color.getBlue() * c), n);
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void suma(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = color.getRed() + color2.getRed();
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                int green = color.getGreen() + color2.getGreen();
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                int blue = color.getBlue() + color2.getBlue();
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void odejmowanie(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = color.getRed() + color2.getRed() - 1;
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                int green = color.getGreen() + color2.getGreen() - 1;
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                int blue = color.getBlue() + color2.getBlue() - 1;
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void roznica(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = Math.abs(color.getRed() - color2.getRed());
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                int green = Math.abs(color.getGreen() - color2.getGreen());
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                int blue = Math.abs(color.getBlue() - color2.getBlue());
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void mnozenie(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = color.getRed() * color2.getRed();
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                int green = color.getGreen() * color2.getGreen();
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                int blue = color.getBlue() * color2.getBlue();
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void mnozenieOdwrotnosci(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = (1 - (1 - color.getRed()) * (1 - color2.getRed()));
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                int green = (1 - (1 - color.getGreen()) * (1 - color2.getGreen()));
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                int blue = (1 - (1 - color.getBlue()) * (1 - color2.getBlue()));
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void negacja(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = 1 - Math.abs(1 - color.getRed() - color2.getRed());
                if (red < 0) red = 0;
                int green = 1 - Math.abs(1 - color.getGreen() - color2.getGreen());
                if (green < 0) green = 0;
                int blue = 1 - Math.abs(1 - color.getBlue() - color2.getBlue());
                if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void ciemniejsze(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = color2.getRed();
                if (color.getRed() < color2.getRed()) {
                    red = color.getRed();
                }
                int green = color2.getGreen();
                if (color.getGreen() < color2.getGreen()) {
                    green = color.getGreen();
                }
                int blue = color2.getBlue();
                if (color.getBlue() < color2.getBlue()) {
                    blue = color.getBlue();
                }

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void jasniejsze(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = color2.getRed();
                if (color.getRed() > color2.getRed()) {
                    red = color.getRed();
                }
                int green = color2.getGreen();
                if (color.getGreen() > color2.getGreen()) {
                    green = color.getGreen();
                }
                int blue = color2.getBlue();
                if (color.getBlue() > color2.getBlue()) {
                    blue = color.getBlue();
                }

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void wylaczenie(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = color.getRed() + color2.getRed() - (2 * color.getRed() * color2.getRed());
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                int green = color.getGreen() + color2.getGreen() - (2 * color.getGreen() * color2.getGreen());
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                int blue = color.getBlue() + color2.getBlue() - (2 * color.getBlue() * color2.getBlue());
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void nakladka(){
         for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = 1 - (2 * (1 - color.getRed()) * (1 - color2.getRed()));
                if (color.getRed() < 255 * 0.5) {
                    red = 2 * color.getRed() * color2.getRed();
                }
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                int green = 1 - (2 * (1 - color.getGreen()) * (1 - color2.getGreen()));
                if (color.getGreen() < 255 * 0.5) {
                    green = 2 * color.getGreen() * color2.getGreen();
                }
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                int blue = 1 - (2 * (1 - color.getBlue()) * (1 - color2.getBlue()));
                if (color.getBlue() < 255 * 0.5) {
                    blue = 2 * color.getBlue() * color2.getBlue();
                }
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void ostreSwiatlo(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = 1 - (2 * (1 - color.getRed()) * (1 - color2.getRed()));
                if (color2.getRed() < 255 * 0.5) {
                    red = 2 * color.getRed() * color2.getRed();
                }
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                int green = 1 - (2 * (1 - color.getGreen()) * (1 - color2.getGreen()));
                if (color2.getGreen() < 255 * 0.5) {
                    green = 2 * color.getGreen() * color2.getGreen();
                }
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                int blue = 1 - (2 * (1 - color.getBlue()) * (1 - color2.getBlue()));
                if (color2.getBlue() < 255 * 0.5) {
                    blue = 2 * color.getBlue() * color2.getBlue();
                }
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void lagodneSwiatlo(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = (int) (Math.sqrt(color.getRed()) * (2 * color2.getRed() - 1) + (2 * color.getRed()) * (1 - color2.getRed()));
                if (color2.getRed() < 255 * 0.5) {
                    red = (int) (2 * color.getRed() * color2.getRed() + Math.pow(color.getRed(), 2) * (1 - 2 * color2.getRed()));
                }
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                int green = (int) (Math.sqrt(color.getGreen()) * (2 * color2.getGreen() - 1) + (2 * color.getGreen()) * (1 - color2.getGreen()));
                if (color2.getGreen() < 255 * 0.5) {
                    green = (int) (2 * color.getGreen() * color2.getGreen() + Math.pow(color.getGreen(), 2) * (1 - 2 * color2.getGreen()));
                }
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                int blue = (int) (Math.sqrt(color.getBlue()) * (2 * color2.getBlue() - 1) + (2 * color.getBlue()) * (1 - color2.getBlue()));
                if (color2.getBlue() < 255 * 0.5) {
                    blue = (int) (2 * color.getBlue() * color2.getBlue() + Math.pow(color.getBlue(), 2) * (1 - 2 * color2.getBlue()));
                }
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void rozcienczenie(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int temp = 1 - color2.getRed();
                if (temp == 0) {
                    temp = 1;
                }
                int red = color.getRed() / (temp);
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                temp = 1 - color2.getGreen();
                if (temp == 0) {
                    temp = 1;
                }
                int green = color.getGreen() / (temp);
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                temp = 1 - color2.getBlue();
                if (temp == 0) {
                    temp = 1;
                }
                int blue = color.getBlue() / (temp);
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void wypalenie(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int temp = color2.getRed();
                if (temp == 0) {
                    temp = 1;
                }
                int red = 1 - (1 - color.getRed()) / temp;
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                temp = color2.getGreen();
                if (temp == 0) {
                    temp = 1;
                }
                int green = 1 - (1 - color.getGreen()) / temp;
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                temp = color2.getBlue();
                if (temp == 0) {
                    temp = 1;
                }
                int blue = 1 - (1 - color.getBlue()) / temp;
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void reflectMode(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int temp = color2.getRed();
                if (temp==1) {
                    temp = 0;
                }
                int red = (int) (Math.pow(color.getRed(), 2) / (1 - temp));
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                temp = color2.getGreen();
                if (temp==1) {
                    temp = 0;
                }
                int green = (int) (Math.pow(color.getGreen(), 2) / (1 - temp));
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                temp = color2.getBlue();
                if (temp==1) {
                    temp = 0;
                }
                int blue = (int) (Math.pow(color.getBlue(), 2) / (1 - temp));
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void przezroczystosc(double alpha){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Color color = new Color(image.getRGB(j, i));
                Color color2 = new Color(image2.getRGB(j, i));

                int red = (int) ((1 - alpha) * color2.getRed() + alpha * color.getRed());
                if (red > 255) red = 255;
                else if (red < 0) red = 0;
                int green = (int) ((1 - alpha) * color2.getGreen() + alpha * color.getGreen());
                if (green > 255) green = 255;
                else if (green < 0) green = 0;
                int blue = (int) ((1 - alpha) * color2.getBlue() + alpha * color.getBlue());
                if (blue > 255) blue = 255;
                else if (blue < 0) blue = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void menu(int choice) throws IOException {

        switch (choice){
            case 1:
                rozjasnianie();
                break;
            case 2:
                przyciemnianie();
                break;
            case 3:
                negatyw();
                break;
            case 4:
                double c = 1.0, n = 0.0;
                potegowa(c, n);
                break;
            case 5:
                suma();
                break;
            case 6:
                odejmowanie();
                break;
            case 7:
                roznica();
                break;
            case 8:
                mnozenie();
                break;
            case 9:
                mnozenieOdwrotnosci();
                break;
            case 10:
                negacja();
                break;
            case 11:
                ciemniejsze();
                break;
            case 12:
                jasniejsze();
                break;
            case 13:
                wylaczenie();
                break;
            case 14:
                nakladka();
                break;
            case 15:
                ostreSwiatlo();
                break;
            case 16:
                lagodneSwiatlo();
                break;
            case 17:
                rozcienczenie();
                break;
            case 18:
                wypalenie();
                break;
            case 19:
                reflectMode();
                break;
            case 20:
                double alpha = 1.0;
                przezroczystosc(alpha);
                break;
        }
        if (choice != 0){
            // Zapis do pliku zmodyfikowanego obrazu
            File ouptut = new File("grayscale.jpg");
            ImageIO.write(image, "jpg", ouptut);
            System.out.println("Zmiany dokonane pomyslnie do obrazku grayscale.jpg");
        }
    }

    static public void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Transformacje obj = new Transformacje();
        int choice = 1;
        while (choice != 0){
            System.out.println("1 - Rozjasnianie");
            System.out.println("2 - Przyciemnianie");
            System.out.println("3 - Negatyw");
            System.out.println("4 - Transformacja potegowa");
            System.out.println();
            System.out.println("----TRYB MIESZANIA----");
            System.out.println();
            System.out.println("5 - Suma");
            System.out.println("6 - Odejmowanie");
            System.out.println("7 - Odejmowanie");
            System.out.println("8 - Mnozenie");
            System.out.println("9 - Mnozenie odwrotnosci");
            System.out.println("10 - Negacja");
            System.out.println("11 - Ciemniejsze");
            System.out.println("12 - Jasniejsze");
            System.out.println("13 - Wylaczenie");
            System.out.println("14 - Nakladka");
            System.out.println("15 - Ostre Swiatlo");
            System.out.println("16 - Lagodne Swiatlo");
            System.out.println("17 - Rozcienczenie");
            System.out.println("18 - Wypalenie");
            System.out.println("19 - Reflect Mode");
            System.out.println("20 - Przezroczystosc");
            System.out.println();
            System.out.print("wybierz: ");
            choice = scanner.nextInt();

            obj.menu(choice);
        }
    }
}
