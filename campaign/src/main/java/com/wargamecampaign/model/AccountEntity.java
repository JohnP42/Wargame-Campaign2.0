package com.wargamecampaign.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * 3/1/20にjohnpolhilによって作成されました。
 */
@Data
@EqualsAndHashCode
public class AccountEntity extends WargameCampaignEntity {
    @Null
    private Integer id;
    @NotBlank
    @Size(max = 50)
    private String username;
    @NotBlank
    @Size(min=8, max = 50)
    private String password;
    @NotBlank
    @Size(max = 355)
    private String email;
    @Null
    private Timestamp lastLogin;
    @Null
    private Boolean enabled;
}
