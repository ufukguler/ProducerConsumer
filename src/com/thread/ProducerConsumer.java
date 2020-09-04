package com.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    Random random = new Random();

    public void produce() {

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            try {
                Integer value = random.nextInt(100);
                queue.put(value);
                System.out.println("Producer produce: " + value);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

    public void consume() {

        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Integer value = queue.take();
                System.out.println("Consumer consumes: " + value);
                System.out.println("Queue size: " + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

