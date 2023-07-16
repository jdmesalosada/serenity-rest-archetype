package com.jmconsultant.starter.models.data;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserData {
    private Integer id;
    private String name;
    private String lastName;

    public UserData(Integer id, String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

}
