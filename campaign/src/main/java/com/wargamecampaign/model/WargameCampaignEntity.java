package com.wargamecampaign.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.joda.time.DateTime;

import javax.validation.constraints.Null;

/**
 * 3/4/20にjohnpolhilによって作成されました。
 */
@Data
@EqualsAndHashCode
public abstract class WargameCampaignEntity {
    @Null
    private DateTime createdAt;
    @Null
    private DateTime updatedAt;
}
