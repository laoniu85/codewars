package com.laoniu.codewars.Reverse_polish_notation_calculator;

import java.util.Stack;

public class Calc {

    public static enum Operation {
        Mul("*") {
            @Override
            public double operation(double a, double b) {
                return a * b;
            }
        },
        Div("/") {
            @Override
            public double operation(double a, double b) {
                return a / b;
            }

        },
        Add("+") {
            @Override
            public double operation(double a, double b) {
                return a + b;
            }
        },
        Sub("-") {
            @Override
            public double operation(double a, double b) {
                return a - b;
            }
        };
        String value;

        Operation(String value) {
            this.value = value;
        }

        abstract public double operation(double a, double b);
    }


    public double evaluate(String expr) {
        if (expr.equals("")) {
            return 0;
        }
        Stack<Double> values = new Stack<>();
        String[] elements = expr.split("\\s");
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            Operation operation = getOperation(element);
            if (operation != null) {
                double valueB = values.pop();
                double valueA = values.pop();
                double result = operation.operation(valueA, valueB);
                values.push(result);
            } else {
                values.push(Double.parseDouble(element));
            }
        }
        return values.pop();
    }

    private Operation getOperation(String element) {
        for (Operation operation : Operation.values()) {
            if (operation.value.equals(element)) {
                return operation;
            }
        }
        return null;
    }
}