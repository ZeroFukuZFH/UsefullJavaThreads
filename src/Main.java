import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main<T> {
    public static void main(String[] args) {

        PerformanceChecker performanceChecker = new PerformanceChecker();
        performanceChecker.start(()->{
            int threadCount = 3;
            ThreadSplitter<String> threadSplitter = new ThreadSplitter<>(threadCount);

            // INITIAL BUFFERED READER
            ArrayList<String> lines = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader("/Users/mnsin12/IdeaProjects/UsefulThreads/src/LoremIpsum.txt"));
                String line;

                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e){
                System.out.println("FILE NOT FOUND");
            }

            threadSplitter.start(new StringWorker(lines),lines.size());
        });
    }
}


// SAMPLE CLASS
class StringWorker extends Worker<String> {
    private final ArrayList<String> stringArrayList;
    private int count;
    public StringWorker(ArrayList<String> stringArrayList) {this.stringArrayList = stringArrayList;}
    @Override
    public void toRun(int start, int end) {
        for(int i = start; i < end; i++){
            this.count += this.stringArrayList.get(i).trim().split("\\s+").length;
        }
        info();
    }

    @Override
    public void info() {
        // LEAVE EMPTY IF YOU DON'T WANT TO USE
        System.out.println("Thread result :" + this.count);
    }
}
