public class PerformanceChecker {
    public PerformanceChecker(){

    }

    public void start(Callback callback){
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println("TIME : " + (end-start));
    }
}

interface Callback {
    public void start();
}
