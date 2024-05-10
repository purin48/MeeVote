package today.meevote.domain.etc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import today.meevote.exception.view.UnauthenticatedException;
import today.meevote.exception.view.NotFoundException;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ViewController {
	
	@GetMapping("error/notfound")
	public String notFound() {
		return "error/notfound";
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/calendar";
	}

	@GetMapping("/calendar")
	public String getMethodName() {
		return "calendar/calendar";
	}
	

	@GetMapping("/table")
	public String table() {
		return "table/table";
	}

	@GetMapping("/create-personal")
	public String createPersonalSchedule() {
		return "create/personal";
	}

	@GetMapping("/create-group")
	public String createGroupSchedule() {
		return "create/group";
	}
	
	
	@GetMapping("/register")
	public String register() {
		return "register/register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
}
