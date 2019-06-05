package com.epam.cwlhub.dao;

import com.epam.cwlhub.entities.group.Group;
import com.epam.cwlhub.entities.user.UserEntity;

import java.util.List;

public interface GroupDao extends BaseDao<Group> {

    List<Group> findUserGroupsByUserId(Long id);

    void joinGroup(Long user_id, Long group_id);

    void leaveGroup(Long user_id, Long group_id);

    boolean checkMembership(Long user_id, Long group_id);

}
