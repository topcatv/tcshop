package com.tcshop.security;

import com.tcshop.entity.User;
import com.tcshop.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	public SystemAuthorizingRealm(CacheManager ehCacheManager){
		this.setCacheManager(ehCacheManager);
	}

    @Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		User user = userService.findByLoginName(t.getUsername());
		if(null != user) {
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
			info.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
			return info;
		}
		return null;
	}

	/**
	 * 获取授权信息
	 * 
	 * @param principals
	 *            principals
	 * @return 授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("SHA-256");
		matcher.setHashIterations(1024);
		matcher.setStoredCredentialsHexEncoded(false);
		setCredentialsMatcher(matcher);
	}
}