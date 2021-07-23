package com.cadastrouser.appcad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastrouser.appcad.models.User;
import com.cadastrouser.appcad.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/Users")
@Api(value="CRUD DE USUARIOS")
@CrossOrigin(origins="*")
public class UserController {

	@Autowired
	UserRepository ur;
	
	@GetMapping
	@ApiOperation(value="retorna todos os usuários")
	public List<User> listar() {
		return ur.findAll();
	}
	
	@PostMapping
	@ApiOperation(value="adiciona usuários")
	public User adicionar(@RequestBody User us) {
		return ur.save(us);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="atualiza usuários")
	public User atualiza(@RequestBody User us, @PathVariable Integer id) {
		return ur.findById(id).map(user -> {
			user.setName(us.getName());
			user.setEmail(us.getEmail());
			user.setEmail(us.getEmail());
			return ur.save(user);
		}).orElseGet(() ->{
			us.setId(id);
			return ur.save(us);
		});
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="exclui usuários")
	public void excluir(@PathVariable Integer id) {
		ur.deleteById(id);
	}
	

	
	
	
}
