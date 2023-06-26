package org.domain.values;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor/**/@NoArgsConstructor/**/@Data
public class ImgUrl {
    private String value;
    public static ImgUrl of(String value) {return new ImgUrl(value);}
}
