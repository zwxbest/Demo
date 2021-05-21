package decorator.basic;

import decorator.basic.ConcreteComponent;
import decorator.basic.ConcreteDecoratorA;
import decorator.basic.ConcreteDecoratorB;

public class Main
{
    private static void main(String[] args)
    {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        d1.SetComponent(c);
        d2.SetComponent(d1);

        d2.Operation();

    }
}

