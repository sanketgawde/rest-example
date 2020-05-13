package com.msprime.crudservice.service;

import com.msprime.crudservice.mapper.UserMapper;
import com.msprime.crudservice.model.UserEntity;
import com.msprime.crudservice.model.UserJson;
import com.msprime.crudservice.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserJson getUser(String userId) {
        UserEntity userEntity = null;
        UserJson userJson = null;
        if(userRepository.findById(Long.parseLong(userId)).isPresent()) {
            userEntity = userRepository.findById(Long.parseLong(userId)).get();
        }
        if(userEntity != null) {
            userJson = userMapper.userEntityToUserJson(userEntity);
        }
        return userJson;
    }

    @Override
    public List<UserJson> getUserList() {
        List<UserJson> userEntityList = new ArrayList<>();
        userRepository.findAll().forEach(userEntity -> userEntityList.add(userMapper.userEntityToUserJson(userEntity)));
        return userEntityList;
    }

    @Override
    public UserJson addUser(UserJson userJson) {
        UserEntity userEntity = userRepository.save(userMapper.userJsonToUserEntity(userJson));
        return userMapper.userEntityToUserJson(userEntity);
    }
}
