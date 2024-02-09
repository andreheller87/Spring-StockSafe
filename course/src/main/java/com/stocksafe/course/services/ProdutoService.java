package com.stocksafe.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocksafe.course.entities.Produto;
import com.stocksafe.course.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto findById(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElse(null);
	}

	public Produto insert(Produto obj) {
		return produtoRepository.save(obj);
	}

	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}

	public Produto update(Long id, Produto obj) {
		Produto entity = produtoRepository.getReferenceById(id);
		updateData(entity, obj);
		return produtoRepository.save(entity);
	}

	private void updateData(Produto entity, Produto obj) {
		entity.setCodLote(obj.getCodLote());
		entity.setNome(obj.getNome());
		entity.setValor(obj.getValor());
		entity.setData(obj.getData());
		entity.setValidade(obj.getValidade());
		entity.setQuantidade(obj.getQuantidade());
		entity.setObservacao(obj.getObservacao());
		entity.setArmazenamento(obj.getArmazenamento());
	}
}
