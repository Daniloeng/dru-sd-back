/*
*
* Projeto DRU de SD 2019
*
*
 */
package io.spring.service;

import io.spring.entity.Usuario;
import io.spring.repository.UsuarioRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Projeto DRU de SD 2019
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listaUsuario() {
        return usuarioRepository.findAll();
    }

    public Page<Usuario> listaPaginada(int count, int page) {
        Pageable pages = new PageRequest(page, count);
        return usuarioRepository.findAll(pages);
    }

    public List<Usuario> buscaPorNome(String nome) {
        return usuarioRepository.findByNomeLikeIgnoreCase(nome);
    }

    public Usuario salvarUsuario(Usuario usuarioAdd) {
        return usuarioRepository.save(usuarioAdd);
    }

    public void deleteUsuario(String id) {
        usuarioRepository.delete(id);
    }

    public Usuario getById(String id) {
        return usuarioRepository.findOne(id);
    }

}
