package com.github.gustavoflor.ordo.api.security.service;

import com.github.gustavoflor.ordo.core.entity.User;
import com.github.gustavoflor.ordo.core.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {
    static final Faker FAKER = new Faker();

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserDetailsServiceImpl userDetailsService;

    @Test
    @DisplayName("""
        GIVEN a non existent username
        WHEN load user by username
        THEN throw UsernameNotFoundException
        """)
    void givenANonexistentUsernameWhenLoadUserByUsernameThenThrowUsernameNotFoundException() {
        final var username = FAKER.name().username();

        assertThatThrownBy(() -> userDetailsService.loadUserByUsername(username)).isInstanceOf(UsernameNotFoundException.class);

        verify(userRepository).findByEmail(username);
    }

    @Test
    @DisplayName("""
        GIVEN a existent username
        WHEN load user by username
        THEN return user
        """)
    void givenAExistentUsernameWhenLoadUserByUsernameThenReturnUser() {
        final var username = FAKER.name().username();
        final var password = FAKER.internet().password();
        doReturn(Optional.of(new User(username, password))).when(userRepository).findByEmail(username);

        final var user = userDetailsService.loadUserByUsername(username);

        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getAuthorities()).isEmpty();
        assertThat(user.isAccountNonExpired()).isTrue();
        assertThat(user.isAccountNonLocked()).isTrue();
        assertThat(user.isEnabled()).isTrue();
        assertThat(user.isCredentialsNonExpired()).isTrue();
        verify(userRepository).findByEmail(username);
    }
}
