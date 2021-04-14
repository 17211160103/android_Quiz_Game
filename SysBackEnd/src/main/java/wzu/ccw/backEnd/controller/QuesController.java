package wzu.ccw.backEnd.controller;

import wzu.ccw.backEnd.controller.viewobject.Question;
import wzu.ccw.backEnd.dataobject.NewsDO;
import wzu.ccw.backEnd.response.CommonReturnType;
import wzu.ccw.backEnd.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ques")
public class QuesController extends BaseController {
//    @Autowired
//    NewsService newsService;

    @GetMapping("/getQuestion")
    @ResponseBody
    public CommonReturnType getQues(
            @RequestParam(value = "number") int number,
            @RequestParam(value = "category") int category
    ) {
       ArrayList<Question> list=new ArrayList<>();
       for(int i=0;i<5;i++){
           list.add(new Question(1,"what is your name?","1","1","1","1",
                   "1",6));
       }
       return CommonReturnType.create(0,list);
    }


    @GetMapping("/getMember")
    @ResponseBody
    public CommonReturnType getMember(
            @RequestParam(value = "room") String room
    ) {
        return CommonReturnType.create("1123,12346,5466");
    }

}
