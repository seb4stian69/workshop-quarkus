package org.domain.values;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor/**/@NoArgsConstructor/**/@Data
public class Price {
    private Integer value;
    public static Price of(Integer value) {return new Price(value);}
}
