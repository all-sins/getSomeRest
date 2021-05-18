package com.codemonkeys.getSomeRest.DTOMapper;

import com.codemonkeys.getSomeRest.DTO.UserLeastInfo;
import com.codemonkeys.getSomeRest.DTO.UserLessInfo;
import com.codemonkeys.getSomeRest.Entities.User;

public class DTOMapper {

    public UserLessInfo mapUserToUserLessInfo(User user) {

        UserLessInfo userLessInfo = new UserLessInfo();

        userLessInfo.setDateCreated(user.getDateCreated());
        userLessInfo.setRoles(user.getRoles());
        userLessInfo.setUsername(user.getUsername());

        return userLessInfo;

    }

    public UserLeastInfo mapUserToUserLeastInfo(User user) {

        UserLeastInfo userLeastInfo = new UserLeastInfo();

        userLeastInfo.setDateCreated(user.getDateCreated());
        userLeastInfo.setUsername(user.getUsername());

        return userLeastInfo;

    }

}
