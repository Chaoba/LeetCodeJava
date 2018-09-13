package com.mushuichuan;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue<T> {
    int totalCount;
    T[] content;
    Lock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();
    AtomicInteger count = new AtomicInteger(0);
    int top = 0;
    int tail = 0;

    public MyQueue(T[] content) {
        this.content = content;
        totalCount = content.length;
    }

    public boolean put(T t) {
        lock.lock();

        try {
            if (totalCount <= count.get()) {
//                System.out.println("Queue is full, wait");
                notFull.await();
            }
            if (tail >= totalCount) {
                tail = 0;
            }
            content[tail++] = t;
//            System.out.println("put one in queue:"+count.get());
            count.getAndIncrement();
            notEmpty.signal();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return false;
    }

    public T get() {
        lock.lock();
        T result = null;

        try {
            if (count.get() <= 0) {
//                System.out.println("no content in queue, wait");
                notEmpty.await();
            }
            if (top == totalCount) {
                top = 0;
            }
            result = content[top++];
//            System.out.println("get one in queue"+count.get());
            count.getAndDecrement();
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return result;
    }
}
