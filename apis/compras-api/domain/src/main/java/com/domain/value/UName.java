package com.domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class UName implements ValueObject<UName.Props> {

    private final String name;
    private final String lastName;

    public UName(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public static UName of(String name, String lastname){
        return new UName(name,lastname);
    }

    @Override
    public UName.Props value() {
        return new UName.Props(){
            @Override
            public String name() {
                return name;
            }
            @Override
            public String lastName() {
                return lastName;
            }
        };
    }

    public interface Props {
        String name();
        String lastName();
    }

}