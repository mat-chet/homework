package com.company.api;

import com.company.Spare.Key;

public interface ICar {
    boolean open(Key key) throws Exception;
    boolean close(Key key) throws Exception;
    void drive();
    void zajiganie() throws Exception;
    int refuelinh( int v) throws Exception;
    void stop();
}
