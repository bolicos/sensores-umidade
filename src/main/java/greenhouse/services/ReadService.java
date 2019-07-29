package greenhouse.services;

import org.springframework.dao.DataAccessException;

import greenhouse.models.Read;

public interface ReadService {

	Read saveRead(Read read) throws DataAccessException;

}

