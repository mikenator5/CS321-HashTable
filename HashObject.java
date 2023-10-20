import java.util.Objects;

public class HashObject extends Object {
    Object key;
    private int frequencyCount;
    private int probeCount;

    public int getFrequencyCount() {
        return frequencyCount;
    }

    public void incrementFrequencyCount() {
        this.frequencyCount++;
    }

    public int getProbeCount() {
        return probeCount;
    }

    public void incrementProbeCount() {
        this.probeCount++;
    }

    public HashObject(Object key) {
        this.key = key;
        this.frequencyCount = 0;
        this.probeCount = 0;
    }

    public Object getKey() {
        return this.key;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        HashObject temp = (HashObject) obj;
        return Objects.equals(this.key, temp.key);
    }

    @Override
    public String toString() {
        return this.key + " " + this.getFrequencyCount() + " " + this.getProbeCount();
    }
}
