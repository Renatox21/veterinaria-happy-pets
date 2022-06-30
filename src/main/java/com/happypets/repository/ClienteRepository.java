package com.happypets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.happypets.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepositoryImplementation<Cliente, Integer> {

	@Query("select c from Cliente c where nombre like %:nomCli%")
	public abstract List<Cliente> buscarClienteProNombre(@Param("nomCli")String nombre);
	
}
