import java.util.ArrayList;

public abstract class HashTable {
    protected HashObject[] table;
    public HashTable(int maxSize) {
        this.table = new HashObject[maxSize];
    }
    protected abstract int hash(HashObject x, int i);

    public HashObject search(HashObject k) {
        int i = 0;
        int probe;
        do {
            probe = hash(k, i);
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
            int probe = hash(x, i);
            if (this.table[probe] == null) {
                this.table[probe] = x;
                return probe;
            } else {
                i++;
            }
        } while (i == this.table.length);
        return -1;
    }

    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
            quotient += divisor;
        return quotient;
    }

}
