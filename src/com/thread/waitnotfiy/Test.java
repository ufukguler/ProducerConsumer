package com.thread.waitnotfiy;

import com.thread.waitnotfiy.ProducerConsumer;

public class Test {
    public static void main(String[] args) {

        ProducerConsumer pc = new ProducerConsumer();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                pc.produce();
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                pc.consume();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
}
