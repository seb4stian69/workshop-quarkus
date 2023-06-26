package org.domain.values;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor/**/@NoArgsConstructor/**/@Data
public class UserName {
    private String value;
    public static UserName of(String value) {return new UserName(value);}
}
