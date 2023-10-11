public class LinearProbing extends HashTable {
    public LinearProbing(int maxSize) {
        super(maxSize);
    }

    @Override
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

    @Override
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

    @Override
    protected int hash(HashObject x, int i) {
        return ((x.hashCode() % this.table.length) + i) % this.table.length;
    }
}
