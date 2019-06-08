package tasks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tasks.dao.TaskDao;
import tasks.modelo.Task;

@Controller
public class TasksController {
	
	private final TaskDao dao;
	
	@Autowired					// 08/06
	public TasksController(TaskDao dao) {
//		dao = new TaskDao();		o @Autowired faz isso
		this.dao = dao;			// 08/06
	}
	
	@RequestMapping("novatask")					//escreve essa linha depois de colocar o return na linha abaixo da debaixo;
	public String form() { 						//serve para mostrar a pagina de destino
		return "tasks/form-tasks";
	}
	
	@RequestMapping("cadastratask")
	public String cadastra(@Valid Task task, BindingResult result) {	//sem o BindingResult -> retorna exceção, com o BindingResult -> pega o resultado e joga na pagina;
	//TaskDao dao = new TaskDao();
		if(result.hasFieldErrors("descricao")) {  	// se for usar o "BindingResult"  
			return "tasks/form-tasks";
		}
		dao.inserir(task);
		return "tasks/task-cadastrada";
	}
	
	@RequestMapping("gettasks") //teste
//	primeira opção usando model and view
//	public String getTasks() {
//		List<Task> task = dao.getTasks();
//		
//		ModelAndView mv = new ModelAndView("tasks/get-tasks");
//		mv.addObject("tasks", tasks);
//		return mv;
	public String getTasks(Model model) {
		List<Task> tasks = dao.getTasks();
		model.addAttribute(tasks);
		model.addAttribute("tasks", dao.getTasks());
//		return "tasks/get-tasks";
//		return "tasks/get-tasks-ajax";
		return "tasks/get-tasks-ajax2";
	}	
	
	@RequestMapping("excluitask")
	public String exclui(Task task) {
		dao.exclui(task);
//		redirecionamento client side
		return "redirect:gettasks";
	}
	
	@RequestMapping("buscartask")
	public String busca(Long id, Model model) {
		model.addAttribute("task", dao.getById(id));
		return "tasks/busca-task";
	}
	
	@RequestMapping("editatask")
	public String edita(Task task) {
		dao.edita(task);
		return "redirect:gettasks";
	}
	
//	@RequestMapping("finalizatask")
//	public void finaliza(Long id) {
//		dao.finaliza(id);		
//	}
	
	@ResponseBody
	@RequestMapping("finalizatask")
	public void finaliza(Long id) {
		dao.finaliza(id);		
	}
	
}
