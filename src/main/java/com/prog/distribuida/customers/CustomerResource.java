package com.prog.distribuida.customers;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CustomerResource {

  @GET("customers")
  Call<List<Customer>> findAll();


  @POST("customers")
  Call<Void> save(@Body Customer entity);

  @PUT("customers/{customerId}")
  Call<Void> update(@Path("customerId") Long customerId, @Body Customer entity);

  @DELETE("customers/{customerId}")
  Call<Void> delete(@Path("customerId") Long customerId);

}


