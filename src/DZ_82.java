import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class DZ_82 {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        Mythred mythred =new Mythred(cdl);
        try {
            cdl.await();
            mythred.sum();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//


    }

    static class Mythred implements Runnable{
        CountDownLatch l;
        private final int [] m = new int[5];

        public Mythred(CountDownLatch l) {
            this.l = l;
            new Thread(this).start();
        }



        public void run() {
            for (int i = 0; i < m.length; i++) {
            Scanner scanner = new Scanner(System.in);
            m[i]=scanner.nextInt();
            l.countDown();
            }
        }

       public void sum(){
            System.out.println("Увеличиваем все в 2 раза");
           for (int i = 0; i < 5; i++) {
               System.out.print(m[i]+" - ");
               m[i]=m[i]*2;
               System.out.print(m[i]);
               System.out.println();
           }

       }
    }}
