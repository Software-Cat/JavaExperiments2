class ThreadUtil {

    static void printNameOfTerminatedThread(Thread[] threads) {
        for (Thread t : threads) {
            if (t.getState() == Thread.State.TERMINATED) {
                System.out.println(t.getName());
            }
        }
    }
}
