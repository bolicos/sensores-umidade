package greenhouse.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import greenhouse.models.Read;

public interface ReadRepository extends Repository<Read, Integer>{
	Collection<Read> findAll() throws DataAccessException;
	Read findById(Integer id) throws DataAccessException;
	
	public void save(Read read) throws DataAccessException;
	public void delete(Read read) throws DataAccessException;
}