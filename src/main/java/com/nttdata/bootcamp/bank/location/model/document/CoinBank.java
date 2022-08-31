package com.nttdata.bootcamp.bank.location.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="customer")
public class CoinBank
{
    @Id
    private String id;
    private String Imei;
    private String Customer;
    private String NameFirst;
    private String NameSecond;
    private String description;
    private Date operationDate;
    private Double balanceCurrent;
    private Double balanceMove;
    private Double balanceNew;
    private String code; // code 6 is for coinbank
}
