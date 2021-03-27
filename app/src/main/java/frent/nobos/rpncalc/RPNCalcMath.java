package frent.nobos.rpncalc;

import java.util.ArrayList;
import java.util.List;

public class RPNCalcMath {
    private List<Double> list = new ArrayList();

    public RPNCalcMath() {
    }

    public void enterNumber(double num) {
        this.list.add(num);
    }

    public double add() {
        RPNCalcMath.Operands ops = this.getOps();
        double result = ops.op1 + ops.op2;
        this.list.add(result);
        return result;
    }

    public double subtract() {
        RPNCalcMath.Operands ops = this.getOps();
        double result = ops.op1 - ops.op2;
        this.list.add(result);
        return result;
    }

    public double multiply() {
        RPNCalcMath.Operands ops = this.getOps();
        double result = ops.op1 * ops.op2;
        this.list.add(result);
        return result;
    }

    public double divide() {
        RPNCalcMath.Operands ops = this.getOps();
        double result = ops.op1 / ops.op2;
        this.list.add(result);
        return result;
    }

    private RPNCalcMath.Operands getOps() {
        RPNCalcMath.Operands ops = new RPNCalcMath.Operands();
        int size = this.list.size();
        ops.op1 = size > 1 ? (Double)this.list.get(size - 2) : 0.0D;
        ops.op2 = size > 0 ? (Double)this.list.get(size - 1) : 0.0D;
        switch(size) {
            default:
                this.list.remove(size-- - 1);
            case 1:
                this.list.remove(size-- - 1);
            case 0:
                return ops;
        }
    }

    private class Operands {
        double op1;
        double op2;

        private Operands() {
        }
    }
}