package at.nozicka.mandeljava.logic;

import org.apache.commons.math3.complex.Complex;

public class Mandel {

    public static int mandelbrotSet(Complex c, int maxIter) {
        Complex z = new Complex(0, 0);
        int n = 0;
        while (z.abs() < 2 && n < maxIter) {
            z = z.multiply(z).add(c);
            n++;
        }
        return n;
    }

    public static String mandel(int maxIter) {

        var result = new StringBuffer();

        int width = 80;
        int height = 40;
        double xMin = -2.0;
        double xMax = 1.0;
        double yMin = -1.5;
        double yMax = 1.5;
        double xStep = (xMax - xMin) / width;
        double yStep = (yMax - yMin) / height;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Complex c = new Complex(xMin + xStep * x, yMin + yStep * y);
                int n = mandelbrotSet(c, maxIter);
                char pixel = ' ';
                if (n <= 10) {
                    pixel = ' ';
                } else if (n <= 20) {
                    pixel = '.';
                } else {
                    // more characters for different iterations
                    pixel = '*';
                }
                //System.out.print(pixel);
                result.append(pixel);
            }
            //System.out.println();
            result.append('\n');
        }

        return result.toString();
    }

}
