package com.baeldung;
import reactor.core.publisher.Mono;

import java.net.URISyntaxException;
public sealed interface Lin permits  GitURL, SOURL {
    public default String getData(String URL) throws URISyntaxException {
        return "null";
    }
    default Mono<String> getAllLinks(String URL) throws URISyntaxException {
        return null;
    }
}
