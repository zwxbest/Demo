public class Test {

    private boolean stop = false;

    public void doSth() throws InterruptedException {
        while (!stop) {
            System.out.println("thread1 is do sth");
            Thread.sleep(1000);
        }
        System.out.println("thread1 is stopped");

    }

    private void stopDoSth() {
        stop = true;
        System.out.println("thread2 try to stop do sth");
        while (stop){
            System.out.println("thread2 is do other things");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        final Test test = new Test();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    test.doSth();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                test.stopDoSth();
            }
        });
        thread1.start();
    }
}
