package org.domain.values;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor/**/@NoArgsConstructor/**/@Data
public class Quantity {
    private Integer value;
    public static Quantity of(Integer value) {return new Quantity(value);}
}
