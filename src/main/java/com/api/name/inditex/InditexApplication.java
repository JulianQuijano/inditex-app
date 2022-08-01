package com.api.name.inditex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Inditex Application.
 */
@SpringBootApplication
@RestController
public class InditexApplication {

  /**
   * main method.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(InditexApplication.class, args);
  }
}
