package strategyAndSimpleFactory.strategy.operation.binary;

import strategyAndSimpleFactory.strategy.operation.Operation;

/**
 * Created by zwxbest on 2018/3/17.
 */
public abstract class OperationBinary implements Operation {
    private double numberA;
    private double numberB;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }
}
