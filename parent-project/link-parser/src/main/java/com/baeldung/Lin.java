package com.baeldung;

public sealed interface Lin permits GitURL, SOURL {
    default String getData(String URL){
        return "null";
    }
}
