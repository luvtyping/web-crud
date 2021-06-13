package crud.web.controllers;

import crud.web.dao.UserDaoImpl;
import crud.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDaoImpl userDao;

    @Autowired
    public UserController(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String indexPage(Model model) {
        model.addAttribute("users", userDao.getUsers());
        return "index";
    }

    @GetMapping("/{id}/edit")
    public String editPage(Model model, @PathVariable int id) {
        model.addAttribute("user", userDao.getUser(id));
        return "edit";
    }

    @GetMapping("/create")
    public String createUserPage(@ModelAttribute User user) {
        return "create";
    }

    @PostMapping()
    public String create(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "create";

        userDao.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable int id, Model model) {
        model.addAttribute("user", userDao.getUser(id));
        return "info";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";

        userDao.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userDao.delete(id);
        return "redirect:/users";
    }
}
