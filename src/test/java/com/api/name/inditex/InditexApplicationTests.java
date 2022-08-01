package com.api.name.inditex;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * InditexApplication test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = InditexApplication.class)
@AutoConfigureMockMvc
public class InditexApplicationTests {
  private static final Long BRAND_ID = 1L;

  private static final String PRICE_1 = "35.5";

  private static final String PRICE_2 = "25.45";

  private static final String PRICE_3 = "30.5";

  private static final String PRICE_4 = "38.95";

  private static final Long PRODUCT_ID = 35455L;

  private static final String TEST_TIME_1 = "2020-06-14-10.00.00";

  private static final String TEST_TIME_2 = "2020-06-14-16.00.00";

  private static final String TEST_TIME_3 = "2020-06-14-21.00.00";

  private static final String TEST_TIME_4 = "2020-06-15-10.00.00";

  private static final String TEST_TIME_5 = "2020-06-16-21.00.00";

  private static final String TEST_TIME_6 = "2019-06-16-21.00.00";

  private static final String URI = "/brand/%s/product/%s/price?date_time=%s";

  private static String url;

  private ResultActions resultActions;

  @Autowired private MockMvc mvc;

  @Test
  public void
      test1_givenBrandProductAndStartDate_whenGetPriceByBrandProductAndStartDate_thenResponseOK()
          throws Exception {
    givenUrl(TEST_TIME_1);
    whenRequestIsExecuted();
    thenValidateResponse(status().isOk(), PRICE_1);
  }

  @Test
  public void
      test2_givenBrandProductAndStartDate_whenGetPriceByBrandProductAndStartDate_thenResponseOK()
          throws Exception {
    givenUrl(TEST_TIME_2);
    whenRequestIsExecuted();
    thenValidateResponse(status().isOk(), PRICE_2);
  }

  @Test
  public void
      test3_givenBrandProductAndStartDate_whenGetPriceByBrandProductAndStartDate_thenResponseOK()
          throws Exception {
    givenUrl(TEST_TIME_3);
    whenRequestIsExecuted();
    thenValidateResponse(status().isOk(), PRICE_1);
  }

  @Test
  public void
      test4_givenBrandProductAndStartDate_whenGetPriceByBrandProductAndStartDate_thenResponseOK()
          throws Exception {
    givenUrl(TEST_TIME_4);
    whenRequestIsExecuted();
    thenValidateResponse(status().isOk(), PRICE_3);
  }

  @Test
  public void
      test5_givenBrandProductAndStartDate_whenGetPriceByBrandProductAndStartDate_thenResponseOK()
          throws Exception {
    givenUrl(TEST_TIME_5);
    whenRequestIsExecuted();
    thenValidateResponse(status().isOk(), PRICE_4);
  }

  @Test
  public void
      test6_givenBrandProductAndStartDate_whenGetPriceByBrandProductAndStartDate_thenResponseNotFound()
          throws Exception {
    givenUrl(TEST_TIME_6);
    whenRequestIsExecuted();
    thenValidateNotFoundResponse(status().isNotFound());
  }

  private void thenValidateResponse(ResultMatcher status, String price) throws Exception {
    resultActions
        .andExpect(status)
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.price").value(price));
  }

  private void thenValidateNotFoundResponse(ResultMatcher status) throws Exception {
    resultActions.andExpect(status);
  }

  private void whenRequestIsExecuted() throws Exception {
    resultActions =
        mvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON));
  }

  private void givenUrl(String datetime) {
    url = String.format(URI, BRAND_ID, PRODUCT_ID, datetime);
  }
}
