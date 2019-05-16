package io.sourcecreative.myriad.client;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.api.MyriadApiBuilder;
import io.sourcecreative.myriad.client.model.PaginatedResponse;
import io.sourcecreative.myriad.client.model.campaign.ActivateCampaign;
import io.sourcecreative.myriad.client.model.campaign.AddVoucherToCampaign;
import io.sourcecreative.myriad.client.model.campaign.Campaign;
import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.CampaignStatus;
import io.sourcecreative.myriad.client.model.campaign.CouponCampaign;
import io.sourcecreative.myriad.client.model.campaign.PaginatedCampaignsResponse;
import io.sourcecreative.myriad.client.model.campaign.UpdateCampaign;
import io.sourcecreative.myriad.client.model.campaign.VoucherCampaignResponse;
import io.sourcecreative.myriad.client.model.customer.Customer;
import io.sourcecreative.myriad.client.model.customer.CustomerResponse;
import io.sourcecreative.myriad.client.model.customer.CustomersResponse;
import io.sourcecreative.myriad.client.model.customer.PaginatedCustomersResponse;
import io.sourcecreative.myriad.client.model.customer.UpdateCustomers;
import io.sourcecreative.myriad.client.model.distribution.DistributeOneOffVouchers;
import io.sourcecreative.myriad.client.model.distribution.DistributeVouchers;
import io.sourcecreative.myriad.client.model.distribution.DistributeVouchersBySegment;
import io.sourcecreative.myriad.client.model.distribution.DistributionsResponse;
import io.sourcecreative.myriad.client.model.distribution.PaginatedDistributionsResponse;
import io.sourcecreative.myriad.client.model.product.Product;
import io.sourcecreative.myriad.client.model.product.ProductResponse;
import io.sourcecreative.myriad.client.model.promotion.Tier;
import io.sourcecreative.myriad.client.model.redemption.PaginatedRedemptionsResponse;
import io.sourcecreative.myriad.client.model.redemption.RedeemVoucher;
import io.sourcecreative.myriad.client.model.redemption.RedeemVouchers;
import io.sourcecreative.myriad.client.model.redemption.RedemptionResponse;
import io.sourcecreative.myriad.client.model.redemption.RedemptionsResponse;
import io.sourcecreative.myriad.client.model.registration.Registration;
import io.sourcecreative.myriad.client.model.registration.RegistrationResponse;
import io.sourcecreative.myriad.client.model.rule.PaginatedRulesResponse;
import io.sourcecreative.myriad.client.model.rule.Rule;
import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import io.sourcecreative.myriad.client.model.segment.PaginatedSegmentsResponse;
import io.sourcecreative.myriad.client.model.segment.Segment;
import io.sourcecreative.myriad.client.model.segment.SegmentResponse;
import io.sourcecreative.myriad.client.model.validation.ValidateVoucher;
import io.sourcecreative.myriad.client.model.validation.ValidateVoucherResponse;
import io.sourcecreative.myriad.client.model.voucher.CreateVoucher;
import io.sourcecreative.myriad.client.model.voucher.DisableVoucher;
import io.sourcecreative.myriad.client.model.voucher.PaginatedVouchersResponse;
import io.sourcecreative.myriad.client.model.voucher.UpdateVoucher;
import io.sourcecreative.myriad.client.model.voucher.VoucherResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

