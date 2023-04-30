package br.fiap.app.mars.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.fiap.app.mars.models.Viagem;
import br.fiap.app.mars.repositories.ViagemRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/viagem")
public class ViagemController {
	@Autowired
	private ViagemRepository viagemRepository;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("viagem/index");
		List<Viagem> listaViagem = viagemRepository.findAll();
		model.addObject("viagens", listaViagem);
		return model;
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView model = new ModelAndView("viagem/create");
		return model;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Viagem> createForm(@Valid @RequestBody Viagem objViagem ){ 
		//Aqui calculamos a data de retorno, e garantimos que ela seja salva no formato
		//dd/MM/yyyy
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
		LocalDate dataPartida = LocalDate.parse(objViagem.getDataDecolagem(),fmt);
	    LocalDate dataRetorno = dataPartida.plusDays(520 + Integer.parseInt((objViagem.getDiasEstadia())));
	    objViagem.setDataDecolagem(dataPartida.format(fmt));
	    objViagem.setDataRetorno(dataRetorno.format(fmt));
		viagemRepository.save(objViagem);
		return new ResponseEntity<Viagem>(objViagem, HttpStatus.CREATED);
	}
	
	@GetMapping("/edit/{id}")
	public String getById(Model model, @PathVariable("id")Long idViagem) {
		Optional<Viagem> optionalViagem = viagemRepository.findById(idViagem);
		if(optionalViagem.isPresent()) {
			Viagem viagem = optionalViagem.get();
			model.addAttribute("viagem", viagem);
			return "viagem/edit";
		} else {
			return "/viagem";
		}
	}
	
	@PutMapping("/edit")
	public ResponseEntity<Viagem> updateForm(@Valid @RequestBody Viagem objViagem ){
		//Aqui calculamos a data de retorno, e garantimos que ela seja salva no formato
		//dd/MM/yyyy
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
		LocalDate dataPartida = LocalDate.parse(objViagem.getDataDecolagem(),fmt);
		LocalDate dataRetorno = dataPartida.plusDays(520 + Integer.parseInt((objViagem.getDiasEstadia())));
	    objViagem.setDataDecolagem(dataPartida.format(fmt));
	    objViagem.setDataRetorno(dataRetorno.format(fmt));
		viagemRepository.save(objViagem);
		return new ResponseEntity<Viagem>(objViagem, HttpStatus.OK);
	}
		
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		viagemRepository.deleteById(id);
		return "redirect:/viagem";
	}

}
