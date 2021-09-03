import java.util.logging.Logger;

public class Triangle {
    private double a;
    private double b;
    private double c;
    private final static Logger logger = Logger.getLogger(Triangle.class.getName());

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        logger.info("Triangle create with sides: " + a + ", " + b + ", " + c);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double square() {
        double p = (a + b + c) / 2;
        double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        logger.info("Triangle square: " + square);
        return square;
    }
}