package com.yuanjingyu.realms;

import com.yuanjingyu.entity.Category;
import com.yuanjingyu.entity.User;
import com.yuanjingyu.service.BookService;
import com.yuanjingyu.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/*自定义一个realm,把数据库中查询出的信息返回到安全管理器*/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        UsernamePasswordToken t = (UsernamePasswordToken) authenticationToken;
        String email =(String) t.getPrincipal();

        //判断用户名是否为空
        if (email==null || email.length()<=0){
            throw new UnknownAccountException("用户名为空...");
        }else {
            User user = userService.getUserEmailByUser(email);
            if (email==null || user.getEmail()==null || user.getEmail().length()<=0 ){
                throw new UnknownAccountException("用户名不存在...");
            }else {
                //把盐值转成Byte类型
                String salt = user.getSalt();
                ByteSource bytes = ByteSource.Util.bytes(salt);
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getEmail(), user.getPassword(), bytes, getName());
                return info;
            }
        }
    }
}
