package com.baeldung;

public final class GitURL implements Lin {
    public String getData(String URL){
        String[] splitedURL = URL.split("/");
        return "Name: "+splitedURL[3]+" Repo: "+splitedURL[4];
    }
}
