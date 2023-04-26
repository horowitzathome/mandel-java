package at.nozicka.mandeljava.logic;

public class Mandel {

    //private static final int WIDTH = 80;
    //private static final int HEIGHT = 40;
    private static final double X_MIN = -2.0;
    private static final double X_MAX = 1.0;
    private static final double Y_MIN = -1.5;
    private static final double Y_MAX = 1.5;
    //private static final double X_STEP = (X_MAX - X_MIN) / WIDTH;
    //private static final double Y_STEP = (Y_MAX - Y_MIN) / HEIGHT;

    private static int mandelbrotSet(double cx, double cy, int maxIter) {
        double zx = 0.0;
        double zy = 0.0;
        int n = 0;
        while(true) {
            double zx_sq = zx * zx;
            double zy_sq = zy * zy;
            if (n >= maxIter || zx_sq + zy_sq >= 4.0)
                break;

            zy = 2.0 * zx * zy + cy;
            zx = zx_sq - zy_sq + cx;
            n += 1;
        }
        return n;
    }

    public static String mandel(int maxIter, int height, int width) {
        var result = new StringBuffer(height * (width + 1));

        double X_STEP = (X_MAX - X_MIN) / width;
        double Y_STEP = (Y_MAX - Y_MIN) / height;

        double cy = Y_MIN;
        for (int y = 0; y < height; y++) {
            double cx = X_MIN;
            for (int x = 0; x < width; x++) {
                int n = mandelbrotSet(cx, cy, maxIter);
                result.append(pixel(n));
                cx += X_STEP;
            }
            result.append('\n');
            cy += Y_STEP;
        }

        return result.toString();
    }

    private static char pixel(int n) {
        char pixel;
        if (n <= 10)
            pixel = ' ';
        else if (n > 70)
            pixel = '*';
        else if (n <= 20)
            pixel = '.';
        else if (n <= 30)
            pixel = '+';
        else if (n <= 40)
            pixel = '=';
        else if (n <= 50)
            pixel = '?';
        else if (n <= 60)
            pixel = '#';
        else
            pixel = ':';
        return pixel;
    }

}
