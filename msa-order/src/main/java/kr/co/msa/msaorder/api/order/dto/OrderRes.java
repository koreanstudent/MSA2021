package kr.co.msa.msaorder.api.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kr.co.msa.msaorder.domain.order.OrderEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRes implements Serializable {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createdAt;
    private String orderId;
    private String userId;

    public OrderRes(OrderEntity entity){
        this.productId = entity.getProductId();
        this.qty = entity.getQty();
        this.unitPrice = entity.getUnitPrice();
        this.totalPrice = entity.getTotalPrice();
        this.createdAt = entity.getCreatedAt();
        this.orderId = entity.getOrderId();
        this.userId = entity.getUserId();
    }

}
