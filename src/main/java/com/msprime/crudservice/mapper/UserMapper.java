package com.msprime.crudservice.mapper;

import com.msprime.crudservice.model.UserEntity;
import com.msprime.crudservice.model.UserJson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity userJsonToUserEntity(UserJson userJson);
    UserJson userEntityToUserJson(UserEntity userEntity);

}
