package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.sevice.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HelloController {
	private final UserService userService;


	@Autowired
	public HelloController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping()
	public String index(Model model) {
		model.addAttribute("user_list", userService.index());
		return "users";
	}

	@GetMapping("/id")
	public String show(Model model, @RequestParam("id") long id) {
		model.addAttribute("user", userService.show(id));
		return "users";
	}

	@GetMapping("/new")
	public String save(Model model) {
		model.addAttribute("user", new User());
		return "new";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "new";
		userService.save(user);
		return "redirect:/";
	}

	@GetMapping("/id/edit")
	public String edit(@RequestParam("id") long id, Model model) {
		model.addAttribute("user", userService.show(id));
		return "edit";
	}

	@PostMapping("/id/update")
	public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "edit";
		userService.update(user);
		return "redirect:/";
	}

	@PostMapping("/id/delete")
	public String delete(@RequestParam("id") long id) {
		userService.delete(id);
		return "redirect:/";
	}
}
