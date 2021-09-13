package kr.co.msa.msacatalog.domain.catalog;

import kr.co.msa.msacatalog.api.catalog.dto.CatalogReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class CatalogService {
    private final CatalogRepository catalogRepository;


    public List<CatalogReq> findCatalogs() {
        Iterable<CatalogEntity> catalogList =  catalogRepository.findAll();
        List<CatalogReq> result = new ArrayList<>();

        catalogList.forEach(v -> {
            result.add(new ModelMapper().map(v,CatalogReq.class));
        });

        return result;
    }
}
