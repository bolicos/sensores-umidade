package org.springframework.samples.challenge.repository.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.Repository;
import org.springframework.samples.challenge.model.User;
import org.springframework.samples.challenge.repository.UserRepository;

@Profile("spring-data-jpa")
public interface SpringDataUserRepository extends UserRepository, Repository<User, Integer>  {

}
