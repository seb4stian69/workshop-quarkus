package org.domain.values;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor/**/@NoArgsConstructor/**/@Data
public class ProductName {
    private String value;
    public static ProductName of(String value) {return new ProductName(value);}
}
