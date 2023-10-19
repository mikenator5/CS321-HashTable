public class LinearProbing extends HashTable {
    public LinearProbing(int maxSize) {
        super(maxSize);
    }

    private int h1(HashObject x) {
        return positiveMod(x.hashCode(), this.table.length);
    }

    @Override
    protected int hash(HashObject x, int i) {
        return (h1(x) + i) % this.table.length;
    }
}
