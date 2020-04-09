package com.Ustora.user.entities;

import com.Ustora.user.security.BCryptEncoderConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class UserBook implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;
    @Size(max=50)
    @NotBlank
    @NotEmpty( message = "Merci de saisir un pseudo" )
    private String username;
    @Size(max=100)
    @NotBlank
    @Email( message = "Merci de saisir une adresse mail valide." )
    @NotEmpty( message = "Merci de saisir une adresse email" )
    private String email;
    @Size(max=100)
    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<UserRole> userRoleList;

    public UserBook() {
    }

    public UserBook(Long id,
                    @Size(max=50)
                    @NotBlank
                    @NotEmpty( message = "Merci de saisir un pseudo" )String username,
                    @Size(max=100)
                    @NotBlank
                    @Email( message = "Merci de saisir une adresse mail valide." )
                    @NotEmpty( message = "Merci de saisir une adresse email" )String email,
                    @Size(max=100)
                    @NotBlank
                    String password){

        this.id = id;
        this.username = username;
        this.email = email;
        this.password = BCryptEncoderConfig.passwordencoder().encode(password);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        userRoleList.forEach(userRole -> authorities.add(new SimpleGrantedAuthority(userRole.toString())));
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCryptEncoderConfig.passwordencoder().encode(password);
    }

    public void grantAuthority(UserRole authority) {
        if ( userRoleList == null ) userRoleList = new ArrayList<>();
        userRoleList.add(authority);
    }

    @Override
    public String toString(){
        return "UserBook{"+
                "id=" + id +
                ", username=" + username +
                ", email=" + email +
                ", password=" + password +"}";
    }
}
