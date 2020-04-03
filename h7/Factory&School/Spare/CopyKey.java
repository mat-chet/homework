package com.company.Spare;

public class CopyKey {
    private final byte key1;
    private final byte key2;
    public CopyKey(Key key){
        key1 = key.key1;
        key2 = key.key2;
    }

    public CopyKey(CopyKey key){
        key1 = key.key1;
        key2 = key.key2;
    }
}
