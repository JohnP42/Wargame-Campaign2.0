package com.wargamecampaign.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

/**
 * 3/4/20にjohnpolhilによって作成されました。
 */
@Data
@EqualsAndHashCode
public abstract class WargameCampaignEntity {
    @NotNull
    private DateTime createdAt;
    @NotNull
    private DateTime updatedAt;
}
