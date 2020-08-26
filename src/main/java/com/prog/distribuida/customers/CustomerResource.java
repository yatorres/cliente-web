package com.prog.distribuida.customers;

import com.prog.distribuida.customers.Customer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface CustomerResource {

  @GET("customers")
  Call<List<Customer>> findAll();


  @POST("customers")
  Call<Void> save(@Body Customer entity);
//
//  @GET
//  @Produces(MediaType.APPLICATION_JSON)
//  @Path("{id}")
//  public Customer get(@PathParam("id") Long id) {
//    return customerRepository.findById(id);
//  }
//
//  @Transactional
//  @POST
//  @Consumes("application/json")
//  @Produces("application/json")
//  public Response add(Customer entity) {
//    customerRepository.persist(entity);
//    return Response.status(Response.Status.CREATED).build();
//  }
//
//  @Transactional
//  @PUT
//  @Consumes("application/json")
//  @Produces("application/json")
//  @Path("{id}")
//  public Response update(@PathParam("id") Long id, Customer customer) {
//    Customer customerFound = customerRepository.findById(id);
//    customerFound.setName(customer.getName());
//    customerFound.setSurname(customer.getSurname());
//    customerRepository.persist(customerFound);
//    return Response.status(Response.Status.OK).build();
//  }
//
//  @Transactional
//  @DELETE
//  @Path("{id}")
//  public void delete(@PathParam("id") Long id) {
//    customerRepository.deleteById(id);
//  }
}


