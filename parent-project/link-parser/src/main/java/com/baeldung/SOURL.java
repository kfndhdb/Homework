package com.baeldung;

public final class SOURL implements Lin {
    public String getData(String URL){
        return URL.split("/")[4];
    }
}
