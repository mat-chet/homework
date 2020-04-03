package com.company.Spare;

import com.company.api.ILock;

public class Lock implements ILock {
    public final byte key1;
    public final byte key2;
    public final byte kk;

    public boolean open = false;
    public Lock(Key key){

        kk = (byte) (Math.random()*255);

        key1 = (byte)(key.getKey1() ^ kk);
        key2 = (byte)(key.getKey2() ^ kk);
    }

    public boolean open(Key key){
        if((byte)(key.getKey1() ^ kk) == key1  &&  (byte)(key.getKey2() ^ kk) == key2) {
            if(open == true)
                open = false;
            else
                open = true;
            return true;
        }
        return false;
    }
}
