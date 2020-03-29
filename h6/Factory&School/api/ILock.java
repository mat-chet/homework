package com.company.api;

import com.company.Spare.Key;

public interface ILock {
    boolean open(Key key);
}
