package com.makeronly.user.service;

import com.makeronly.common.snowflake.IdGenerator;
import com.makeronly.user.domain.User;
import com.makeronly.user.domain.UserProfile;
import com.makeronly.user.repo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import javax.ws.rs.BeanParam;
import java.util.List;

/**
 * @author Walter
 */
@Service("bsp.UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper mapper;

    @BeanParam
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /**
     * 根据登录标识获取用户
     *
     * @param identifier
     * @return
     */
    @Override
    public User getByIdentifier(String identifier) {
        System.out.println(identifier);
        return mapper.getByIdentifier(identifier);
    }

    @Override
    public List<UserProfile> getUsers() {
        return mapper.getUsers();
    }

    @Transactional
    @Override
    public UserProfile save(UserProfile profile,String credential) throws Exception {
        // 生成用户主键
        Long id = IdGenerator.INSTANCE.getId();
        profile.setId(id);
        UserProfile p = null;
        //保存用户资料
        mapper.saveProfile(profile);

        // 密码加密
        credential = passwordEncoder().encode(credential);

        // 创建邮箱用户
        if (!StringUtils.isEmpty(profile.getEmail())) {
            User u = new User(IdGenerator.INSTANCE.getId(),id,"email",profile.getEmail(),credential);
            mapper.saveUser(u);
        }

        // 创建手机用户
        if (!StringUtils.isEmpty(profile.getPhone())) {
            User u = new User(IdGenerator.INSTANCE.getId(),id,"phone",profile.getPhone(),credential);
            mapper.saveUser(u);
        }
        p = profile;
        return p;
    }

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 1表示删除成功
     */
    @Override
    @Transactional
    public int delete(Long id) {
        return mapper.delete(id);
    }

    /**
     * 更新用户头像
     * @param user    用户信息
     * @return  1表示成功，其他表示失败
     */
    @Override
    @Transactional
    public int updateAvatar(UserProfile user) {
        return mapper.updateAvatar(user);
    }

}
