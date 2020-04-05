package com.wargamecampaign.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * 3/25/20にjohnpolhilによって作成されました。
 */
@Data
@EqualsAndHashCode
public class AuthorityEntity extends WargameCampaignEntity {
    @NotBlank
    String username;
    @NotBlank
    String authorities;
}