public class MockMyriadApiBuilder implements MyriadApiBuilder {
	@Override
	public MyriadApi build(Retrofit retrofit) {
		MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit)
				.networkBehavior(NetworkBehavior.create()).build();
		BehaviorDelegate<MyriadApi> delegate = mockRetrofit.create(MyriadApi.class);
		return new MockMyriadApi(delegate);
	}
	
	static final class MockMyriadApi implements MyriadApi {
		private final BehaviorDelegate<MyriadApi> delegate;
		
		MockMyriadApi(BehaviorDelegate<MyriadApi> delegate) {
			this.delegate = delegate;
			// seed mock data
		}

		@Override
		public Call<RegistrationResponse> register(Registration registration) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<Void> delete(String regId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CampaignResponse> createCampaign(Campaign campaign) {
			if (campaign instanceof CouponCampaign) {
				CouponCampaign couponCamp = (CouponCampaign)campaign;
				CampaignResponse response = VoucherCampaignResponse.builder()
						.id(UUID.randomUUID().toString())
						.autoUpdate(couponCamp.isAutoUpdate())
						.codeConfig(couponCamp.getCodeConfig())
						.discount(couponCamp.getDiscount())
						.effective(couponCamp.getEffective())
						.expiry(couponCamp.getExpiry())
						.description(couponCamp.getDescription())
						.metadata(couponCamp.getMetadata())
						.name(couponCamp.getName())
						.redemption(couponCamp.getRedemption())
						.status(CampaignStatus.ACTIVE)
						.build();
				return delegate.returningResponse(response).createCampaign(campaign);
			}
			throw new IllegalArgumentException();
		}

		@Override
		public Call<CampaignResponse> addVoucherToCampaign(String campaignId,
				AddVoucherToCampaign addVoucherToCampaign) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CampaignResponse> getCampaign(String campaignId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<PaginatedCampaignsResponse> listCampaigns(Map<String, Object> filter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CampaignResponse> updateCampaign(String campaignId, UpdateCampaign updateCampaign) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CampaignResponse> activateCampaign(String campaignId, ActivateCampaign activateCampaign) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<Void> deleteCampaign(String campaignId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CampaignResponse> importVouchersToCampaign(String campaignId,
				List<AddVoucherToCampaign> importVouchers) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CampaignResponse> attachRulesToCampaign(String campaignId, Set<Rule> addRulesToCampaign) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CampaignResponse> detachRulesFromCampaign(String campaignId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CampaignResponse> detachRuleFromCampaign(String campaignId, String ruleId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CampaignResponse> addTiersToCampaign(String campaignId, List<Tier> addTiersToCampaign) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CampaignResponse> removeTierFromCampaign(String campaignId, String tierId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CampaignResponse> removeTiersFromCampaign(String campaignId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<VoucherResponse> createVoucher(CreateVoucher createVoucher) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<VoucherResponse> getVoucher(String voucherId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<VoucherResponse> updateVoucher(String voucherId, UpdateVoucher updateVoucher) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<Void> deleteVoucher(String voucherId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<PaginatedVouchersResponse> listVouchers(Map<String, Object> filter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<VoucherResponse> enable(String voucherId, DisableVoucher disableVoucher) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<Void> importVouchers(List<CreateVoucher> vouchers) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<VoucherResponse> attachRulesToVoucher(String voucherId, Set<Rule> addRulesToVoucher) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<VoucherResponse> detachRulesFromVoucher(String voucherId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<VoucherResponse> detachRuleFromVoucher(String voucherId, String ruleId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CustomerResponse> createCustomer(Customer customer) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CustomerResponse> getCustomer(String customerId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CustomerResponse> updateCustomer(String customerId, Customer customer) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<CustomersResponse> updateCustomers(UpdateCustomers customers) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<Void> deleteCustomer(String customerId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<PaginatedCustomersResponse> listCustomers(Map<String, Object> filter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<SegmentResponse> createSegment(Segment createSegment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<SegmentResponse> getSegment(String segmentId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<PaginatedSegmentsResponse> listSegments(Map<String, Object> filter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<Void> deleteSegment(String segmentId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<DistributionsResponse> distributeVouchers(DistributeVouchers distributeVoucher) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<PaginatedDistributionsResponse> distributeVouchersBySegment(
				DistributeVouchersBySegment distributionRequest) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<DistributionsResponse> distributeOneOffVouchers(DistributeOneOffVouchers oneOffVouchers) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<PaginatedDistributionsResponse> listDistributions(Map<String, Object> filter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<RedemptionResponse> redeemVoucher(RedeemVoucher redemption) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<RedemptionsResponse> redeemVouchers(RedeemVouchers redeemVouchers) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<PaginatedRedemptionsResponse> listRedemptions(Map<String, Object> filter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<RedemptionResponse> getRedemption(String redemptionId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<PaginatedRedemptionsResponse> listRedemptionsByVoucher(String voucherId,
				Map<String, Object> filter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<RuleResponse> createRule(Rule createRule) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<PaginatedRulesResponse> listRules(Map<String, Object> filter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<Void> deleteRule(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<List<RuleResponse>> getRulesByCampaign(String campaignId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<List<RuleResponse>> getRulesByVoucher(String voucherId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<ValidateVoucherResponse> validateVoucher(ValidateVoucher validateVoucher) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<ProductResponse> createProduct(Product product) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<ProductResponse> getProduct(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<List<PaginatedResponse<ProductResponse>>> listProducts(Map<String, Object> filter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Call<Void> deleteProduct(String id) {
			// TODO Auto-generated method stub
			return null;
		}
	}

}
