import java.util.ArrayList;

public abstract class HashTable {
    protected HashObject[] table;
    private int size;
    public HashTable(int maxSize) {
        this.table = new HashObject[maxSize];
        this.size = 0;
    }
    protected abstract int hash(int x, int i);

    public HashObject search(HashObject k) {
        int i = 0;
        int probe;
        do {
            probe = hash(k.hashCode(), i);
            if (this.table[probe] == k) {
                return this.table[probe];
            } else {
                i++;
            }
        } while (i == this.table.length || this.table[probe] == null);
        return null;
    }

    public int insert(HashObject x) {
        int i = 0;
        do {
            int probe = hash(x.hashCode(), i);
            if (this.table[probe] == null) {
                this.table[probe] = x;
                this.size++;
                return probe;
            } else {
                if (this.table[probe].equals(x)) {
                    this.table[probe].incrementFrequencyCount();
                } else {
                    this.table[probe].incrementProbeCount();
                    i++;
                }
            }
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
}
