package com.testerodarte.Controllers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testerodarte.Models.Alunos;
import com.testerodarte.Repository.AlunosRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("alunos")
public class AlunosController {
	
	@Autowired
	private AlunosRepository alunosRepository;
	
	@GetMapping
	public ResponseEntity searchAll(
			@RequestParam(name = "orderby", defaultValue = "nome", required = false ) String orderby,
			@RequestParam(name = "average", defaultValue = "true", required = false ) boolean average
		) {
		List<Alunos> listaAlunos;
		switch(orderby) {
			case "nome":
				listaAlunos = alunosRepository.findAllSortedByName(Sort.by(orderby));
				break;
			default:
				listaAlunos = alunosRepository.findAllSortedByName(Sort.by(orderby));
				break;
		}
		if(average) {
		}
		return ResponseEntity.ok(listaAlunos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity searchById(@PathVariable BigInteger id) {
		Optional<Alunos> aluno = alunosRepository.findById(id);
		if(aluno.isPresent()) {
			return ResponseEntity.ok(aluno.get());			
		}else {
			return (ResponseEntity<Alunos>) ResponseEntity.notFound();
		}
	}
	
	@PostMapping
	public ResponseEntity insert(@RequestBody Alunos aluno) {
		alunosRepository.save(aluno);
		return ResponseEntity.ok(aluno);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable BigInteger id, @RequestBody Alunos aluno) {
		aluno.setIdentificacao(id);
		Optional<Alunos> alunoById = alunosRepository.findById(id);
		if(alunoById.isPresent()) {
			alunosRepository.save(aluno);			
			return ResponseEntity.ok(aluno);
		}else {
			return (ResponseEntity<Alunos>) ResponseEntity.notFound();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable BigInteger id) {
		alunosRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
