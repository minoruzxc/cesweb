
package com.pi.ces.repository;

import com.pi.ces.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    
}
