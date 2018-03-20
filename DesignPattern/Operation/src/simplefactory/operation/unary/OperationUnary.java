package simplefactory.operation.unary;


import simplefactory.operation.Operation;

/**
 * Created by zwxbest on 2018/3/17.
 */
public abstract class OperationUnary implements Operation {

    private double number;

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}
