package com.makeronly.user.domain;

import lombok.Data;
import java.io.Serializable;

/**
 * 用户
 * @author Walter Wong
 */
@Data
public class User implements Serializable{

    private static final long serialVersionUID = -8029943404641368747L;

    private Long id;
    /**
     * 用户编码
     */
    private Long userId;
    /**
     * 登录类型（手机号 邮箱 用户名）或第三方应用名称（微信 微博等）
     */
    private String identityType;
    /**
     * 标识（手机号 邮箱 用户名或第三方应用的唯一标识）
     */
    private String identifier;
    /**
     * 密码凭证（站内的保存密码，站外的不保存或保存token）
     */
    private String credential;
    /**
     * 用户详细资料
     */
    private UserProfile profile;

    public User() {
    }

    public User(Long id, Long userId, String identityType, String identifier, String credential) {
        this.id = id;
        this.userId = userId;
        this.identityType = identityType;
        this.identifier = identifier;
        this.credential = credential;
    }
}
