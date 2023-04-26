package com.petkpetk.admin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.petkpetk.admin.dto.UserAccountDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountApiResponse {
    private Embedded _embedded;

    private UserAccountDto userAccount;


    public static UserAccountApiResponse empty() {
        return new UserAccountApiResponse(new Embedded(List.of()), new UserAccountDto());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Embedded {
        private List<UserAccountDto> UserAccounts;
    }

}




