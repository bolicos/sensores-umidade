package greenhouse.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import greenhouse.models.Strawberry;

public interface StrawberryRepository extends Repository<Strawberry, Integer>{
	Collection<Strawberry> findAll() throws DataAccessException;
	Strawberry findById(Integer id) throws DataAccessException;
	Collection<Strawberry> findByName(String name) throws DataAccessException;
	
	public void save(Strawberry strawberry) throws DataAccessException;
	public void delete(Strawberry strawberry) throws DataAccessException;
}
