package models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Payment extends  BaseModel{

    private int refNum;
    private Bill bill;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private int amount;
}
