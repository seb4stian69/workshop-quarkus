package org.domain.values.identificators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor/**/@NoArgsConstructor/**/@Data
public class BuyID {
    String id;
    public static BuyID of(String id) {return new BuyID(id);}
}
