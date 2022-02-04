package com.fstg.bookerorderservice.infra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String shipToAddress;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate shipToDate;
    private String sellerRef;
    private String buyerRef;
    private BigDecimal orderAmount;
    private BigDecimal totalPaid;
    @ManyToOne
    private OrderStatusEntity status;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "relatedCustomerOrder")
    private List<OrderItemEntity> orderItems;
}
