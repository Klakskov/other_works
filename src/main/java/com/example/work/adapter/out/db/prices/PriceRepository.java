package com.example.work.adapter.out.db.prices;

import com.example.work.adapter.domain.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("""
                SELECT p FROM PriceEntity p
                WHERE p.productId = :productId
                  AND p.brandId = :brandId
                  AND :applicationDate BETWEEN p.startDate AND p.endDate
                ORDER BY p.priority DESC
                   LIMIT 1
            """)
    PriceEntity findApplicablePrices(
            @Param("applicationDate") LocalDateTime applicationDate,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId
    );
}
