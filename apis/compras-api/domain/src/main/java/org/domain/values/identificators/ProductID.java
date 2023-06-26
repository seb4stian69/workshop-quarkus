package org.domain.values.identificators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor/**/@NoArgsConstructor/**/@Data
public class ProductID {
    String id;
    public static ProductID of(String id) {return new ProductID(id);}
}
