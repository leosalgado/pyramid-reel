package com.pyramidreel.api.model.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserTest {

    @Test
    void getAuthorities_whenAdmin_shouldReturnAllRoles() {
        User user = new User();
        user.setRole(UserRole.ADMIN);

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        Assertions.assertThat(authorities).extracting(GrantedAuthority::getAuthority)
                .containsExactlyInAnyOrder("ROLE_ADMIN", "ROLE_PRO", "ROLE_USER");
    }

    @Test
    void getAuthorities_whenPro_shouldReturnProAndUserRoles() {
        User user = new User();
        user.setRole(UserRole.PRO);

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        Assertions.assertThat(authorities).extracting(GrantedAuthority::getAuthority)
                .containsExactlyInAnyOrder("ROLE_PRO", "ROLE_USER");
    }

    @Test
    void getAuthorities_whenRegularUser_shouldReturnOnlyUserRole() {
        User user = new User();
        user.setRole(UserRole.USER);

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        Assertions.assertThat(authorities).extracting(GrantedAuthority::getAuthority)
                .containsExactlyInAnyOrder("ROLE_USER");
    }
}
