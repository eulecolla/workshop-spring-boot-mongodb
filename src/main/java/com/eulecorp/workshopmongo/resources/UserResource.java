package com.eulecorp.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eulecorp.workshopmongo.domain.User;
import com.eulecorp.workshopmongo.dto.UserDTO;
import com.eulecorp.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

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
//	public ResponseEntity<List<User>> findAll(){
//		User maria = new User("1", "Maria Brown", "maria@gmail.com");
//		User alex = new User("2", "Alex Green", "alex@gmail.com");
//		List<User> list = new ArrayList<>();
//		list.addAll(Arrays.asList(maria, alex));
//		return ResponseEntity.ok().body(list);
//	}
	
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
