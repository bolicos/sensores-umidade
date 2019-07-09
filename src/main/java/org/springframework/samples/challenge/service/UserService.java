package org.springframework.samples.challenge.service;

import org.springframework.samples.challenge.model.User;

public interface UserService {

    void saveUser(User user) throws Exception;
}
