package com.api.name.inditex.repository;

import com.api.name.inditex.entities.PricesDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Prices Repository.
 */
@Repository
public interface PricesRepository extends JpaRepository<PricesDTO, Long> {
  /**
   * Finds data from H2 database for received parameters. The range of date is less than or equal
   * {@param starDate} and greater than or equal {@param starDate}.
   *
   * @param brandId   id of the brand
   * @param productId id of the product
   * @param startDate starting date of range search
   * @param endDate   ending date of range search.
   * @return          an {@link Optional} with a {@link List} of {@link PricesDTO}
   */
  Optional<List<PricesDTO>>
      findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
          Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
}
