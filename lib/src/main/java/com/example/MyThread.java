package com.example;

/**
 * Created by EG on 2017/10/24.
 */

public class MyThread extends Thread {

    public static int num = 0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    MyThread(){

    }

    MyThread(String name){
        super(name);
    }
    public static int sum(int n){
        num =  0;
        for(int i = 0; i <= n; i++){
            num += i;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    @Override
    public void run() {
        System.out.println(sum(100));
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        for(int i=0;i<10;i++){
            new Thread(thread,"").start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
