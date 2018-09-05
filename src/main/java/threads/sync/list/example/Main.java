package threads.sync.list.example;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List list = new List();

        for (int i = 0; i < 10; i++) {
            new Thread(new AddElementToListTask(list, i)).start();
        }

        Thread.sleep(2000);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.getElement(i));
        }

    }
}
