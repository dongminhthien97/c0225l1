package model;

public class Caculator {
    public static double calculate(double firstOperand, double secondOperand, String operator) throws Exception {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand == 0) {
                    throw new Exception("Cannot divide by zero!");
                }
                return firstOperand / secondOperand;
            default:
                throw new Exception("Invalid operator!");
        }
    }
}
