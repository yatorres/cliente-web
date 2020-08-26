package com.prog.distribuida.orders;

import com.prog.distribuida.orders.Orders;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface OrderResource {

  @GET("customers/{customerId}/orders")
  Call<List<Orders>> findOrders(@Path("customerId") Long customerId);


  @POST("orders")
  Call<Void> save(@Body Orders orders);

}


