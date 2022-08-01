package com.api.name.inditex.controllers;

import static com.api.name.inditex.configs.Const.PATTERN;
import static org.springframework.http.HttpStatus.OK;

import com.api.name.inditex.entities.PricesResponse;
import com.api.name.inditex.services.PriceService;
import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Price controller.
 */
@RestController
@RequestMapping(path = "brand/{brandId}")
public class PriceController {
  private final PriceService priceService;

  /**
   * @param priceService price service dependency injection.
   */
  @Autowired
  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }

  /**
   * Get Prices data for request parameters.
   *
   * @param brandId   id of the brand
   * @param productId id of the product
   * @param dateTime  price application date
   * @return          an {@link ResponseEntity} with a {@link PricesResponse} or {@link ResponseEntity#notFound()}
   */
  @GetMapping(path = "/product/{productId}/price")
  public ResponseEntity<PricesResponse> getPriceByBrandProductAndStartDate(
      @PathVariable("brandId") @NotNull Long brandId,
      @PathVariable("productId") @NotNull Long productId,
      @RequestParam("date_time") @DateTimeFormat(pattern = PATTERN) @NotNull
          LocalDateTime dateTime) {

    Optional<PricesResponse> response =
        priceService.getPriceByBrandProductAndStartDate(brandId, productId, dateTime);

    return response
        .map(
            pricesResponse ->
                ResponseEntity.status(OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(pricesResponse))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
