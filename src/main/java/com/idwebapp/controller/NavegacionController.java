package com.idwebapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.idwebapp.repository.UsuarioRepository;

@Controller
public class NavegacionController {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/menu")
	public String menu(Model model) {

		// obtenemos el usuario
		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		// consultamos el nombre del usuario
		String nombre = usuarioRepo.buscarNombrePorUsuario(name);

		// enviamos el nombre al menu.jsp
		model.addAttribute("nombre", nombre);

		return "secure/menu";
	}

	@RequestMapping("/denegado")
	public String demegado() {
		return "no_autorizado";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {

		if (error != null) {
			model.addAttribute("msm", "Credenciales incorrectas");
		}

		return "login";
	}

	@PostMapping(path = "/menu/testing")
	public ResponseEntity<?> test() {

		Map<String, String> map = new HashMap<>();
		map.put("name", "Crismetal");

		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
