
public class ThreadSplitter<T>{
    private final Thread[] threads;
    int threadCount;
    public ThreadSplitter(int threadCount){
        this.threadCount = threadCount;
        this.threads = new Thread[threadCount];
    }
    public void start(Worker<T> worker,int length){

        int partition = length / this.threadCount;
        int remainder = length % this.threadCount;

        int start = 0;
        Runnable[] runnable = new Runnable[this.threadCount];

        for(int i = 0; i < this.threadCount; i++){
            int end = start + partition + (i < remainder ? 1 : 0);
            worker.setPartitions(start,end);
            runnable[i] = worker;
            this.threads[i] = new Thread(runnable[i]);
            this.threads[i].start();
        }

        for(int i = 0; i < this.threadCount; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}