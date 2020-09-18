package com.semiha.cookbook.serviceImpl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.Errors;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.semiha.cookbook.classes.RegistrationModel;
import com.semiha.cookbook.entity.User;
import com.semiha.cookbook.repository.UserRepository;
import com.semiha.cookbook.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	private ModelMapper modelMapper;

	@Override
	public void register(RegistrationModel registrationModel) {
		User user = this.modelMapper.map(registrationModel, User.class);
		String encryptedPassword = this.bCryptPasswordEncoder.encode(registrationModel.getPassword());
		user.setPassword(encryptedPassword);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setEnabled(true);
		user.setCredentialsNonExpired(true);
		this.userRepository.save(user);

	}

	@Override
	public void delete() {
		System.out.println("DELETE TOPIC");
	}

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = (User) this.userRepository.findUserByUsername(username);
		if (user == null) {
			Collection<ErrorMessage> errorMessages = null;
			String heading = null;
			throw new UsernameNotFoundException(Errors.format(heading, errorMessages));
		}

		return user;
	}
}
