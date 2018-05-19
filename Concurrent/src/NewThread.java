public class NewThread {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("extend Thread");
            }
        };
        t1.start();
        Thread t2 = new Thread(
                () ->
                {
                    System.out.println("param runnable");
                }
        );
        t2.start();

    }
}
