package org.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.domain.values.CardNumber;
import org.domain.values.UserName;
import org.domain.values.identificators.UserID;

@Data/**/@AllArgsConstructor
public class User {

    private UserID userID;
    private UserName name;
    private CardNumber cardNumber;

}
