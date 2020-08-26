package com.prog.distribuida.orders;

public class Orders {

  private Long id;
  private Integer price;
  private String item;
  private Long customerId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
}
