public class LinearProbing extends HashTable {
    public LinearProbing(int maxSize) {
        super(maxSize);
    }

    private int h1(int x) {
        return positiveMod(x, this.table.length);
    }

    @Override
    protected int hash(int x, int i) {
        return (h1(x) + i) % this.table.length;
    }
}
