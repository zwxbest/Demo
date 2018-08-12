import java.util.Random;

/**
 * Created by zwxbest on 2018/7/16.
 */
public class EqualsDemo {

   static class  A
    {
        A(int value)
        {
            this.value=value;
        }
        int value;
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof A)
            {
                A a=(A)obj;
                return this.value==a.value;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return new Random().nextInt();
        }
    }

    public static void main(String[] args) {
        A a1=new A(1);
        A a2=new A(1);
        System.out.println(a1.equals(a2));
    }

}
