public class ThreadlocalUse {
    public static ThreadLocal<String> local = new ThreadLocal<>(){
        @Override
        protected String initialValue() {
            return "hello world";
        }
    };
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                local.set("nihao");
                System.out.println("2:"+local.get());
                try {
                    Thread.sleep(5000,0);
                    System.out.println("2:"+local.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //local.set("itachi");
                System.out.println("1:"+local.get());
                try {
                    Thread.sleep(3000,0);
                    System.out.println("1:"+local.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();

        t1.join();
        t2.join();
    }


}
