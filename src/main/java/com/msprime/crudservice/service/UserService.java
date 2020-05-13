package com.msprime.crudservice.service;

import com.msprime.crudservice.model.UserJson;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserJson getUser(String userId);

    List<UserJson> getUserList();

    UserJson addUser(UserJson userJson);

}
