package com.stocksafe.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocksafe.course.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

}
