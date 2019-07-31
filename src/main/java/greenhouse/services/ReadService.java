package greenhouse.services;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import greenhouse.models.Read;

@Service
public interface ReadService {

	Read saveRead(Read read) throws DataAccessException;

}

