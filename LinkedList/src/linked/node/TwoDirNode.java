package linked.node;

/**
 * User:zhangweixiao
 * Description:
 */
public class TwoDirNode<T> {
    private T obj;
    private TwoDirNode next = null;
    private TwoDirNode prior=null;

    public TwoDirNode(T obj) {
        this.setObj(obj);
    }

    public TwoDirNode<T> getNext() {
        return next;
    }

    public void setNext(TwoDirNode next) {
        this.next = next;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public TwoDirNode getPrior() {
        return prior;
    }

    public void setPrior(TwoDirNode prior) {
        this.prior = prior;
    }
}
