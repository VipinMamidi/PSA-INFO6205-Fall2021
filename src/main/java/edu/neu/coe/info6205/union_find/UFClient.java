package edu.neu.coe.info6205.union_find;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class UFClient {

   // static Vector[] arr = new Vector[100];
    private static int connectionsGenerated = 0;
    private static UF_HWQUPC uf;

    /**
    private static void generateRandomIntegerPairs(int n){

        for (int i = 0; i < n; i++){
            int randomNumber1 = ThreadLocalRandom .current() .nextInt(1,n );
            int randomNumber2 = ThreadLocalRandom .current() .nextInt(1,n );
            arr[i] = new Vector();
            arr[i].add(randomNumber1);
            arr[i].add(randomNumber2);
        }
    }
    */

    private static int count(int n) {
        connectionsGenerated = 0;
        while (uf.components() !=1 ) {
        for (int i = 0; i < n; i++) {

            int p = ThreadLocalRandom.current().nextInt(0, n);
            int q = ThreadLocalRandom.current().nextInt(0, n);
            connectionsGenerated++;
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
        }
      }
        return  connectionsGenerated;
    }

    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            //int n = Integer.parseInt(args[0]);
            Random rd = new Random();
            int n = rd.nextInt(10000);
            //generateRandomIntegerPairs(n);
            uf = new UF_HWQUPC(n);
            count(n);
            System.out.println("No. of Objects : " + n);
            System.out.println("No. of Connections Generated : " + connectionsGenerated);
            System.out.println("No. of Components : " + uf.components());
            System.out.println("Predicted Pairs Generated : " + (0.5) * n * Math.log(n));
        }
    }
}
