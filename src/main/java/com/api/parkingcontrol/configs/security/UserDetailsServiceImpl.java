package com.api.parkingcontrol.configs.security;

import com.api.parkingcontrol.models.UserModel2;
import com.api.parkingcontrol.repositories.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepository2 userRepository2;


    public UserDetailsServiceImpl(UserRepository2 userRepository2) {
        this.userRepository2 = userRepository2;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserModel2 userModel2 = userRepository2.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado:" + userName));
        return new User(userModel2.getUsername(), userModel2.getPassword(), true, true, true,true, userModel2.getAuthorities());
    }
}
