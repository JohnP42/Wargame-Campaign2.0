package com.wargamecampaign.model;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 3/1/20にjohnpolhilによって作成されました。
 */
@Data
public class AccountEntity {

    @NotNull
    @Min(0)
    private Integer id;
    @NotNull
    @Size(max = 50)
    private String username;
    @NotNull
    @Size(max = 50)
    private String password;
    @NotNull
    @Size(max = 355)
    private String email;
}
