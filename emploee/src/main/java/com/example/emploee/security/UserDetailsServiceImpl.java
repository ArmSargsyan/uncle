package com.example.emploee.security;

import com.example.emploee.model.ModelEmployee;
import com.example.emploee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ModelEmployee byUsername = employeeRepository.findByUsername(s)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
        return new CurrentUser(byUsername);
    }
}
