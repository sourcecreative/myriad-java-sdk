package io.sourcecreative.myriad.client.module;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.module.Module.Async;

public abstract class Module<A extends Async> {
  final MyriadApi api;

  final A extAsync;
  
  // objectmapper used to convert error response to APIError
  final ObjectMapper om = new ObjectMapper();

  Module(MyriadApi api) {
    this.api = api;
    this.extAsync = newAsync();
  }
  
  abstract A newAsync();

//  abstract R createRxJavaExtension();

  public abstract A async();

//  public abstract R rx();

//  public static class Rx {}

  public static class Async {}
  
}
