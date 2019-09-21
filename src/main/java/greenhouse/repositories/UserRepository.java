package greenhouse.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import greenhouse.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	Optional<User> findByUsername(String username);
	
	Collection<User> findAll() throws DataAccessException;
	
	User findByPassword(@Param("password") String password) throws DataAccessException;

}
