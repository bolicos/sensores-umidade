package org.springframework.samples.challenge.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.challenge.model.User;

public interface UserRepository {

    void save(User user) throws DataAccessException;
}
