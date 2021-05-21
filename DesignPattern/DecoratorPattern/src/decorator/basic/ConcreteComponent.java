package decorator.basic;

/**
 * Created by zwxbest on 2018/3/17.
 */
public class ConcreteComponent extends Component
{
    @Override
    public void Operation()
    {
        System.out.println("具体对象的操作");
    }
}
