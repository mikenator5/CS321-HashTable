public class DoubleHashing extends HashTable{
    public DoubleHashing(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int hash(HashObject x, int i) {
        return (x.hashCode() % this.table.length) + (i * (1 + x.hashCode() % (this.table.length - 1)));
    }
}
