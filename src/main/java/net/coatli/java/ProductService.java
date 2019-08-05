package net.coatli.java;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ProductService {

  public Product retrieve(final String productId) {

    try {
      SECONDS.sleep(10);
    } catch (final InterruptedException exc) {
      throw new IllegalStateException(exc);
    }

    return new Product().setId(productId)
                        .setName("Product A")
                        .setPrice(350d);

  }

}
