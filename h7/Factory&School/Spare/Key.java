package com.company.Spare;

public class Key {
    final byte key1;
    final byte key2;

    public byte getKey1() {
        return key1;
    }

    public byte getKey2() {
        return key2;
    }

    public Key() {
        this.key1 = (byte) (Math.random()*255.0);
        this.key2 = (byte) (Math.random()*255.0);
    }
}
