package qq;

import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
       //new出3个车位  让线程抢
        Semaphore semaphore = new Semaphore(3);

        for (int i =1;i<=6;i++){
            new Thread(()->{
                try {
                    //占住车位
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t占到停车位");
                    //停在车位上几秒
                    try { TimeUnit.SECONDS.sleep( 3 ); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放车位
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
