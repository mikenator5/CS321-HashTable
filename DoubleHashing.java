public class DoubleHashing extends HashTable{
    public DoubleHashing(int maxSize) {
        super(maxSize);
    }

    private int h1(int x) {
        return positiveMod(x, this.table.length);
    }

    private int h2(int x) {
        return 1 + positiveMod (x, this.table.length - 2);
    }

    @Override
    protected int hash(int x, int i) {
        return (h1(x) + (i * h2(x))) % this.table.length;
    }
}
