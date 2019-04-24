package io.sourcecreative.myriad.client.module;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.model.customer.Customer;
import io.sourcecreative.myriad.client.model.customer.CustomerResponse;
import io.sourcecreative.myriad.client.model.customer.CustomersResponse;
import io.sourcecreative.myriad.client.model.customer.PaginatedCustomersResponse;
import io.sourcecreative.myriad.client.model.customer.UpdateCustomers;

public class CustomerService extends Service {

	CustomerService(MyriadApi api, ObjectMapper objectMapper) {
		super(api, objectMapper);
	}

	public RemoteCall<CustomerResponse> create(Customer customer) {
		return RemoteCall.of(api.createCustomer(customer));
	}

	public RemoteCall<CustomerResponse> findById(String customerId) {
		return RemoteCall.of(api.getCustomer(customerId));
	}

	public RemoteCall<CustomerResponse> update(String customerId, Customer customer) {
		return RemoteCall.of(api.updateCustomer(customerId, customer));
	}

	public RemoteCall<CustomersResponse> update(UpdateCustomers customers) {
		return RemoteCall.of(api.updateCustomers(customers));
	}

	public RemoteCall<Void> delete(String customerId) {
		return RemoteCall.of(api.deleteCustomer(customerId));
	}
	
	public RemoteCall<PaginatedCustomersResponse> list(Map<String,Object> filter) {
		return RemoteCall.of(api.listCustomers(filter));
	}

}
