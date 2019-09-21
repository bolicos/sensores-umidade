package greenhouse.services;

import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import greenhouse.models.User;
import greenhouse.repositories.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getSimpleName());
	
	@Autowired
    private UserRepository userRepository;
	
	
	@Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
	
}
