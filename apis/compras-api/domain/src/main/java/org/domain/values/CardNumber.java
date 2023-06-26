package org.domain.values;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor/**/@NoArgsConstructor/**/@Data
public class CardNumber {
    private Integer value;
    public static CardNumber of(Integer value) {return new CardNumber(value);}
}
