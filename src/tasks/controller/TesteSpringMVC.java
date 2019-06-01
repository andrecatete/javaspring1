package tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TesteSpringMVC {
	@RequestMapping("/testespring")		//criar depois do return - é o nome da pagina, logo deve-se colocar no final da url o "testespring"
	public String execute() {			//nome da página a ser retornada
		System.out.println("Testando Framework Spring");
		return "testando";				//nome do jsp - view response
		
	}
}
