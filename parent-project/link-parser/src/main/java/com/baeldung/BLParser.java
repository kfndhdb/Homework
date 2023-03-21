package com.baeldung;

public record BLParser(String URL) {
    public String getData(){
        if (!(URL.contains("https://github.com/") || URL.contains("https://stackoverflow.com/questions/"))){
            return "null";
        }
        else {
            Lin[] links = {new SOURL(), new GitURL()};
            int link_type = URL.contains("https://github.com/") ? 1:0;
            return links[link_type].getData(URL);
        }
    }
}
