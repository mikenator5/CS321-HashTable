public class DoubleHashing extends HashTable{
    public DoubleHashing(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int hash(HashObject x, int i) {
        return 1 + positiveMod(x.hashCode(), this.table.length - 2) % this.table.length;
    }
}
