package com.fylx.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fylx.entity.User;
import com.fylx.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name = principalCollection.getPrimaryPrincipal().toString();
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("Username", name));
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("admin");
        info.addStringPermission("insert");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken.getPrincipal() == null) return null;

        String name = authenticationToken.getPrincipal().toString();
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("Username", name));
        if (user == null) return null;

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(name, user.getPassword(), getName());
        return info;
    }
}
