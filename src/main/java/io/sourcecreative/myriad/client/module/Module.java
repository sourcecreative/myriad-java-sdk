package io.sourcecreative.myriad.client.module;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;

public abstract class Module {
  final MyriadApi api;
  
  // objectmapper used to convert error response to APIError
  final ObjectMapper om = new ObjectMapper();

  Module(MyriadApi api) {
    this.api = api;
  }
  
}
