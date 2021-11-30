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

/**
 * 审核表单类
 * 管理员在这里进行对吐槽贴的审核操作
 */
@Controller
@RequestMapping("/checking")
public class CheckingController {
    @Autowired
    private SpittleRepository spittleRepository;

    /**
     * 页面显示个数和当前显示页面
     * 用于分页
     */
    int count=20;
    int curPage=1;

    /**
     * 进入审核页面
     * @param session
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(HttpSession session) {
        int maxPage = (int) (spittleRepository.count() % count == 0 ? (spittleRepository.count() / count) : (spittleRepository.count() / count + 1));

        session.setAttribute("count",count);
        session.setAttribute("maxPage",maxPage);
        session.setAttribute("curPage",curPage);
        System.out.println("当前总页数："+(spittleRepository.countUncheck()/count+1)+"\n一页显示："+count+"\n当前页码："+curPage);
        return spittleRepository.findNotCheckedRecent(count, curPage-1);
    }

    /**
     * 处理分页跳转属性
     * @param c
     * @param p
     * @param session
     * @return
     */
    @RequestMapping(method = POST)
    public String jumpPage(@RequestParam(value = "count")int c,@RequestParam(value = "curPage") int p,HttpSession session){
        System.out.println("checking post");
       this.count=c;
       this.curPage=p;
        return "redirect:/checking";
    }

    /**
     * 处理管理员对吐槽贴的审核
     * @param spittleID
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "check/{spittleID}", method = POST)
    public String showSpitterProfile(@PathVariable String spittleID, HttpServletRequest request, HttpSession session) {
        System.out.println(request.getParameter("check"));
        System.out.println(spittleID);
        /**
         * 通过吐槽贴，吐槽贴属性改变，发布到spittles列表
         */
        if (request.getParameter("check").equals("pass")) {
            spittleRepository.updatePassed(Long.parseLong(spittleID), (Manager) session.getAttribute("manager"));
        }
        /**
         * 删除吐槽贴，从数据库中删除
         */
        else if (request.getParameter("check").equals("delete")) {
            spittleRepository.delete(Long.parseLong(spittleID));
        }
        System.out.println("操作完成");
        return "redirect:/checking";
    }
}
