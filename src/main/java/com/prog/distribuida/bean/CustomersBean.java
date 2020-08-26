package com.prog.distribuida.bean;

import com.prog.distribuida.customers.Customer;
import com.prog.distribuida.customers.CustomerResource;
import com.prog.distribuida.orders.OrderResource;
import com.prog.distribuida.orders.Orders;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("customersBean")
@RequestScope
public class CustomersBean {

  private List<Customer> customers;
  private CustomerResource customerResource;
  private OrderResource orderResource;
  private Customer customer;
  private List<Orders> orders;
  private Orders order;
  private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
  private Long customerId;
  private List<SelectItem> customersList;
  private HtmlDataTable datatableCustomers;

  public List<SelectItem> getCustomersList() {
    return customersList;
  }

  public void setCustomersList(List<SelectItem> customersList) {
    this.customersList = customersList;
  }

  public CustomersBean() {
    Retrofit retrofitCustomers = new Retrofit.Builder()
      .baseUrl("https://torres-distribuida41.herokuapp.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .client(httpClient.build())
      .build();
    customerResource = retrofitCustomers.create(CustomerResource.class);

    Retrofit retrofitOrders = new Retrofit.Builder()
      .baseUrl("https://torres-distribuida42.herokuapp.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .client(httpClient.build())
      .build();
    orderResource = retrofitOrders.create(OrderResource.class);

    loadCustomers();
    customer = new Customer();
    order = new Orders();
  }

  public void updateCustomer(){
    Customer customerToEdit = (Customer)datatableCustomers.getRowData();
    this.customer = customerToEdit;
  }

  public void deleteCustomer(){
    Customer customerToDelete = (Customer)datatableCustomers.getRowData();
    Call<Void> deleteCustomer = customerResource.delete(customerToDelete.getId());
    try {
      deleteCustomer.execute();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void saveOrder() {
    this.order.setCustomerId(this.customerId);
    Call<Void> saveOrder = orderResource.save(this.order);
    try {
      saveOrder.execute();
      this.loadOrders();
      this.order = new Orders();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void loadOrders() {
    if (this.customerId == 0L || this.customerId == null) {
      this.orders = new ArrayList<>();
    }
    Call<List<Orders>> loadOrders = orderResource.findOrders(this.customerId);
    try {
      this.orders = loadOrders.execute().body();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void save() {
    Call<Void> save = customerResource.save(this.customer);
    try {
      save.execute();
      customer = new Customer();
      this.loadCustomers();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public List<Orders> getOrders() {
    return orders;
  }

  public void setOrders(List<Orders> orders) {
    this.orders = orders;
  }

  public Orders getOrder() {
    return order;
  }

  public void setOrder(Orders order) {
    this.order = order;
  }

  private void loadCustomers() {
    Call<List<Customer>> callSync = customerResource.findAll();
    try {
      customers = callSync.execute().body();

      customersList = new ArrayList<>();
      for (Customer customer : customers) {
        customersList.add(new SelectItem(customer.getId(), customer.getName() + " " + customer.getSurname()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
  }


  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
}
