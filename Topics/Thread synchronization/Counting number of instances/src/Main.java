class ClassCountingInstances {

    private static volatile long numberOfInstances;

    public ClassCountingInstances() {
        // write the increment here
        synchronized (ClassCountingInstances.class) {
            numberOfInstances++;
        }
    }

    public static synchronized long getNumberOfInstances() {
        return numberOfInstances;
    }
}
