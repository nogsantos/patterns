package threads.sync.list.example;

/**
 * Shared object
 */
public class List {

    private String[] elements = new String[1000];
    private int indice = 0;

    public synchronized void addElement(String element) {
        elements[indice] = element;
        indice++;
    }

    public int size() {
        return elements.length;
    }

    public String getElement(int position) {
        return elements[position];
    }

}
