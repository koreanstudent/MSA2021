package kr.co.msa.msacatalog.domain.catalog;

import kr.co.msa.msacatalog.api.catalog.dto.CatalogRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CatalogService {
    private final CatalogRepository catalogRepository;


    public List<CatalogRes> findCatalogs() {
        Iterable<CatalogEntity> catalogList =  catalogRepository.findAll();
        List<CatalogRes> result = new ArrayList<>();

        catalogList.forEach(v -> {
            result.add(new ModelMapper().map(v, CatalogRes.class));
        });

        return result;
    }
}
