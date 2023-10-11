import java.util.ArrayList;

public abstract class HashTable {
    protected HashObject[] table;
    public HashTable(int maxSize) {
        this.table = new HashObject[maxSize];
    }
    public abstract HashObject search(HashObject k);
    public abstract int insert(HashObject x);
    protected abstract int hash(HashObject x, int i);
}
