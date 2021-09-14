package kr.co.msa.msaorder.api.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kr.co.msa.msaorder.domain.order.OrderEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderReq implements Serializable {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
}
