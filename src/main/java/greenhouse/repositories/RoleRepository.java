package greenhouse.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import greenhouse.models.Role;

public interface RoleRepository extends Repository<Role, Integer>{
	Collection<Role> findAll() throws DataAccessException;
	Role findById(Integer id) throws DataAccessException;
	
	public void save(Role type) throws DataAccessException;
	public void delete(Role type) throws DataAccessException;
}
