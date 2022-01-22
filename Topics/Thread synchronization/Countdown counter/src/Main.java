/*
 * Copyright © Bowen Wu 2020.
 * All rights reserved.
 */

class CountDownCounter {

    int count;

    public CountDownCounter(int initial) {
        this.count = initial;
    }

    public synchronized void decrement() {
        count--;
    }
}
