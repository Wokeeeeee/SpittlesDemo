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
    public List<Spittle> spittles(@RequestParam(value = "count", defaultValue = "20") int count, @RequestParam(value = "pageIndex" ,defaultValue = "1") int pageIndex,HttpSession session) {

        session.setAttribute("count",count);
        session.setAttribute("maxPage",(int)spittleRepository.countUncheck()/count+1);
        session.setAttribute("curPage",pageIndex);
        System.out.println("当前总页数："+(spittleRepository.countUncheck()/count+1)+"\n一页显示："+count+"\n当前页码："+pageIndex);
        return spittleRepository.findNotCheckedRecent(count, pageIndex-1);
    }

    @RequestMapping(value = "/jump",method = POST)
    public String jumpPage(@RequestParam(value = "pageIndex", defaultValue = "") int index,HttpSession session){
        session.setAttribute("pageIndex",index);
        return "checking";
    }

    @RequestMapping(value = "check/{spittleID}", method = POST)
    public String showSpitterProfile(@PathVariable String spittleID, HttpServletRequest request, HttpSession session) {
        System.out.println(request.getParameter("check"));
        System.out.println(spittleID);
        if (request.getParameter("check").equals("pass")) {
            spittleRepository.updatePassed(Long.parseLong(spittleID), (Manager) session.getAttribute("manager"));
        }
        else if (request.getParameter("check").equals("delete")) {
            spittleRepository.delete(Long.parseLong(spittleID));
        }
        System.out.println("操作完成");
        return "redirect:/checking";
    }
}
