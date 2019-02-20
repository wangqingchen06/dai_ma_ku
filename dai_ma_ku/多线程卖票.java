package com.atguigu.gmall.gmallmqtest.mq;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Aaa {
    public static void main(String[] args)throws Exception {
        //new出数据源
        Ticket ticket = new Ticket();
        //用lambda表达式创建线程 
        //lambda 小括号拷贝  写死右箭头  大括号落实
     new Thread(()->{for(int i = 1; i<=40;i++) ticket.sale(); } ,"A").start();
     new Thread(()->{for(int i = 1; i<=40;i++) ticket.sale(); } ,"B").start();
     new Thread(()->{for(int i = 1; i<=40;i++) ticket.sale(); } ,"C").start();

    }
}
class Ticket{
    //创建票数
    private int number = 30;
    //创建 lock锁
    private  Lock lock = new ReentrantLock();
    //创建方法
    public void  sale(){
        //锁住
        lock.lock();
        try {
            //判断票数是否大于0
          if (number>0){
              //输出
              System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
          }
        }finally {
         //关闭锁
            lock.unlock();
        }
    }



}
