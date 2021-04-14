package ma.sec.services;

import ma.sec.entities.User;
import ma.sec.repositories.UserRepository;
import ma.sec.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = ()->new UsernameNotFoundException("Problem during authentication");
        final User user = userRepository.findUserByUsername(username).orElseThrow(s);
        return new CustomUserDetails(user);
    }


}
