class ThreadProcessor {

    private static Thread threadToStart;

    public static void findAndStartThread(Thread... threads) throws InterruptedException {
        for (Thread thread : threads) {
            if (thread.getState() == Thread.State.NEW) {
                threadToStart = thread;
            }
        }

        threadToStart.start();
        threadToStart.join();
    }
}
