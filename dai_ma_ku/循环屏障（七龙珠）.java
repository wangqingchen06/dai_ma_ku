package qq;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //创建CyclicBarrier循环屏障
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{ System.out.println("******召唤神龙");});
        for (int i =1;i<=7;i++){
            //lambda必须用final修饰
            final int a = i;
            new Thread(()->{
                //第几个线程收集第几颗龙珠
                System.out.println(Thread.currentThread().getName()+"\t收集第"+a+"龙珠");
                try {
                    //当龙珠不是7颗时阻塞
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
