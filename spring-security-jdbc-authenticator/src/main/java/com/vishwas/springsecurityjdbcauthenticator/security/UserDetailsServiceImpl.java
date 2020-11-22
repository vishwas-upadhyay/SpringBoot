package com.vishwas.springsecurityjdbcauthenticator.security;

import com.vishwas.springsecurityjdbcauthenticator.model.MyUsers;
import com.vishwas.springsecurityjdbcauthenticator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<MyUsers> user = userRepository.findByUsername(userName);
        return new MyUserDetails (user.orElseThrow(()->new UsernameNotFoundException("user not found")));

    }
}
