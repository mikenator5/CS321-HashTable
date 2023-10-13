public class HashtableTest {

    int dataSouce;
    double loadFactor;
    int debugLevel;
    public HashtableTest(String[] args) {
        try {
            this.dataSouce = Integer.parseInt(args[0]);
            if (this.dataSouce < 0 || this.dataSouce > 3) {
                printUsageAndExit();
            }

            this.loadFactor = Double.parseDouble(args[1]);

            this.debugLevel = Integer.parseInt(args[2]);
            if (this.debugLevel < 0 || this.debugLevel > 2) {
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

    public static void main(String[] args) {
        HashtableTest t = new HashtableTest(args);

        switch (t.dataSouce) {
            case 1:
                System.out.println("Integer objects");
                break;
            case 2:
                System.out.println("Date objects");
                break;
            case 3:
                System.out.println("String objects");
                break;
        }
    }
}
