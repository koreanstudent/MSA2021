package kr.co.msa.msauser.api.user.dto;

import lombok.Data;

@Data
public class OrderRes {

    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Data createdAt;

    private String orderId;

}
