package com.forceclose.microservices.booking.client.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = -3094394250652963721L;
    private String id;
    private String firstName;
    private String lastName;
}
