package kr.co.msa.msaorder.api.order;

import kr.co.msa.msaorder.api.order.dto.OrderReq;
import kr.co.msa.msaorder.api.order.dto.OrderRes;
import kr.co.msa.msaorder.api.order.dto.OrderSaveReq;
import kr.co.msa.msaorder.domain.order.OrderService;
import kr.co.msa.msaorder.response.Result;
import kr.co.msa.msaorder.utill.HttpUtill;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order-service")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{userId}/orders")
    public ResponseEntity findOrders(@PathVariable("userId") String userId){
        List<OrderRes> result = orderService.getOrdersByUserId(userId);

        return ResponseEntity.ok(Result.success(result));
    }

    @PostMapping("/{userId}/order")
    public ResponseEntity saveOrder(@PathVariable("userId") String userId, @RequestBody OrderSaveReq orderReq) throws URISyntaxException {
        orderReq.setUserId(userId);
        Long id = orderService.saveOrder(orderReq);

        return ResponseEntity.created(HttpUtill.getCurrentUri(id))
                .body(Result.success());
    }


}
