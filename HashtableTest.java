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
    static HashTable linearProbing;
    static HashTable doubleHashing;
    static int linearDuplicateCount, doubleDuplicateCount = 0;
    private static void handleArgsAndSetup(String[] args) {
        try { // TODO The program should, by default, use debug level 0 if the debug level wasn’t specified on the command line.
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

    private static void printTestResults() {
        int elementCount = 0;
        int probeCount = 0;
        for (HashObject x : linearProbing.table) {
            if (x == null) {
                continue;
            }
            elementCount += x.getFrequencyCount();
            probeCount += x.getProbeCount();
        }
        System.out.println("\tUsing Linear Probing");
        System.out.printf("HashtableTest: size of hashtable is %d\n", linearProbing.getSize());
        System.out.printf("\t Inserted %d elements, of which %d were duplicates\n", elementCount, linearDuplicateCount);
        System.out.printf("\t Avg. no. of probes %.2f\n", (double) probeCount / linearProbing.getSize());
        System.out.println();
        elementCount = 0;
        probeCount = 0;
        for (HashObject x : doubleHashing.table) {
            if (x == null) {
                continue;
            }
            elementCount += x.getFrequencyCount();
            probeCount += x.getProbeCount();
        }
        System.out.println("\tUsing Double Hashing");
        System.out.printf("HashtableTest: size of hashtable is %d\n", doubleHashing.getSize());
        System.out.printf("\t Inserted %d elements, of which %d were duplicates\n", elementCount, linearDuplicateCount);
        System.out.printf("\t Avg. no. of probes %.2f\n", (double) probeCount / doubleHashing.getSize());
    }

    private static void integerTest() {
        Random r = new Random();
        for (int i = 0; i < Math.ceil(primes[1] * loadFactor); i++) {
            HashObject tmp = new HashObject(r.nextInt());
            linearProbing.insert(tmp);
            doubleHashing.insert(tmp);
        }
    }

    private static void dateTest() {
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
        Scanner scanner;
        try {
            scanner = new Scanner(new File("word-list.txt"));
        } catch (FileNotFoundException e) {
            return;
        }

        while (linearProbing.getSize() < Math.ceil(primes[1] * loadFactor) && doubleHashing.getSize() < Math.ceil(primes[1] * loadFactor)) {
            String str = scanner.next();
            HashObject tmp = new HashObject(str);
            int res = linearProbing.insert(tmp);
            if (res < 0) {
                linearDuplicateCount++;
            }

            res = doubleHashing.insert(tmp);
            if (res < 0) {
                doubleDuplicateCount++;
            }
        }
    }

    public static void main(String[] args) {
        handleArgsAndSetup(args);

        primes = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        if (primes == null) {
            System.exit(1);
        }

        linearProbing = new LinearProbing(primes[1]);
        doubleHashing = new DoubleHashing(primes[1]);

        System.out.printf("HashtableTest: Found a twin prime table capacity: %d\n", primes[1]);
        System.out.print("HashtableTest: Input: ");
        switch (dataSource) {
            case 1:
                System.out.printf("Integer  Load factor: %.2f\n", loadFactor);
                integerTest();
                break;
            case 2:
                System.out.printf("Date  Load factor: %.2f\n", loadFactor);
                dateTest();
                break;
            case 3:
                System.out.printf("Word-List  Load factor: %.2f\n", loadFactor);
                stringTest();
                break;
        }

        printTestResults();
    }
}
