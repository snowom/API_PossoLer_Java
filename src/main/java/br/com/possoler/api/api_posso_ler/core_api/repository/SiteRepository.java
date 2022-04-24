package br.com.possoler.api.api_posso_ler.core_api.repository;

import br.com.possoler.api.api_posso_ler.core_api.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer>{
    
}
