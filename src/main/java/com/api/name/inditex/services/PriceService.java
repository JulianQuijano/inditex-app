package com.api.name.inditex.services;

import com.api.name.inditex.entities.PricesDTO;
import com.api.name.inditex.entities.PricesResponse;
import com.api.name.inditex.repository.PricesRepository;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Price service.
 */
@Service
public class PriceService {

  private final PricesRepository pricesRepository;

  /**
   * @param pricesRepository price repository dependency injection.
   */
  @Autowired
  public PriceService(PricesRepository pricesRepository) {
    this.pricesRepository = pricesRepository;
  }

  /**
   * Get Prices for a productId, brandId and date time selected.
   *
   * @param brandId   id of the brand
   * @param productId id of the product
   * @param dateTime  price application date
   * @return          an {@link Optional} with a {@link PricesResponse} or {@link Optional#empty()}
   */
  public Optional<PricesResponse> getPriceByBrandProductAndStartDate(
      Long brandId, Long productId, LocalDateTime dateTime) {
    Optional<List<PricesDTO>> pricesResponse =
        pricesRepository
            .findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                brandId, productId, dateTime, dateTime);
    Optional<PricesResponse> response = Optional.empty();

    if (pricesResponse.isPresent() && !pricesResponse.get().isEmpty()) {
      Optional<PricesDTO> highPriorityPrice =
          pricesResponse.get().stream().max(Comparator.comparing(PricesDTO::getPriority));

      response =
          Optional.of(
              PricesResponse.builder()
                  .productId(highPriorityPrice.get().getProductId())
                  .brandId(highPriorityPrice.get().getBrandId())
                  .priceList(highPriorityPrice.get().getPriceList())
                  .dateTime(dateTime)
                  .price(highPriorityPrice.get().getPrice())
                  .curr(highPriorityPrice.get().getCurr())
                  .build());
    }
    return response;
  }
}
