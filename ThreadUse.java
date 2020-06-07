public class Mytest {
    public static void main(String args[]) throws InterruptedException {
        System.out.println(1);
        Mythread t = new Mythread();
        Thread t1 = new Thread(t);
        Thread t2 = new Mythread2();
        t2.start();
        t1.start();

        //join 等待线程
        t1.join();

        //打断正在执行的线程
        t1.interrupt();
    }
}

//使用实现接口，来使用多线程
class Mythread implements Runnable{
    @Override
    public void run(){
        System.out.println(2);
    }
}

//使用继承的方式，使用多线程
class Mythread2 extends Thread{
    @Override
    public void run() {
        System.out.println(3);
    }
}
