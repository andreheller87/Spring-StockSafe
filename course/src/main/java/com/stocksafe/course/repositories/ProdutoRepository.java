package com.stocksafe.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocksafe.course.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
