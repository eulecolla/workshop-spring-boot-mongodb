package com.eulecorp.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eulecorp.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
// OU PODE USAR SIMPLESMENTE @GetMapping
//	public List<User> findAll(){
//		User maria = new User("1", "Maria Brown", "maria@gmail.com");
//		User alex = new User("2", "Alex Green", "alex@gmail.com");
//		List<User> list = new ArrayList<>();
//		list.addAll(Arrays.asList(maria, alex));
//		return list;
//	}
	
// Para encapsular toda a resposta com possíveis cabeçalhos, body, erros, etc. tem que usar o 	
// ResponseEntity<T>
// e mudar o return com as infos  adicionais necessárias
	
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}
	
}
