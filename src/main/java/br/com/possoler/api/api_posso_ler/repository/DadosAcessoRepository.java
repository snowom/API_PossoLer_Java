package br.com.possoler.api.api_posso_ler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.possoler.api.api_posso_ler.entity.DadosAcesso;

@Repository
public interface DadosAcessoRepository extends JpaRepository<DadosAcesso, Long>{
    
}
