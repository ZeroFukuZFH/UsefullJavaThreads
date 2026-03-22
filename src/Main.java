
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        new PerformanceChecker().start(()->{
            ArrayList<String> lines = new ArrayList<>();
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader("/Users/mnsin12/IdeaProjects/UsefulThreads/src/LoremIpsum.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                reader.close();


            } catch (IOException e){
                System.out.println("FILE NOT FOUND" + e.getMessage());

            }
            int threadCount = 8;

            ThreadSplitter<String> threadSplitter = new ThreadSplitter<>(threadCount);
            threadSplitter.start(new StringWorker(lines),lines.size());


        });
    }
}


// SAMPLE CLASS
class StringWorker extends Worker<String> {
    private final ArrayList<String> stringArrayList;
    private int count;
    public StringWorker(ArrayList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
        this.count = 0;
    }
    @Override
    public void toRun(int start, int end) {
        for(int i = start; i < end; i++){
            this.count += this.stringArrayList.get(i).trim().split("\\s+").length;
        }
        System.out.println("Thread : " + this.count);
    }

}
