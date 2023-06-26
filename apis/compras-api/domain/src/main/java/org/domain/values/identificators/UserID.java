package org.domain.values.identificators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor/**/@NoArgsConstructor/**/@Data
public class UserID {
    String id;
    public static UserID of(String id) {return new UserID(id);}
}
