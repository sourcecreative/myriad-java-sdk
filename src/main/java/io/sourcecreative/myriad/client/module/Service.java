package io.sourcecreative.myriad.client.module;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;

public abstract class Service {
  final MyriadApi api;
  
  final ObjectMapper objectMapper;

  Service(MyriadApi api, ObjectMapper objectMapper) {
    this.api = api;
    this.objectMapper = objectMapper;
  }
  
}
