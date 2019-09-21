package greenhouse.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import greenhouse.models.User;
import greenhouse.repositories.UserRepository;

@Service
public class AuthenticateService implements UserDetailsService{
	
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String user){
		Optional<User> usuario= repository.findByUsername(user);
		if(usuario.isPresent())	{return usuario.get();}
		else {throw new UsernameNotFoundException("Dados Inválidos");}
	}

}
