package com.unidade4.atividade6.controller;

import com.unidade4.atividade6.model.Cidadao;
import com.unidade4.atividade6.repository.CidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CidadaoController {

    @Autowired
    private CidadaoRepository cidadaoRepository;

    @GetMapping("/cidadaos")
    public ResponseEntity<List<Cidadao>> getTodosCidadaos(){
        try {
            List<Cidadao> resposta =  cidadaoRepository.findAll();
            if(resposta != null){
                return new ResponseEntity<>(resposta, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/cidadao")
    public ResponseEntity<Cidadao> createCidadao(@Valid @RequestBody Cidadao cidadao){
        try{
            Cidadao resposta = cidadaoRepository.save(cidadao);
            return new ResponseEntity<>(resposta, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cidadao/{id}")
    public ResponseEntity<Cidadao> editCidadao(@Valid @PathVariable("id") String id, @RequestBody Cidadao input){
        Optional<Cidadao> verificaId = cidadaoRepository.findById(id);

        if(verificaId.isPresent()){
            Cidadao cidadao = verificaId.get();
            cidadao.setCidade(input.getCidade());
            cidadao.setBairro(input.getBairro());
            cidadao.setCep(input.getCep());
            cidadao.setCpf(input.getCpf());
            cidadao.setEstado(input.getEstado());
            cidadao.setLogradouro(input.getLogradouro());
            cidadao.setNome(input.getNome());
            cidadao.setSexo(input.getSexo());
            return new ResponseEntity<>(cidadaoRepository.save(cidadao), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/cidadao/{id}")
    public ResponseEntity<Cidadao> deleteCidadao(@Valid @PathVariable("id") String id){
        try {
            cidadaoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
