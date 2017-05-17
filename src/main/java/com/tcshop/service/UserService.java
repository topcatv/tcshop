package com.tcshop.service;

import com.tcshop.entity.User;
import com.tcshop.mapper.UserMapper;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by topcat on 2017/4/13.
 */
@Service
@Transactional
public class UserService extends BaseService<User> {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public User findByLoginName(String loginName) {
        User u = new User();
        u.setLoginName(loginName);
        return userMapper.selectOne(u);
    }

    public void register(User user) {
        String salt = generateSalt();

        String hashedPasswordBase64 = new Sha256Hash(user.getPassword(), salt, 1024).toBase64();

        user.setPassword(hashedPasswordBase64);
        user.setSalt(salt);

        userMapper.insert(user);
    }

    private String generateSalt(){
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes().toHex();
        return hex;
    }

    public static void main(String[] args) {
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String salt = secureRandom.nextBytes().toHex();

        String hashedPasswordBase64 = new Sha256Hash("111111", salt, 1024).toBase64();

        System.out.println(hashedPasswordBase64);
        System.out.println(salt);
    }

    public void update(Integer id, User user) {
        user.setId(id);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
