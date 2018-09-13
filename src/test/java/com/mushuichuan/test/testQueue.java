package com.mushuichuan.test;

import com.mushuichuan.MyQueue;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class testQueue {
    @Test
    public void test3(){
        for(int i = 0;i<10;i++){
            test(i);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void test(int s){
        System.out.println(s);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(s* 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(s);
            }
        }){

        }.start();
    }
    @Test
    public void test2(){
        System.out.println(""+(3&-3));
        System.out.println(""+(4&-4));
        System.out.println(""+(5&-5));
        System.out.println(""+(6&-6));
        System.out.println(""+(6&-6));
        System.out.println(""+(7&-7));
        System.out.println(""+(8&-8));
        System.out.println(""+(~3+1));
    }

    @Test
    public void test1() {
        final CountDownLatch latch = new CountDownLatch(1);
//        MyQueue<Integer> queue = new MyQueue(new Integer[10]);
        Queue<Integer> queue = new ArrayBlockingQueue<>(10);
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Producer producer1 = new Producer(queue);
        consumer.start();
        producer.start();
        consumer1.start();
        producer1.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class Consumer extends Thread {
        Queue<Integer> queue;

        public Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                Integer j = queue.poll();
                System.out.println(this.getName()+"----------Consumer:" + j);
            }
        }
    }

    class Producer extends Thread {
        Queue<Integer> queue;

        public Producer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                this.queue.add(i);
                System.out.println(this.getName()+"-----------Producer:" + i);
            }
        }
    }
}
