package com.msprime.crudservice.repository;

import com.msprime.crudservice.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
