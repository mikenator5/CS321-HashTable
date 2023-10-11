public class HashObject extends Object {
    Object key;
    int frequencyCount;
    int probeCount;

    public int getFrequencyCount() {
        return frequencyCount;
    }

    public void incrementFrequencyCount() {
        this.frequencyCount++;
    }

    public int getProbeCount() {
        return probeCount;
    }

    public void incrementProbeCount(int probeCount) {
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
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "HashObject{" +
                "key=" + key +
                ", frequencyCount=" + frequencyCount +
                ", probeCount=" + probeCount +
                '}';
    }
}
