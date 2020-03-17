package edu.miu.cs.cs544.group1.domain.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PersonDetails implements UserDetails {
    private Person person;
    public PersonDetails(Person person) {
        this.person = person;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return person.getRoles().stream()
        		.map(authority -> 
        			new SimpleGrantedAuthority(authority.toString()))
        		.collect(Collectors.toList());
    }
    public long getId() {
        return person.getId();
    }
    @Override
    public String getPassword() {
        return person.getPassword();
    }
    @Override
    public String getUsername() {
        return person.getName();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    public Person getUserDetails() {
        return person;
    }
}
