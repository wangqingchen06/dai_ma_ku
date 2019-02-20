package qq;

import java.util.concurrent.CountDownLatch;

public class ShuXia {
    public static void main(String[] args)throws Exception {
        //创建总数为6的线程限制
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t国被灭");
                //限制减少1
                countDownLatch.countDown();
            },CountryEnum.forEach_CountryEnum(i).getName()).start();
        }
        //阻塞 当限制为0是放行
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t统一天下");
    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("***********关门");
    }
}
