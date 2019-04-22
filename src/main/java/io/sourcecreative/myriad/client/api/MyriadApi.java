package io.sourcecreative.myriad.client.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import io.sourcecreative.myriad.client.model.campaign.ActivateCampaign;
import io.sourcecreative.myriad.client.model.campaign.AddVoucherToCampaign;
import io.sourcecreative.myriad.client.model.campaign.Campaign;
import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.PaginatedCampaignsResponse;
import io.sourcecreative.myriad.client.model.campaign.UpdateCampaign;
import io.sourcecreative.myriad.client.model.customer.Customer;
import io.sourcecreative.myriad.client.model.customer.CustomerResponse;
import io.sourcecreative.myriad.client.model.customer.CustomersResponse;
import io.sourcecreative.myriad.client.model.customer.PaginatedCustomersResponse;
import io.sourcecreative.myriad.client.model.customer.UpdateCustomers;
import io.sourcecreative.myriad.client.model.distribution.DistributeOneOffVouchers;
import io.sourcecreative.myriad.client.model.distribution.DistributeVouchers;
import io.sourcecreative.myriad.client.model.distribution.DistributeVouchersBySegment;
import io.sourcecreative.myriad.client.model.distribution.DistributionResponse;
import io.sourcecreative.myriad.client.model.distribution.DistributionsResponse;
import io.sourcecreative.myriad.client.model.distribution.PaginatedDistributionsResponse;
import io.sourcecreative.myriad.client.model.promotion.Tier;
import io.sourcecreative.myriad.client.model.redemption.PaginatedRedemptionsResponse;
import io.sourcecreative.myriad.client.model.redemption.RedeemVoucher;
import io.sourcecreative.myriad.client.model.redemption.RedeemVouchers;
import io.sourcecreative.myriad.client.model.redemption.RedemptionResponse;
import io.sourcecreative.myriad.client.model.redemption.RedemptionsResponse;
import io.sourcecreative.myriad.client.model.segment.PaginatedSegmentsResponse;
import io.sourcecreative.myriad.client.model.segment.Segment;
import io.sourcecreative.myriad.client.model.segment.SegmentResponse;
import io.sourcecreative.myriad.client.model.validation.PaginatedRulesResponse;
import io.sourcecreative.myriad.client.model.validation.Rule;
import io.sourcecreative.myriad.client.model.validation.RuleResponse;
import io.sourcecreative.myriad.client.model.validation.ValidateVoucher;
import io.sourcecreative.myriad.client.model.validation.ValidateVoucherResponse;
import io.sourcecreative.myriad.client.model.voucher.AddRulesToVoucherResponse;
import io.sourcecreative.myriad.client.model.voucher.CreateVoucher;
import io.sourcecreative.myriad.client.model.voucher.EnableVoucher;
import io.sourcecreative.myriad.client.model.voucher.ImportVouchers;
import io.sourcecreative.myriad.client.model.voucher.PaginatedVouchersResponse;
import io.sourcecreative.myriad.client.model.voucher.UpdateVoucher;
import io.sourcecreative.myriad.client.model.voucher.VoucherResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface MyriadApi {

  // CAMPAIGNS
  @POST("/campaigns")
  Call<CampaignResponse> createCampaign(@Body Campaign createCampaign);

  @POST("/campaigns/{id}/vouchers")
  Call<CampaignResponse> addVoucherToCampaign(@Path("id") String campaignId, @Body AddVoucherToCampaign addVoucherToCampaign);

  @GET("/campaigns/{id}")
  Call<CampaignResponse> getCampaign(@Path("id") String campaignId);

  @GET("/campaigns")
  Call<PaginatedCampaignsResponse> listCampaigns(@QueryMap Map<String, Object> filter);

  @PUT("/campaigns/{id}")
  Call<CampaignResponse> updateCampaign(@Path("id") String campaignId, @Body UpdateCampaign updateCampaign);
  
  @PATCH("/campaigns/{id}")
  Call<CampaignResponse> activateCampaign(@Path("id")String campaignId, @Body ActivateCampaign activateCampaign);

  @DELETE("/campaigns/{id}")
  Call<Void> deleteCampaign(@Path("id") String campaignId);

  @POST("/campaigns/{id}/vouchers")
  Call<CampaignResponse> importVouchersToCampaign(@Path("id") String campaignId, @Body List<AddVoucherToCampaign> importVouchers);
  
  @POST("/campaigns/{id}/rules")
  Call<CampaignResponse> attachRulesToCampaign(@Path("id")String campaignId, @Body Set<Rule> addRulesToCampaign);

  @DELETE("/campaigns/{id}/rules")
  Call<CampaignResponse> detachRulesFromCampaign(@Path("id")String campaignId);
  
  @DELETE("/campaigns/{id}/rules/{ruleId}")
  Call<CampaignResponse> detachRuleFromCampaign(@Path("id")String campaignId, @Path("ruleId")String ruleId);
  
  @POST("/campaigns/{id}/tiers")
  Call<CampaignResponse> addTiersToCampaign(@Path("id")String campaignId, @Body List<Tier> addTiersToCampaign);
  
  @DELETE("/campaigns/{id}/tiers/{tierId}")
  Call<CampaignResponse> removeTierFromCampaign(@Path("id")String campaignId, @Path("tierId")String tierId);
  
  @DELETE("/campaigns/{id}/tiers")
  Call<CampaignResponse> removeTiersFromCampaign(@Path("idd")String campaignId);
  
  // VOUCHERS

  @POST("/vouchers")
  Call<VoucherResponse> createVoucher(@Body CreateVoucher createVoucher);

  @GET("/vouchers/{code}")
  Call<VoucherResponse> getVoucher(@Path("code") String code);

  @PUT("/vouchers/{code}")
  Call<VoucherResponse> updateVoucher(@Path("code") String code, @Body UpdateVoucher updateVoucher);

  @DELETE("/vouchers/{code}")
  Call<Void> deleteVoucher(@Path("code") String code);

  @GET("/vouchers")
  Call<PaginatedVouchersResponse> listVouchers(@QueryMap Map<String, Object> filter);

  @PATCH("/vouchers/{code}")
  Call<VoucherResponse> enable(@Path("code") String code, @Body EnableVoucher disableVoucher);

  @POST("/vouchers/import")
  Call<Void> importVouchers(@Body ImportVouchers vouchers);
  
  // Rules added to voucher override rules assigned to campaign
  @POST("/vouchers/{id}/rules")
  Call<AddRulesToVoucherResponse> attachRulesToVoucher(@Path("id")String voucherId, @Body Set<Rule> addRulesToVoucher);

  @DELETE("/vouchers/{id}/rules")
  Call<Void> detachRulesFromVoucher(@Path("id")String voucherId);
  
  @DELETE("/vouchers/{id}/rules/{ruleId}")
  Call<Void> detachRuleFromVoucher(@Path("id")String voucherId, @Path("ruleId")String ruleId);

  
  // CUSTOMERS

  @POST("/customers")
  Call<CustomerResponse> createCustomer(@Body Customer customer);

  @GET("/customers/{id}")
  Call<CustomerResponse> getCustomer(@Path("id") String customerId);

  @PUT("/customers/{id}")
  Call<CustomerResponse> updateCustomer(@Path("id") String customerId, @Body Customer customer);
  
  @PUT("/customers")
  Call<CustomersResponse> updateCustomers(@Body UpdateCustomers customers);

  @DELETE("/customers/{id}")
  Call<Void> deleteCustomer(@Path("id") String customerId);

  @GET("/customers")
  Call<PaginatedCustomersResponse> listCustomers(@QueryMap Map<String, Object> filter);

  // SEGMENTS
  @POST("/segments")
  Call<SegmentResponse> createSegment(@Body Segment createSegment);
  
  @GET("/segments/{id}")
  Call<SegmentResponse> getSegment(@Path("id")String segmentId);
  
  @GET("/segments")
  Call<PaginatedSegmentsResponse> listSegments(@QueryMap Map<String,Object> filter);
  
  @DELETE("/segments/{id}")
  Call<Void> deleteSegment(@Path("id")String segmentId);

  // DISTRIBUTIONS

  // Distribute vouchers to given customers. Each customer may receive one or more vouchers.
  // Vouchers will be automatically generated in the distribution process
  @POST("/distributions/batch")
  Call<DistributionsResponse> distributeVouchers(@Body DistributeVouchers distributeVoucher);
  
  @POST("/distributions")
  Call<PaginatedDistributionsResponse> distributeVouchersBySegment(@Body DistributeVouchersBySegment distributionRequest);
  
  @POST("/distributions/batch/oneoff")
  Call<DistributionsResponse> distributeOneOffVouchers(@Body DistributeOneOffVouchers oneOffVouchers);

  @GET("/distributions")
  Call<PaginatedDistributionsResponse> listDistributions(@QueryMap Map<String, Object> filter);
	
  // REDEMPTIONS
  
  @POST("/redemptions")
  Call<RedemptionResponse> redeemVoucher(@Body RedeemVoucher redemption);
  
  @POST("/redemptions/batch")
  Call<RedemptionsResponse> redeemVouchers(@Body RedeemVouchers redeemVouchers);
  
  @GET("/redemptions")
  Call<PaginatedRedemptionsResponse> listRedemptions(@QueryMap Map<String, Object> filter);
  
  @GET("/redemptions/{id}")
  Call<RedemptionResponse> getRedemption(@Path("id")String redemptionId);
  
  @GET("/vouchers/{id}/redemptions")
  Call<PaginatedRedemptionsResponse> listRedemptionsByVoucher(@QueryMap Map<String, Object> filter);
  
  // VALIDATION RULES
  
  // create custom validation rule
  @POST("/rules")
  Call<RuleResponse> createRule(@Body Rule createRule);
    
  // returns rules including pre-defined system rules
  @GET("/rules")
  Call<PaginatedRulesResponse> listRules(@QueryMap Map<String,Object> filter);
  
  @DELETE("/rules/{id}")
  Call<Void> deleteRule(@Path("id")String id);
  
  @GET("/campaigns/{id}/rules")
  Call<List<RuleResponse>> getRulesByCampaign(@Path("id")String campaignId);
  
  // returns the rules assigned to voucher or assigned to voucher's campaign
  @GET("/vouchers/{id}/rules")
  Call<List<RuleResponse>> getRulesByVoucher(@Path("id")String voucherId);

  @POST("/vouchers/{id}/validate")
  Call<ValidateVoucherResponse> validateVoucher(@Body ValidateVoucher validateVoucher);

}
