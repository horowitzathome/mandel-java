package at.nozicka.mandeljava.logic;

import org.apache.commons.math3.complex.Complex;

public class ComplexMandel {
    public double real;
    public double imaginary;

    public ComplexMandel(double real, double imaginary) {

        //var c = new Complex(0,0);
        //c.abs();

        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexMandel multiply(ComplexMandel factor) {
        return new ComplexMandel(real * factor.real - imaginary * factor.imaginary,
                real * factor.imaginary + imaginary * factor.real);
    }

    public ComplexMandel add(ComplexMandel addend) {
        return new ComplexMandel(real + addend.real,
                imaginary + addend.imaginary);


    }


}
