package greenhouse.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import greenhouse.models.Type;

public interface TypeRepository extends Repository<Type, Integer>{
	Collection<Type> findAll() throws DataAccessException;
	Type findById(Integer id) throws DataAccessException;
	
	public void save(Type type) throws DataAccessException;
	public void delete(Type type) throws DataAccessException;
}
