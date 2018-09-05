package threads.sync.list.example;

public class AddElementToListTask implements Runnable {

    private List list;
    private int threadId;

    public AddElementToListTask(List list, int threadId) {
        this.list = list;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            list.addElement(" Thread "+ threadId + " adding element " + i);
        }
    }
}
