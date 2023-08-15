package com.example.tacocloud.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder implements Serializable {

    private Long id;

    @Serial
    private static final long serialVersionUID = 1L;

    private Date placedAt;

//    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

//    @NotBlank(message = "Street is required")
    private String deliveryStreet;

//    @NotBlank(message = "City is required")
    private String deliveryCity;

//    @NotBlank(message = "State is required")
    private String deliveryState;

//    @NotBlank(message = "Zip Code is required")
    private String deliveryZip;

//    @CreditCardNumber(message = "Not a valid card number")
    private String ccNumber;

//    @Pattern(regexp = "^(0[1-9]|1[0-2]([\\/])([2-9][0-9])$)",
//                        message = "Must be formatted MM/YY")
    private String ccExpiration;

//    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
