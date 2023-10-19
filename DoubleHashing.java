public class DoubleHashing extends HashTable{
    public DoubleHashing(int maxSize) {
        super(maxSize);
    }

    private int h1(HashObject x) {
        return positiveMod(x.hashCode(), this.table.length);
    }

    private int h2(HashObject x) {
        return 1 + positiveMod (x.hashCode(), this.table.length - 2);
    }

    @Override
    protected int hash(HashObject x, int i) {
        return (h1(x) + (i * h2(x))) % this.table.length;
    }
}
