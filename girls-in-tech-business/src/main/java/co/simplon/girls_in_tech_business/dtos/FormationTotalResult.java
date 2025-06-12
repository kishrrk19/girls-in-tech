package co.simplon.girls_in_tech_business.dtos;

import org.springframework.data.domain.Page;

import java.util.List;

public record FormationTotalResult(
        List<FormationSearchResult> data,
        Long total,
        int currentPage,
        int pageSize
        ) {
}
