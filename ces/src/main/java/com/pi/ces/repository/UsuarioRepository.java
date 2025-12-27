
package com.pi.ces.repository;

import com.pi.ces.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    
}
