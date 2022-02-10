package com.testerodarte.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.testerodarte.Models.Alunos;

@Repository
public interface AlunosRepository extends CrudRepository<Alunos, BigInteger> {
	
	@Query(value = "select new com.testerodarte.Models.Alunos(a.nome, a.idade, ((a.nota_1 + a.nota_2 + a.nota_3) / 3) as media) from Alunos a")
	public List<Alunos> findAllSortedByName(Sort sort);
}
