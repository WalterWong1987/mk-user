package com.makeronly.user.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户资料
 * @author Walter Wong
 */
@Data
@XmlRootElement(name = "AuthModel")
public class UserProfile {
    @JsonSerialize(using = ToStringSerializer.class)
    @FormParam("id")
    private Long id;
    /**
     * 昵称
     */
    @FormParam("nickname")
    private String nickname;
    /**
     * 邮箱
     */
    @FormParam("email")
    private String email;
    /**
     * 手机号
     */
    @FormParam("phone")
    private String phone;
    /**
     * 头像
     */
    @FormParam("avatar")
    private String avatar;


    public UserProfile() {
    }
}
