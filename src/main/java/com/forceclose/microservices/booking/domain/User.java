package com.forceclose.microservices.booking.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 4616731722370097713L;
    @NotNull
    private String id;
    private String fullName;
}
