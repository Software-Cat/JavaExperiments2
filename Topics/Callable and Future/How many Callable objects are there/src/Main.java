import java.util.concurrent.Callable;


class FutureUtils {

    public static <T> int determineCallableDepth(Callable<T> callable) throws Exception {
        T returnedObject = callable.call();

        if (returnedObject instanceof Callable<?> returnedCallable) {
            return determineCallableDepth(returnedCallable) + 1;
        } else {
            return 1;
        }
    }

//    public static int determineCallableDepth(Callable<?> callable) throws Exception {
//        Object returnedObject = callable.call();
//
//        if (returnedObject instanceof Callable<?> returnedCallable) {
//            return determineCallableDepth(returnedCallable) + 1;
//        } else {
//            return 1;
//        }
//    }

//    public static int determineCallableDepth(Callable<?> callable) throws Exception {
//        int counter = 1;
//
//        Object callableResult = callable.call();
//
//        while (callableResult instanceof Callable<?> nestedCallable) {
//            callable = nestedCallable;
//            counter++;
//            callableResult = callable.call();
//        }
//
//        return counter;
//    }

//    public static void main(String[] args) throws Exception {
//        System.out.println(determineCallableDepth(() -> new Callable<>() {
//            @Override
//            public Object call() throws Exception {
//                return new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                };
//            }
//        }));
//    }
}
