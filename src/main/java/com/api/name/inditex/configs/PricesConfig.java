package com.api.name.inditex.configs;

import static com.api.name.inditex.configs.Const.EUR;
import static com.api.name.inditex.configs.Const.PATTERN;

import com.api.name.inditex.entities.PricesDTO;
import com.api.name.inditex.repository.PricesRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * H2 initial settings.
 */
@Configuration
public class PricesConfig {

  public static final String END_DATE_TIME = "2020-12-31-23.59.59";

  public static final long PRODUCT_ID = 35455L;

  @Bean
  CommandLineRunner commandLineRunner(PricesRepository repository) {
    return args -> {
      List<PricesDTO> newPrices = new ArrayList<>();
      newPrices.add(
          new PricesDTO(
              1L,
              LocalDateTime.parse("2020-06-14-00.00.00", DateTimeFormatter.ofPattern(PATTERN)),
              LocalDateTime.parse(END_DATE_TIME, DateTimeFormatter.ofPattern(PATTERN)),
              1,
              PRODUCT_ID,
              0,
              new BigDecimal("35.50"),
              EUR));
      newPrices.add(
          new PricesDTO(
              1L,
              LocalDateTime.parse("2020-06-14-15.00.00", DateTimeFormatter.ofPattern(PATTERN)),
              LocalDateTime.parse("2020-06-14-18.30.00", DateTimeFormatter.ofPattern(PATTERN)),
              2,
              PRODUCT_ID,
              1,
              new BigDecimal("25.45"),
              EUR));
      newPrices.add(
          new PricesDTO(
              1L,
              LocalDateTime.parse("2020-06-15-00.00.00", DateTimeFormatter.ofPattern(PATTERN)),
              LocalDateTime.parse("2020-06-15-11.00.00", DateTimeFormatter.ofPattern(PATTERN)),
              3,
              PRODUCT_ID,
              1,
              new BigDecimal("30.50"),
              EUR));
      newPrices.add(
          new PricesDTO(
              1L,
              LocalDateTime.parse("2020-06-15-16.00.00", DateTimeFormatter.ofPattern(PATTERN)),
              LocalDateTime.parse(END_DATE_TIME, DateTimeFormatter.ofPattern(PATTERN)),
              4,
              PRODUCT_ID,
              1,
              new BigDecimal("38.95"),
              EUR));

      repository.saveAll(newPrices);
    };
  }
}
