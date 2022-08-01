package com.api.name.inditex.services;

import static com.api.name.inditex.configs.Const.PATTERN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.api.name.inditex.entities.PricesDTO;
import com.api.name.inditex.entities.PricesResponse;
import com.api.name.inditex.repository.PricesRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * PriceService test.
 */
@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTest {
  protected static final Long BRAND_ID = 1L;

  protected static final Long PRODUCT_ID = 35455L;

  protected static final BigDecimal PRICE_1 = new BigDecimal("35.50");

  protected static final BigDecimal PRICE_2 = new BigDecimal("25.45");

  protected static final String CURR = "EUR";

  protected static final String TEST_TIME_1 = "2020-06-14-10.00.00";

  private static final LocalDateTime LOCAL_DATE_TIME_1 =
      LocalDateTime.parse(TEST_TIME_1, DateTimeFormatter.ofPattern(PATTERN));

  private static final LocalDateTime START_DATE_TIME =
      LocalDateTime.parse("2020-06-14-00.00.00", DateTimeFormatter.ofPattern(PATTERN));

  private static final LocalDateTime END_DATE_TIME =
      LocalDateTime.parse("2020-12-31-23.59.59", DateTimeFormatter.ofPattern(PATTERN));

  @InjectMocks private PriceService priceService;

  @Mock private PricesRepository pricesRepository;

  private static PricesDTO getPricesDTO(Integer priorityId, BigDecimal price) {
    PricesDTO pricesDTO = new PricesDTO();
    pricesDTO.setId(1L);
    pricesDTO.setBrandId(BRAND_ID);
    pricesDTO.setStartDate(START_DATE_TIME);
    pricesDTO.setEndDate(END_DATE_TIME);
    pricesDTO.setPriceList(1);
    pricesDTO.setProductId(PRODUCT_ID);
    pricesDTO.setPriority(priorityId);
    pricesDTO.setPrice(price);
    pricesDTO.setCurr(CURR);
    return pricesDTO;
  }

  @Test
  public void test1_getPriceByBrandProductAndStartDateWithOnePriceDto_thenResponseOK() {
    when(pricesRepository
            .findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                anyLong(), anyLong(), any(), any()))
        .thenReturn(mockRepositoryResponseWithOneDto());

    Optional<PricesResponse> serviceResponse =
        priceService.getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_1);
    assertTrue(serviceResponse.isPresent());
    assertEquals(serviceResponse.get().getPrice(), PRICE_1);
  }

  @Test
  public void test2_getPriceByBrandProductAndStartDateWithTwoPriceDto_thenResponseOK() {
    when(pricesRepository
            .findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                anyLong(), anyLong(), any(), any()))
        .thenReturn(mockRepositoryResponseWithTwoDto());

    Optional<PricesResponse> serviceResponse =
        priceService.getPriceByBrandProductAndStartDate(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME_1);
    assertTrue(serviceResponse.isPresent());
    assertEquals(serviceResponse.get().getPrice(), PRICE_2);
  }

  private Optional<List<PricesDTO>> mockRepositoryResponseWithOneDto() {
    List<PricesDTO> pricesList = new ArrayList<>();
    pricesList.add(getPricesDTO(0, PRICE_1));
    return Optional.of(pricesList);
  }

  private Optional<List<PricesDTO>> mockRepositoryResponseWithTwoDto() {
    List<PricesDTO> pricesList = new ArrayList<>();
    pricesList.add(getPricesDTO(0, PRICE_1));
    pricesList.add(getPricesDTO(1, PRICE_2));
    return Optional.of(pricesList);
  }
}
