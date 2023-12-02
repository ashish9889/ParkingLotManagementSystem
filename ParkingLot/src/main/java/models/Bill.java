package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class Bill extends  BaseModel{

    private int billNumber;
    private Ticket ticket;
    private Date exitTime;
    private int amount;
    private BillingStrategy appliedbillingStrategy;
    private List<Payment> payments;
    private BillStatus billStatus;


}
