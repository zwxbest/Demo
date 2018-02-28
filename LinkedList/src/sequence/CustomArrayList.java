package sequence;

import linked.node.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User:zhangweixiao
 * Description:
 */
public class CustomArrayList<T> {

    //cann't use new T[];
    private  Object[] data;
    private int capacity;
    private int cur_cout=0;

    public CustomArrayList(T... args)
    {
        capacity=args.length;
        data=new Object[capacity];
        for(T arg:args)
            data[cur_cout++]=arg;
    }

    public T delete(int pos)
    {
        //if pos==cur_count,throw exception
        if(pos<0||pos>=cur_cout)
            throw new  IndexOutOfBoundsException();
        T ret=(T)data[pos];
        for(int i=pos;i<cur_cout-1;i++)
        {
            data[i]=data[i+1];
        }
        cur_cout--;
        return  ret;

    }


    public boolean Insert(int pos,T... args)
    {
        int ret=before_insert(args.length,pos);
        for(T arg:args)
        {
            data[ret++]=arg;
        }
        return true;
    }

    /**
     *
     * @param length the insert length
     * @param pos insert postion
     * @return  the postion to update
     */
    private int before_insert(int length,int pos)
    {
        //if pos==0,insert before the first
        //if pos==cur_count-1,insert before the last
        //if pos==cur_count,insert after the last
        if(pos<0||pos>cur_cout)
            throw new  IndexOutOfBoundsException();
        //space is not enough
        cur_cout+=length;
        while (cur_cout>capacity)
        {
            capacity*=2;
        }
        Object[] temp=new Object[capacity];
        System.arraycopy(data,0,temp,0,data.length);
        data=temp;
        int ret=pos-1+length;
        for(int i=cur_cout-1;i>=ret;i--)
        {
            data[i+1]=data[i];
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<cur_cout;i++)
            sb.append(data[i]+",");
        return sb.toString();
    }



    public int Length()
    {
        return cur_cout;
    }
}
