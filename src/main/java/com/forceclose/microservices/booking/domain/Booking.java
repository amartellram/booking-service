package com.forceclose.microservices.booking.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import java.io.Serializable;

@Data
public class Booking implements Serializable {
    private static final long serialVersionUID = -3272567875160858412L;
    @Id
    private String id;
    @Valid
    private User user;
    private String restaurantId;
    private String tableId;
    private String registerDate;
    private String registerTime;
}
