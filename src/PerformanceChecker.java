public class PerformanceChecker {
    public PerformanceChecker(){

    }
    public void start(Callback callback){
        long start = System.currentTimeMillis();
        callback.start();
        long end = System.currentTimeMillis();
        System.out.println("TIME : " + (end-start));
    }
}
interface Callback {
    void start();
}
