package com.zzk.bitbyte.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Principal;

/**
 * @Author: zzk
 * @Date: 2020-02-20 10:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipal implements Principal {
    private String userId;

    /**
     * Returns the name of this principal.
     *
     * @return the name of this principal.
     */
    @Override
    public String getName() {
        return userId;
    }
}
