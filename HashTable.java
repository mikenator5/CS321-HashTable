import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class HashTable {
    protected HashObject[] table;
    private int size;
    public HashTable(int maxSize) {
        this.table = new HashObject[maxSize];
        this.size = 0;
    }
    protected abstract int hash(int x, int i);

    public int search(HashObject k) {
        int i = 0;
        int probe;
        do {
            probe = hash(k.key.hashCode(), i);
            if (this.table[probe].equals(k)) {
                return probe;
            } else {
                i++;
            }
        } while (this.table[probe] == null || i == this.table.length);
        return -1;
    }

    public int insert(HashObject x) {
        int i = 0;
        do {
            int probe = hash(x.key.hashCode(), i);
            if (this.table[probe] == null) {
                this.table[probe] = x;
                this.table[probe].incrementFrequencyCount();
                this.table[probe].incrementProbeCount(i);
                this.size++;
                return probe;
            }
            if (this.table[probe].equals(x)) {
                this.table[probe].incrementFrequencyCount();
                return -1;
            }

            i++;

        } while (i < this.table.length);
        return -1;
    }

    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
            quotient += divisor;
        return quotient;
    }

    public int getSize() {
        return size;
    }

    public void dumpToFile(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] == null) {
                continue;
            }
            HashObject a = this.table[i];
            out.printf("table[%d]: %s\n", i, a.toString());
        }
        out.close();
    }
}
