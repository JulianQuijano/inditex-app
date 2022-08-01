package com.api.name.inditex.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * The response object for the endpoint "brand/{brandId}/product/{productId}/price".
 * @see com.api.name.inditex.controllers.PriceController#getPriceByBrandProductAndStartDate(Long, Long, LocalDateTime)
 * getPriceByBrandProductAndStartDate(Long,Long,LocalDateTime)
 */
@Data
@Builder
public class PricesResponse {
  @JsonProperty("product_id")
  private Long productId;

  @JsonProperty("brand_id")
  private Long brandId;

  @JsonProperty("price_list")
  private Integer priceList;

  @JsonProperty("date_time")
  private LocalDateTime dateTime;

  private BigDecimal price;

  private String curr;
}
