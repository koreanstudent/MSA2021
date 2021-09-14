package kr.co.msa.msaorder.domain.order;

import com.netflix.appinfo.ApplicationInfoManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByUserId(String userId);

    Optional<OrderEntity> findByOrderId(String userId);
}
