package threads.simple;

public class Main {

    public static void main(String[] args) {
        /*
         * \\s - means whitespace, a space or a tab
         * \\w - means word, a character or a number
         */
        String lookingFor = "(Dan|Martin)(\\s|\\w)*";

        Thread author = new Thread(new SearchByName("autores.txt", lookingFor), "First");
        Thread signing = new Thread(new SearchByName("assinaturas1.txt", lookingFor), "Sec");
        Thread signing2 = new Thread(new SearchByName("assinaturas2.txt", lookingFor), "Third");

//        System.out.println(Thread.currentThread().getName() +" "+ author.getId());
        author.start();
//        System.out.println(Thread.currentThread().getName() +" "+signing.getId());
        signing.start();
//        System.out.println(Thread.currentThread().getName() +" "+signing2.getId());
        signing2.run();
    }

}
