package com.prog.distribuida.customers;

import com.prog.distribuida.customers.Customer;
import retrofit2.Call;
import retrofit2.http.*;

import javax.websocket.server.PathParam;
import java.util.List;

public interface CustomerResource {

  @GET("customers")
  Call<List<Customer>> findAll();


  @POST("customers")
  Call<Void> save(@Body Customer entity);

  @PUT("customers/{customerId}")
  Call<Void> update(@PathParam("customerId") Long customerId, @Body Customer entity);

  @DELETE("customers/{customerId}")
  Call<Void> delete(@PathParam("customerId") Long customerId);

}


