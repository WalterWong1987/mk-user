package com.makeronly.user.repo;

import com.makeronly.user.domain.User;
import com.makeronly.user.domain.UserProfile;

import java.util.List;

/**
 * @author Walter Wong
 */
public interface UserMapper {

    /**
     * 根据登录标识获取用户
     * @param identifier
     * @return
     */
    User getByIdentifier(String identifier);

    List<UserProfile> getUsers();

    /**
     * 保存用户资料信息
     * @param profile
     */
    int saveProfile(UserProfile profile);

    /**
     * 创建用户
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 删除用户信息
     * @param id    用户主键
     * @return  1表示删除成功
     */
    int delete(Long id);

    /**
     * 更新用户头像
     * @param user    用户信息
     * @return  1表示成功，其他表示失败
     */
    int updateAvatar(UserProfile user);
}
