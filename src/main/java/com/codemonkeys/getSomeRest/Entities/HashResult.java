package com.codemonkeys.getSomeRest.Entities;

public class HashResult {

    private long timeOfHashing;
    private String hashingAlgorithmUsed;
    private String hash;

    public HashResult(long timeOfHashing, String hashingAlgorithmUsed, String hash) {
        this.timeOfHashing = timeOfHashing;
        this.hashingAlgorithmUsed = hashingAlgorithmUsed;
        this.hash = hash;
    }

    public long getTimeOfHashing() {
        return timeOfHashing;
    }

    public void setTimeOfHashing(long timeOfHashing) {
        this.timeOfHashing = timeOfHashing;
    }

    public String getHashingAlgorithmUsed() {
        return hashingAlgorithmUsed;
    }

    public void setHashingAlgorithmUsed(String hashingAlgorithmUsed) {
        this.hashingAlgorithmUsed = hashingAlgorithmUsed;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}
