public abstract class Worker<T> implements Runnable {

    protected int start, end;

    public void setPartitions(int start,int end) {
        this.start = start;
        this.end = end;
    }

    public abstract void toRun(int start, int end);
    public abstract void info();
    @Override
    public void run() {
        toRun(this.start,this.end);
    }
}
