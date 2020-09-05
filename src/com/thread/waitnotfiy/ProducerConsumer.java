package com.thread.waitnotfiy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {
    Random random = new Random();
    Object lock = new Object();
    Queue<Integer> queue = new LinkedList<Integer>();
    private int limit = 10;

    public void produce() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getStackTrace());
            }
            synchronized (lock) {
                if (queue.size() == limit) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getStackTrace());
                    }
                }
                Integer value = random.nextInt(50);
                queue.offer(value);
                System.out.println("Producer produce : " + value);
                lock.notify();
            }
        }
    }

    public void consume() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getStackTrace());
            }
            synchronized (lock) {
                if (queue.size() == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getStackTrace());
                    }
                }
                Integer value = queue.poll();
                System.out.println("Consumer consumes : " + value);
                System.out.println("Queue size : " + queue.size());
                lock.notify();
            }
        }
    }
}