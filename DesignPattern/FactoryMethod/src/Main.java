import operation.AddFactory;
import operation.IFactory;
import operation.Operation;

public class Main {

    public static void main(String[] args) {
        IFactory operFactory = new AddFactory();
        Operation oper = operFactory.CreateOperation();
        oper.setNumberA(1);
        oper.setNumberB(2);
        double result=oper.GetResult();
        System.out.println(result);
    }
}
