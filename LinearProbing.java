public class LinearProbing extends HashTable {
    public LinearProbing(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int hash(HashObject x, int i) {
        return ((x.hashCode() % this.table.length) + i) % this.table.length;
    }
}
