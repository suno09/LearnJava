package dz.sundev.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private String userId;
    private String type;
    private Double amount;

    private CreditCard creditCard;
}