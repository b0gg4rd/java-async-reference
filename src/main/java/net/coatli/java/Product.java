package net.coatli.java;

import static java.lang.String.format;

public class Product {

  private String id;
  private String name;
  private Double price;

  public Product() {
  }

  public String getId() {
    return id;
  }

  public Product setId(final String id) {
    this.id = id;

    return this;
  }

  public String getName() {
    return name;
  }

  public Product setName(final String name) {
    this.name = name;

    return this;
  }

  public Double getPrice() {
    return price;
  }

  public Product setPrice(final Double price) {
    this.price = price;

    return this;
  }

  @Override
  public String toString() {
    return format("{'id':'%s','name':'%s','price':'%s'}".replace("'", "\""), id, name, price);
  }

}
