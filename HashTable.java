import java.util.ArrayList;

public abstract class HashTable {
    protected HashObject[] table;
    public HashTable(int maxSize) {
        this.table = new HashObject[maxSize];
    }
    public abstract Object search(Object k);
    public abstract int insert(Object x);
}
