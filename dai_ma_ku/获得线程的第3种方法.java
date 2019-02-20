package com.wqc.dai_ma_ku;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.Function;

public class DuoXianCheng3 {
    public static void main(String[] args) throws Exception {
        //使用普通方法
        //FutureTask<Integer> futureTask = new FutureTask(new Ziyuan());
        //因为Callable是函数式接口 所以使用lambda表达式
        FutureTask<Integer> futureTask = new FutureTask(()->{
            System.out.println("**********123123");
            return 123;
        });
        Thread t1 = new Thread(futureTask,"A");
        t1.start();
        System.out.println(futureTask.get());

    }
}
//资源类实现Callable接口
class Ziyuan implements Callable<Integer>{

    //重写Callable方法
    @Override
    public Integer call() throws Exception {
        return null;
    }
}
