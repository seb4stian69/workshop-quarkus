package com.domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class ImgUrl implements ValueObject<String> {

    private final String url;

    public ImgUrl(String url) {
        this.url = url;
    }

    public static ImgUrl of(String url) {
        return new ImgUrl(url);
    }

    @Override
    public String value() {
        return url;
    }

}