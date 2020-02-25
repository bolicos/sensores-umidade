package greenhouse.repositories;

import greenhouse.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	Optional<User> findByUsername(String username);
	User findByPassword(@Param("password") String password);

}
