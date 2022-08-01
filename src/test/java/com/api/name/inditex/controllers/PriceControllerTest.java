package com.api.name.inditex.controllers;

import static com.api.name.inditex.configs.Const.PATTERN;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.api.name.inditex.entities.PricesResponse;
import com.api.name.inditex.services.PriceService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

/**
 * Price controller test.
 */
@RunWith(MockitoJUnitRunner.class)
public class PriceControllerTest {
  private static final Long BRAND_ID = 1L;

  private static final Long PRODUCT_ID = 35455L;

  private static final LocalDateTime LOCAL_DATE_TIME_1 =
      LocalDateTime.parse("2020-06-14-10.00.00", DateTimeFormatter.ofPattern(PATTERN));

  private static final LocalDateTime LOCAL_DATE_TIME_2 =
      LocalDateTime.parse("2020-06-14-16.00.00", DateTimeFormatter.ofPattern(PATTERN));

  private static final LocalDateTime LOCAL_DATE_TIME_3 =
      LocalDateTime.parse("2020-06-14-21.00.00", DateTimeFormatter.ofPattern(PATTERN));

  private static final LocalDateTime LOCAL_DATE_TIME_4 =
      LocalDateTime.parse("2020-06-15-10.00.00", DateTimeFormatter.ofPattern(PATTERN));

  private static final LocalDateTime LOCAL_DATE_TIME_5 =
      LocalDateTime.parse("2020-06-16-21.00.00", DateTimeFormatter.ofPattern(PATTERN));

  private static final LocalDateTime LOCAL_DATE_TIME_6 =
      LocalDateTime.parse("2019-06-16-21.00.00", DateTimeFormatter.ofPattern(PATTERN));

  @InjectMocks private PriceController priceController;

  @Mock private PriceService priceService;

  @Test
  public void test1_GetPriceByBrandProductAndStartDate_ThenResponseOK() {
    when(priceService.getPriceByBrandProductAndStartDate(anyLong(), anyLong(), any()))
        .thenReturn(mockPrice(BRAND_ID, PRODUCT_ID));

    ResponseEntity<PricesResponse> response =
        priceController.getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_1);

    assertTrue(response.getStatusCode().is2xxSuccessful());
    verify(priceService, times(1))
        .getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_1);
  }

  @Test
  public void test2_GetPriceByBrandProductAndStartDate_ThenResponseOK() {
    when(priceService.getPriceByBrandProductAndStartDate(anyLong(), anyLong(), any()))
        .thenReturn(mockPrice(BRAND_ID, PRODUCT_ID));

    ResponseEntity<PricesResponse> response =
        priceController.getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_2);

    assertTrue(response.getStatusCode().is2xxSuccessful());
    verify(priceService, times(1))
        .getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_2);
  }

  @Test
  public void test3_GetPriceByBrandProductAndStartDate_ThenResponseOK() {
    when(priceService.getPriceByBrandProductAndStartDate(anyLong(), anyLong(), any()))
        .thenReturn(mockPrice(BRAND_ID, PRODUCT_ID));

    ResponseEntity<PricesResponse> response =
        priceController.getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_3);

    assertTrue(response.getStatusCode().is2xxSuccessful());
    verify(priceService, times(1))
        .getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_3);
  }

  @Test
  public void test4_GetPriceByBrandProductAndStartDate_ThenResponseOK() {
    when(priceService.getPriceByBrandProductAndStartDate(anyLong(), anyLong(), any()))
        .thenReturn(mockPrice(BRAND_ID, PRODUCT_ID));

    ResponseEntity<PricesResponse> response =
        priceController.getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_4);

    assertTrue(response.getStatusCode().is2xxSuccessful());
    verify(priceService, times(1))
        .getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_4);
  }

  @Test
  public void test5_GetPriceByBrandProductAndStartDate_ThenResponseOK() {
    when(priceService.getPriceByBrandProductAndStartDate(anyLong(), anyLong(), any()))
        .thenReturn(mockPrice(BRAND_ID, PRODUCT_ID));

    ResponseEntity<PricesResponse> response =
        priceController.getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_5);

    assertTrue(response.getStatusCode().is2xxSuccessful());
    verify(priceService, times(1))
        .getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_5);
  }

  @Test
  public void test6_GetPriceByBrandProductAndStartDate_ThenResponseNotFound() {
    when(priceService.getPriceByBrandProductAndStartDate(anyLong(), anyLong(), any()))
        .thenReturn(Optional.empty());

    ResponseEntity<PricesResponse> response =
        priceController.getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_6);

    assertTrue(response.getStatusCode().is4xxClientError());
    verify(priceService, times(1))
        .getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_6);
  }

  private Optional<PricesResponse> mockPrice(Long brandId, Long productId) {
    return Optional.of(PricesResponse.builder().brandId(brandId).productId(productId).build());
  }
}
