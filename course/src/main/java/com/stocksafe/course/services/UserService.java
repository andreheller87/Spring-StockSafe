package com.stocksafe.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocksafe.course.entities.Usuario;
import com.stocksafe.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<Usuario> findAll() {
		return userRepository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = userRepository.findById(id);
		return obj.get();

	}

	public Usuario insert(Usuario obj) {

		return userRepository.save(obj);
	}

	public void delete(Long id) {

		userRepository.deleteById(id);
	}
	
	public Usuario update(Long id,Usuario obj) {
		Usuario entity = userRepository.getReferenceById(id);
		updateData(entity,obj);
		return userRepository.save(entity);
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setSenha(obj.getSenha());
		entity.setNivelAcesso(obj.getNivelAcesso());
		
	}

}
