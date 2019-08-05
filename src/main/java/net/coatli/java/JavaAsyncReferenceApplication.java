package net.coatli.java;

import static java.lang.System.in;
import static java.util.UUID.randomUUID;
import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaAsyncReferenceApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(JavaAsyncReferenceApplication.class);

  public static void main(final String[] args) throws Exception {

    LOGGER.info("Main thread's local time is: '{}'", new LocalTime());

    runAsync(() -> {

      try {
        SECONDS.sleep(5);
      } catch (final InterruptedException exc) {
        throw new IllegalStateException(exc);
      }

      LOGGER.info("Run async thread's local time is : '{}'", new LocalTime());

    });

    final String productId = randomUUID().toString();

    LOGGER.info("Searching the product '{}'", productId);

    supplyAsync(() -> {

      try {
        SECONDS.sleep(5);
      } catch (final InterruptedException exc) {
        throw new IllegalStateException(exc);
      }

      return new ProductService().retrieve(productId);

    }).thenAccept(product -> {

      LOGGER.info("Product retrieved '{}'", product);

    });

    LOGGER.info("Press any key to terminate the execution");
    in.read();

  }

}
