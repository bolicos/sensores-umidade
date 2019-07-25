package greenhouse.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import greenhouse.models.User;

public interface UserRepository extends Repository<User, Integer>{
	Collection<User> findAll() throws DataAccessException;
	Collection<User> findByFirstName(@Param("first_name") String firstName) throws DataAccessException;
	User findByUserName(@Param("userName") String userName) throws DataAccessException;
	public void save(User user) throws DataAccessException;
	public void delete(User user) throws DataAccessException;



}
