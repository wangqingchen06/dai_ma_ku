<<<<<<< HEAD
package com.wqc.dai_ma_ku;

/**
 * 高内聚 低耦合  线程  操作  资源类
 * 判断  干活  通知
 * 题目：现在两个线程，可以操作初始值为零的一个变量，实现一个线程对该变量加1，一个线程对该变量减1，
 * 实现交替，来10轮，变量初始值为零。
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        ZiYuan ziYuan = new ZiYuan();
        //线程1
        new Thread(()->{
            for(int i=1;i<=10;i++) {
                try {
                    //调用资源类加
                    ziYuan.jia();
                    //暂停一会儿线程
                    try { Thread.sleep( 200 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"a").start();

        //线程2
        new Thread(()->{
            for(int i=1;i<=10;i++){
                try {
                    //调用资源类减
                    ziYuan.jian();
                    //暂停一会儿线程
                    try { Thread.sleep( 300 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"b").start();
    //线程3
        new Thread(()->{
            for(int i=1;i<=10;i++) {
                try {
                    //调用资源类加
                    ziYuan.jia();
                    //暂停一会儿线程
                    try { Thread.sleep( 400 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"c").start();

        //线程4
        new Thread(()->{
            for(int i=1;i<=10;i++){
                try {
                    //调用资源类减
                    ziYuan.jian();
                    //暂停一会儿线程
                    try { Thread.sleep( 500 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"d").start();
    }


}
class ZiYuan {
    // 创建数值
    private int number = 0;
    //方法数值加
    public synchronized void jia()throws  Exception{
        //判断数值是否等于0   判断要用while 不能用if
        while (number!=0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }
    //方法数值减
    public synchronized void jian() throws Exception{
        //判断数值是否等于1  判断要用while 不能用if
        while (number==0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }

}
=======
package com.wqc.dai_ma_ku;

/**
 * 高内聚 低耦合  线程  操作  资源类
 * 判断  干活  通知
 * 题目：现在两个线程，可以操作初始值为零的一个变量，实现一个线程对该变量加1，一个线程对该变量减1，
 * 实现交替，来10轮，变量初始值为零。
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        ZiYuan ziYuan = new ZiYuan();
        //线程1
        new Thread(()->{
            for(int i=1;i<=10;i++) {
                try {
                    //调用资源类加
                    ziYuan.jia();
                    //暂停一会儿线程
                    try { Thread.sleep( 200 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"a").start();

        //线程2
        new Thread(()->{
            for(int i=1;i<=10;i++){
                try {
                    //调用资源类减
                    ziYuan.jian();
                    //暂停一会儿线程
                    try { Thread.sleep( 300 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"b").start();
    //线程3
        new Thread(()->{
            for(int i=1;i<=10;i++) {
                try {
                    //调用资源类加
                    ziYuan.jia();
                    //暂停一会儿线程
                    try { Thread.sleep( 400 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"c").start();

        //线程4
        new Thread(()->{
            for(int i=1;i<=10;i++){
                try {
                    //调用资源类减
                    ziYuan.jian();
                    //暂停一会儿线程
                    try { Thread.sleep( 500 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"d").start();
    }


}
class ZiYuan {
    // 创建数值
    private int number = 0;
    //方法数值加
    public synchronized void jia()throws  Exception{
        //判断数值是否等于0   判断要用while 不能用if
        while (number!=0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }
    //方法数值减
    public synchronized void jian() throws Exception{
        //判断数值是否等于1  判断要用while 不能用if
        while (number==0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }

}
>>>>>>> ac8b47a629dceecb818c662e0099b6f7cd4d897b
