<<<<<<< HEAD
package com.wqc.dai_ma_ku;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 高内聚 低耦合  线程  操作  资源类
 * 判断  干活  通知
 * 题目：现在两个线程，可以操作初始值为零的一个变量，实现一个线程对该变量加1，一个线程对该变量减1，
 * 实现交替，来10轮，变量初始值为零。
 */
public class Lock1 {
    public static void main(String[] args) {
        Shu shu = new Shu();
        //线程1
        new Thread(()->{
            for (int i=1;i<=10;i++){
                try {
                    shu.jia();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        //线程2
        new Thread(()->{
            for (int i=1;i<=10;i++){
                try {
                    shu.jian();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        //线程3
        new Thread(()->{
            for (int i=1;i<=10;i++){
                try {
                    shu.jia();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        //线程4
        new Thread(()->{
            for (int i=1;i<=10;i++){
                try {
                    shu.jian();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();


    }
}
class Shu{

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public  void jia()throws  Exception{
      lock.lock();

      try {
        //判断
          while (number!=0){
              condition.await();
          }
          //干活
          number++;
          System.out.println(Thread.currentThread().getName()+"\t"+number);
          //通知
          condition.signalAll();
      }finally {
        lock.unlock();
      }
    }

    public void jian()throws Exception{
        lock.lock();

        try {
            //判断
            while (number==0){
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();

        }finally {
        lock.unlock();
        }

    }
}
=======
package com.wqc.dai_ma_ku;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 高内聚 低耦合  线程  操作  资源类
 * 判断  干活  通知
 * 题目：现在两个线程，可以操作初始值为零的一个变量，实现一个线程对该变量加1，一个线程对该变量减1，
 * 实现交替，来10轮，变量初始值为零。
 */
public class Lock1 {
    public static void main(String[] args) {
        Shu shu = new Shu();
        //线程1
        new Thread(()->{
            for (int i=1;i<=10;i++){
                try {
                    shu.jia();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        //线程2
        new Thread(()->{
            for (int i=1;i<=10;i++){
                try {
                    shu.jian();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        //线程3
        new Thread(()->{
            for (int i=1;i<=10;i++){
                try {
                    shu.jia();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        //线程4
        new Thread(()->{
            for (int i=1;i<=10;i++){
                try {
                    shu.jian();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();


    }
}
class Shu{

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public  void jia()throws  Exception{
      lock.lock();

      try {
        //判断
          while (number!=0){
              condition.await();
          }
          //干活
          number++;
          System.out.println(Thread.currentThread().getName()+"\t"+number);
          //通知
          condition.signalAll();
      }finally {
        lock.unlock();
      }
    }

    public void jian()throws Exception{
        lock.lock();

        try {
            //判断
            while (number==0){
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();

        }finally {
        lock.unlock();
        }

    }
}
>>>>>>> ac8b47a629dceecb818c662e0099b6f7cd4d897b
