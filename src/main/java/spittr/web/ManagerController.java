package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import spittr.db.ManagerRepository;
import spittr.domain.Manager;

/**
 * 吐槽者控制类
 *
 * @author wben
 * @version v1.0
 */
@Controller
/*
 * 将Model中的spitter参数保存到了session中（如果Model中没有spitter参数，而session中存在一个spitter参数，
 * 那么SessionAttribute会讲这个参数塞进Model中） SessionAttribute只能作用在类上。
 *
 * 将Model中的被注解的attrName属性保存在一个SessionAttributesHandler中，在每个RequestMapping的方法执行后，
 * 这个SessionAttributesHandler都会将它自己管理的“属性”从Model中写入到真正的HttpSession；同样，
 * 在每个RequestMapping的方法执行前，
 * SessionAttributesHandler会将HttpSession中的被@SessionAttributes注解的属性写入到新的Model中。
 */
@SessionAttributes({"manager"})
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;

    @RequestMapping(value = "/login", method = GET)
    public String showLoginForm() {
        return "managerLoginForm";
    }

    @RequestMapping(value = "/login", method = POST)
    public String processLogin(@RequestParam(value = "userName", defaultValue = "") String userName,
                               @RequestParam(value = "password", defaultValue = "") String password, HttpSession session) {
        /*
         * @RequestParam注解：
         *
         * value：参数名字，即入参的请求参数名字，如userName表示请求的参数区中的名字为userName的参数的值将传入；
         *
         * required：是否必须，默认是true，表示请求中一定要有相应的参数，否则将报404错误码；
         *
         * defaultValue：默认值，表示如果请求中没有同名参数时的默认值
         *
         */

        Manager manager = managerRepository.findByUserName(userName, password);
        if (manager != null) {
            session.setAttribute("manager", manager);
            return "redirect:/manager/home";
        }
        else {
            return "loginError";
        }

    }
    @RequestMapping(value = "/home", method = GET)
    public String getHomePage(Model model) {
        model.addAttribute(new Manager());
        return "managerHome";
    }

    /**
     * 进入注册
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Manager());
        return "managerRegisterForm";
    }

    /**
     * 提交注册信息，提交成功后跳转到用户信息
     *
     * @param manager
     * @param errors
     * @return
     */
    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(@Valid Manager manager, Errors errors) {
        if (errors.hasErrors()) {
            return "managerRegisterForm";
        }

        managerRepository.save(manager);
        return "redirect:/manager/" + manager.getUserName();
    }


    /**
     * 用户信息页面
     *
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping(value = "/{userName}", method = GET)
    public String showManagerProfile(@PathVariable String userName, Model model) {
        /*
         * @PathVariable("xxx") 通过 @PathVariable
         * 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
         * 用于将请求URL中的模板变量映射到功能处理方法的参数上，即取出uri模板中的变量作为参数
         */

        Manager manager = managerRepository.findByUserName(userName);
        if (manager != null) {
            model.addAttribute(manager);
            return "managerProfile";
        }
        else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/work", method = GET)
    public String showManagerPage() {
        return "checking";
    }

    @RequestMapping(value = "/list", method = GET)
    public String getManagerList() {
        return "managerList";
    }

    @RequestMapping(value = "/list", method = POST)
    public String processList() {
        return "managerList";
    }

    @RequestMapping(value = "/delete/{id}", method = POST)
    public String processDelete(@RequestParam String id,HttpSession session) {
        if (((Manager)session.getAttribute("manager")).getId()==Long.parseLong(id)){
            System.out.println("you can not delete yourself");
        }else {
            managerRepository.delete(Long.parseLong(id));
        }
        return "managerList";
    }

    @RequestMapping(value = "/update", method = GET)
    public String getUpdatePage() {
        return "managerInfoUpdate";
    }

    @RequestMapping(value = "/update", method = POST)
    public String processUpdate(HttpSession session,HttpServletRequest request) {
        Manager manager=(Manager)session.getAttribute("manager");
        manager.setFullname(request.getParameter("fullname"));
        manager.setEmail(request.getParameter("email"));
        manager.setPhoneNo(request.getParameter("phoneNo"));
        manager.setUserName(request.getParameter("userName"));
        manager.setPassword(request.getParameter("password"));
        managerRepository.update(manager);
        return "managerProfile";
    }
}
