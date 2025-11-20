/*
 * Copyright 2015-2025 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

public class Calculator {

    private String id;

    public Calculator(String id) {
        this.id = id;
    }

    /**
     * Adds two integers.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second integer from the first.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the difference of a and b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first integer by the second.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the quotient of a divided by b
     * @throws DivisionByZeroException if b is zero
     */
    public int divide(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Cannot divide by zero");
        }
        return a / b;
    }

    // Intentionally commented out method for SonarQube test case purposes
    // public int modulus(int a, int b) {
    // return a % b;
    // }

    @Override
    public boolean equals(Object obj) {
        // Intentional bad practice: checks for reference equality instead of logical
        // equality
        return obj == this;
    }
}
