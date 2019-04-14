package io.sourcecreative.myriad.client.model.voucher;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class Voucher {
  private UUID campaignId;

  private String category;

  private VoucherConfig config;

  @Singular("metadata")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private Map<String, Object> metadata;

  @Singular("asset")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private Map<String, Object> assets;

//  private Boolean isReferralCode;

//  private String referrerId;

  private Date updatedAt;

}
