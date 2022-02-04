package com.fstg.bookerorderservice.infra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer quantity;
    private BigDecimal total;
    private String productRef;
    @ManyToOne
    @JsonIgnore
    private CustomerOrderEntity relatedCustomerOrder;

}
