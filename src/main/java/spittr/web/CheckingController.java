package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.db.SpittleRepository;
import spittr.domain.Manager;
import spittr.domain.Spitter;
import spittr.domain.Spittle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/checking")
public class CheckingController {
    @Autowired
    private SpittleRepository spittleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findNotCheckedRecent(count);
    }

    @RequestMapping(value = "/{spittleID}", method = POST)
    public String showSpitterProfile(@PathVariable String spittleID, HttpServletRequest request, HttpSession session) {

        /*
         * @PathVariable("xxx") 通过 @PathVariable
         * 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
         * 用于将请求URL中的模板变量映射到功能处理方法的参数上，即取出uri模板中的变量作为参数
         */
        System.out.println(request.getParameter("check"));
        System.out.println(spittleID);
        if (request.getParameter("check").equals("pass")) {
            spittleRepository.updatePassed(Long.parseLong(spittleID), (Manager) session.getAttribute("manager"));
        }else if (request.getParameter("check").equals("delete")){
            spittleRepository.delete(Long.parseLong(spittleID));
        }
        System.out.println("操作完成");
        return "redirect:/checking";
    }
}
