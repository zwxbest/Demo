package decorator.basic;

/**
 * Created by zwxbest on 2018/3/17.
 */
public abstract class Decorator extends Component
{
    protected Component component;

    public final void SetComponent(Component component)
    {
        this.component = component;
    }

    @Override
    public void Operation()
    {
        if (component != null)
        {
            component.Operation();
        }
    }
}
