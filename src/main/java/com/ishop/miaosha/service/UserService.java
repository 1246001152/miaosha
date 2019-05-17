package com.ishop.miaosha.service;

import com.ishop.miaosha.dao.UserDao;
import com.ishop.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUserById(Integer id){
        return userDao.getUserById(id);
    }

    @Transactional
    public boolean tx() {
        User u1 =  new User();
        u1.setId(111);
        u1.setName("111111111");
        int i1 = userDao.insert(u1);
        User u2 =  new User();
        u2.setId(222);
        u2.setName("222222222");
        int i2 = userDao.insert(u2);
        return true;
    }
}
