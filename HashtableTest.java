import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class HashtableTest {

    static int dataSource;
    static double loadFactor;
    static int debugLevel;
    static int[] primes;

    private static void handleArgsAndSetup(String[] args) {
        try {
            dataSource = Integer.parseInt(args[0]);
            if (dataSource < 0 || dataSource > 3) {
                printUsageAndExit();
            }

            loadFactor = Double.parseDouble(args[1]);

            debugLevel = Integer.parseInt(args[2]);
            if (debugLevel < 0 || debugLevel > 2) {
                printUsageAndExit();
            }
        } catch (NumberFormatException e) {
            printUsageAndExit();
        }
    }

    private static void printUsageAndExit() {
        System.out.println("""
                Usage: java HashtableTest <dataType> <loadFactor> [<debugLevel>]
                       <dataSource>: 1 ==> random numbers
                                     2 ==> date value as a long
                                     3 ==> word list
                       <loadFactor>: The ratio of objects to table size,\s
                                       denoted by alpha = n/m
                       <debugLevel>: 0 ==> print summary of experiment
                                     1 ==> save the two hash tables to a file at the end
                                     2 ==> print debugging output for each insert
                """);
        System.exit(1);
    }

    private static void integerTest() {
        HashTable linearProbing = new LinearProbing(primes[1]);
        HashTable doubleHashing = new DoubleHashing(primes[1]);
        Random r = new Random();
        for (int i = 0; i < Math.ceil(primes[1] * loadFactor); i++) {
            HashObject tmp = new HashObject(r.nextInt());
            linearProbing.insert(tmp);
            doubleHashing.insert(tmp);
        }
    }

    private static void dateTest() {
        HashTable linearProbing = new LinearProbing(primes[1]);
        HashTable doubleHashing = new DoubleHashing(primes[1]);
        long current = new Date().getTime();
        for (int i = 0; i < Math.ceil(primes[1] * loadFactor); i++) {
            Date date = new Date(current);
            HashObject tmp = new HashObject(date);
            linearProbing.insert(tmp);
            doubleHashing.insert(tmp);
            current += 1000;
        }
    }

    private static void stringTest() {
        HashTable linearProbing = new LinearProbing(primes[1]);
        HashTable doubleHashing = new DoubleHashing(primes[1]);

        Scanner scanner;
        try {
            scanner = new Scanner(new File("word-list.txt"));
        } catch (FileNotFoundException e) {
            return;
        }
        for (int i = 0; i < Math.ceil(primes[1] * loadFactor); i++) {
            String str = scanner.next();
            HashObject tmp = new HashObject(str);
            linearProbing.insert(tmp);
            doubleHashing.insert(tmp);
        }
    }

    public static void main(String[] args) {
        handleArgsAndSetup(args);

        primes = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        if (primes == null) {
            System.exit(1);
        }

        System.out.printf("HashtableTest: Found a twin prime table capacity: %d\n", primes[1]);
        System.out.print("HashtableTest: Input: ");
        switch (dataSource) {
            case 1:
                System.out.printf("Integer  Load factor: %.2f\n", loadFactor);
                integerTest();
                break;
            case 2:
                System.out.println("Date objects");
                dateTest();
                break;
            case 3:
                System.out.println("String objects");
                stringTest();
                break;
        }
    }
}
