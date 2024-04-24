package org.example;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

public class Main {
    public static void main(String[] args) {
        // Given data points
        double stage = 0.01;
        double x0 = 0.751;
        int n = 8; double val = 0.775;
        double[] xList = new double[n]; // GIVE LENGTH VALUE AND STAGE NUMBER
        double[] yList = new double[n];

        for (int i = 0; i < n; i++) {
            xList[i] = x0 + stage * i;
            yList[i] = Math.cos(xList[i]);
        }
        CosTablePrint(xList, yList);

        System.out.println("\nNext Lagrange Polynomials 1th");
        PolynomialFunction[] polynomialFirstFormList = new PolynomialFunction[n - 1];
        for (int i = 0; i < polynomialFirstFormList.length; i++) {
            polynomialFirstFormList[i] = createLagrangePolynomialFromTwoPoints(xList[i], yList[i], xList[i + 1], yList[i + 1]);
            System.out.printf("[%d] Polynomial: %s\n", i, polynomialFirstFormList[i].toString());

        }
        System.out.println("\nNext Lagrange Polynomials 2th");

        int shift = 2;
        PolynomialFunction[] polynomialSecondFormList = new PolynomialFunction[n - shift];
        for (int i = 0; i < polynomialSecondFormList.length; i++) {
            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});

            PolynomialFunction tempPositive = polynomialFirstFormList[i].multiply(additionalPolynom2);
            PolynomialFunction tempNegative = polynomialFirstFormList[i+1].multiply(additionalPolynom1);
            polynomialSecondFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
            System.out.printf("[%d] Polynomial: %s\n", i, polynomialSecondFormList[i].toString());
        }
        System.out.println("\nNext Lagrange Polynomials 3th");

        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
        PolynomialFunction[] polynomialThirdFormList = new PolynomialFunction[n - shift];
        for (int i = 0; i < polynomialThirdFormList.length; i++) {
            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});

            PolynomialFunction tempPositive = polynomialSecondFormList[i].multiply(additionalPolynom2);
            PolynomialFunction tempNegative = polynomialSecondFormList[i+1].multiply(additionalPolynom1);
            polynomialThirdFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
            System.out.printf("[%d] Polynomial: %s\n", i, polynomialThirdFormList[i].toString());
        }
        System.out.println("\nNext Lagrange Polynomials 4th");

        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
        PolynomialFunction[] polynomialForthFormList = new PolynomialFunction[n - shift];
        for (int i = 0; i < polynomialForthFormList.length; i++) {
            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});

            PolynomialFunction tempPositive = polynomialThirdFormList[i].multiply(additionalPolynom2);
            PolynomialFunction tempNegative = polynomialThirdFormList[i+1].multiply(additionalPolynom1);
            polynomialForthFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
            System.out.printf("[%d] Polynomial: %s\n", i, polynomialForthFormList[i].toString());
        }
        System.out.println("\nNext Lagrange Polynomials 5th");

        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
        PolynomialFunction[] polynomialFifthFormList = new PolynomialFunction[n - shift];
        for (int i = 0; i < polynomialFifthFormList.length; i++) {
            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});

            PolynomialFunction tempPositive = polynomialForthFormList[i].multiply(additionalPolynom2);
            PolynomialFunction tempNegative = polynomialForthFormList[i+1].multiply(additionalPolynom1);
            polynomialFifthFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
            System.out.printf("[%d] Polynomial: %s\n", i, polynomialFifthFormList[i].toString());
        }


        System.out.println("\nTo find our root we should take 4th form of polynomial based on 0.772 point. And pass 0.775 parameter to find cos(x) value");
        PolynomialFunction[] aproximateFunctions = {polynomialFirstFormList[2], polynomialSecondFormList[2], polynomialThirdFormList[2], polynomialForthFormList[2]};
        double tablY = Math.cos(val);
        for (int i = 0; i < 5; i++) {
            System.out.printf("Working with Lagrange [%dth] f(x): %s\n", i, aproximateFunctions[i].toString());
            double calcY = aproximateFunctions[i].value(val);
            System.out.printf("x = %f f(x) = %f e = %.15f\n", val, aproximateFunctions[i].value(val), Math.abs(calcY-tablY));
        }
        System.out.println("Виконав студент групи ОІ-24 Марушкевич Роман");

    }

    private static PolynomialFunction createLagrangePolynomialFromTwoPoints(double x0, double y0, double x1, double y1) {
        double b = (y0*x1 - y1*x0)/(x1-x0);
        double k = (y1-y0)/(x1-x0);

        double[] coefficients = {b,k};
        return new PolynomialFunction(coefficients);
    }
    public static void CosTablePrint(double[] xList, double[] yList) {
        // Print the table header
        System.out.printf("%-10s%-15s%n", "x", "cos(x)");
        System.out.println("----------------------------");

        // Print the values in a table format
        for (int i = 0; i < xList.length; i++) {
            System.out.printf("%-10.3f | \t%-15.6f%n", xList[i], yList[i]);
        }
    }
}
