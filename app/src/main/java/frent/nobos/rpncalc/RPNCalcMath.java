package frent.nobos.rpncalc;
import java.util.ArrayList;
import java.util.List;

public class RPNCalcMath {
    private final List<Double> list = new ArrayList<>();

    // Method to add a number to the list
    public void enterNumber(double num) {
        this.list.add(num);
    }

    public double add() {
        return performOperation(Operation.ADD);
    }

    public double subtract() {
        return performOperation(Operation.SUBTRACT);
    }

    public double multiply() {
        return performOperation(Operation.MULTIPLY);
    }

    public double divide() {
        return performOperation(Operation.DIVIDE);
    }

    private double performOperation(Operation operation) {
        checkStackSize();

        double op2 = this.list.remove(list.size() - 1);
        double op1 = this.list.remove(list.size() - 1);

        double result = 0;
        switch (operation) {
            case ADD:
                result = op1 + op2;
                break;
            case SUBTRACT:
                result = op1 - op2;
                break;
            case MULTIPLY:
                result = op1 * op2;
                break;
            case DIVIDE:
                if (op2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                result = op1 / op2;
                break;
        }

        this.list.add(result);
        return result;
    }

    private void checkStackSize() {
        if (list.size() < 2) {
            throw new IllegalStateException("Not enough numbers in the stack to perform the operation.");
        }
    }

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
