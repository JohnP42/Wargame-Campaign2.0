package com.wargamecampaign.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.joda.time.DateTime;

/**
 * 3/4/20にjohnpolhilによって作成されました。
 */
@Data
@EqualsAndHashCode
public abstract class WargameCampaignEntity {
    private DateTime createdAt;
    private DateTime updatedAt;
}
