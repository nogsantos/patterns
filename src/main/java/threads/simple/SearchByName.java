package threads.simple;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchByName implements Runnable {

    private String fileName;
    private String name;

    public SearchByName(String fileName, String name) {
        this.fileName = fileName;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() +" ID: "+ Thread.currentThread().getId());
            Scanner scanner = new Scanner(new File("./files/"+fileName));
            int counter = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.matches(name)) {
                    System.out.println(fileName + " - " + counter + " - " + line);
                }
                counter++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
