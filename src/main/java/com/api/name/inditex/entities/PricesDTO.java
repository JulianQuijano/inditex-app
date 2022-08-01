package com.api.name.inditex.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * The object entity for table prices.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(
    name = "prices",
    indexes = {@Index(name = "SECONDARY_KEY", columnList = "BRAND_ID,PRODUCT_ID,START_DATE")})
public class PricesDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @NonNull
  @Column(name = "BRAND_ID", nullable = false)
  private Long brandId;

  @NonNull
  @Column(name = "START_DATE", nullable = false)
  private LocalDateTime startDate;

  @NonNull
  @Column(name = "END_DATE", nullable = false)
  private LocalDateTime endDate;

  @NonNull
  @Column(name = "PRICE_LIST", nullable = false)
  private Integer priceList;

  @NonNull
  @Column(name = "PRODUCT_ID", nullable = false)
  private Long productId;

  @NonNull
  @Column(name = "PRIORITY", nullable = false)
  private Integer priority;

  @NonNull
  @Column(name = "PRICE", nullable = false)
  private BigDecimal price;

  @NonNull
  @Column(name = "CURR", nullable = false)
  private String curr;
}
