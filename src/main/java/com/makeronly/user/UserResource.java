package com.makeronly.user;

import com.makeronly.common.bean.ResultBean;
import com.makeronly.user.domain.User;
import com.makeronly.user.domain.UserProfile;
import com.makeronly.user.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * User resource
 * @author Walter Wong
 */
@Component
@Path("/user")
public class UserResource {
    //返回类型及编码
    private static final String APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=UTF-8";

    @Resource(name = "bsp.UserService")
    private UserService service;

    /**
     * 获取用户
     * @param identifier    用户登录标识
     * @return  ResultBean<User>
     */
    @GET
    @Path("/{identifier}")
    @Produces(APPLICATION_JSON)
    public ResultBean<User> getUserInfo(@PathParam("identifier")String identifier){
        User u = service.getByIdentifier(identifier);
        return new ResultBean<>(u);
    }

    @GET
    @Produces(APPLICATION_JSON)
    public ResultBean<List<UserProfile>> getUsers(){
        List<UserProfile> list = service.getUsers();
        return new ResultBean<>(list);
    }

    /**
     * 新建用户
     * @param user  用户资料
     * @param credential    密码凭证
     * @return  ResultBean<UserProfile> 用户资料
     * @throws Exception 异常
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultBean<UserProfile> save(@BeanParam UserProfile user, @FormParam("credential") String credential) throws Exception {
        return new ResultBean<>(service.save(user,credential));
    }

    /**
     * 删除用户信息
     *
     * @param id    用户ID
     * @return  1表示删除成功
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultBean<Integer> delete(@QueryParam("id") Long id){
        return new ResultBean<>(service.delete(id));
    }
    /**
     * 更新用户头像
     * @param user  用户信息
     * @return  ResultBean<Integer>
     */
    @PUT
    @Path("/avatar")
    public ResultBean<Integer> updateAvatar(@FormParam("avatar")String avatar) {
        //System.out.println(JSONObject.toJSONString(user));
        System.out.println(avatar);
        // service.updateAvatar(user)
        return new ResultBean<>();
    }
}
