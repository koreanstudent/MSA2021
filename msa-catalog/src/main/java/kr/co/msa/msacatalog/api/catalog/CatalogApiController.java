package kr.co.msa.msacatalog.api.catalog;

import kr.co.msa.msacatalog.api.catalog.dto.CatalogReq;
import kr.co.msa.msacatalog.domain.catalog.CatalogService;
import kr.co.msa.msacatalog.response.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/catalog-service")
public class CatalogApiController {
    private final CatalogService catalogService;


    /**
     * [사용자] 다건 조회
     */
    @GetMapping("/catalog")
    public ResponseEntity findCatalogs(){
        List<CatalogReq> users = catalogService.findCatalogs();

        return ResponseEntity.ok(Result.success(users));
    }
}
