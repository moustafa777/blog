package com.mum.ea.service;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mum.ea.dao.RoleDAO;
import com.mum.ea.dao.UserDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserDAO appUserDAO;
 
    @Autowired
    private RoleDAO appRoleDAO;
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//    	User appUser = this.appUserDAO.find
 
//        if (appUser == null) {
//            System.out.println("User not found! " + userName);
//            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
//        }
// 
//        System.out.println("Found User: " + appUser);
// 
//        // [ROLE_USER, ROLE_ADMIN,..]
//        List<String> roleNames = this.appRoleDAO.getRoleNames(appUser.getUserId());
// 
//        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        if (roleNames != null) {
//            for (String role : roleNames) {
//                // ROLE_USER, ROLE_ADMIN,..
//                GrantedAuthority authority = new SimpleGrantedAuthority(role);
//                grantList.add(authority);
//            }
//        }
 
//        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), 
//                appUser.getEncrytedPassword(), grantList);
        UserDetails userDetails = (UserDetails) new User();
 
        return userDetails;
    }

}
