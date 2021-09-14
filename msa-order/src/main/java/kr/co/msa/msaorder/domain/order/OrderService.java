package kr.co.msa.msaorder.domain.order;

import kr.co.msa.msaorder.api.order.dto.OrderReq;
import kr.co.msa.msaorder.api.order.dto.OrderRes;
import kr.co.msa.msaorder.api.order.dto.OrderSaveReq;
import kr.co.msa.msaorder.exception.BusinessException;
import kr.co.msa.msaorder.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;


    public Long saveOrder(OrderSaveReq saveReq) {
        saveReq.setTotalPrice(saveReq.getUnitPrice() * saveReq.getQty());
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderEntity orderEntity = modelMapper.map(saveReq, OrderEntity.class);

        return orderRepository.save(orderEntity).getId();
    }
    public OrderRes getOrderByOrderId(String orderId) {
//        Optional<OrderEntity> orderEntity = orderRepository.findByOrderId(orderId);
//        OrderRes result = modelMapper.map(orderEntity,OrderRes.class);

        return  orderRepository.findByOrderId(orderId)
                .map(OrderRes::new)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_USER));

    }

    public List<OrderRes> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId)
                .stream().map(OrderRes::new).collect(Collectors.toList());

    }


}
