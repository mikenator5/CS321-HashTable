public class LinearProbing extends HashTable {
    public LinearProbing(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int hash(HashObject x, int i) {
        return positiveMod(x.hashCode(), this.table.length);
    }
}
