package com.fa.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fa.edu.entities.AppUser;
import com.fa.edu.entities.UserCustomDetail;
import com.fa.edu.repository.AppRoleRepository;
import com.fa.edu.repository.AppUserRepository;
import com.fa.edu.repository.UserRoleRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;

	@SuppressWarnings("unused")
	@Autowired
	private AppRoleRepository appRoleRepository;

	@SuppressWarnings("unused")
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = appUserRepository.findByUsername(username);
		if (appUser == null) {
			throw new UsernameNotFoundException("not found username is" + username);
		}
		UserCustomDetail userCustomDetail = new UserCustomDetail(username, appUser.getPassword(), appUser.isEnable(),
				getAuthorities(appUser.getId()));
		return userCustomDetail;
	}
	
	private List<GrantedAuthority> getAuthorities(long userId){
		List<GrantedAuthority> granAuthorities = new ArrayList<GrantedAuthority>();
			String roleName = "ROLE_" + "ADMIN";
			GrantedAuthority authority = 
					new SimpleGrantedAuthority(roleName);
			granAuthorities.add(authority);
			roleName = "ROLE_" + "USER";
			authority = 
					new SimpleGrantedAuthority(roleName);
			granAuthorities.add(authority);
		return granAuthorities;
	}

}
