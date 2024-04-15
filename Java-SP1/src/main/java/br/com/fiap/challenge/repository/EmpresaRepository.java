package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}