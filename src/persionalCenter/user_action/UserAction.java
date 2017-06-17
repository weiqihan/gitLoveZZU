package persionalCenter.user_action;

import java.io.PrintWriter;




import javax.annotation.Resource;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import persionalCenter.entity.User;
import persionalCenter.service.UserService;
import zzu.util.Judge_character;


//ע�Ṧ��

@Transactional
@Component(value="userAction")
@Scope(value="prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ע��UserService����
	@Resource(name="userService")
	private UserService userService;
	//ע��User����
	@Resource(name="user")
	private User user;
	
	//ģ��������װ����
	@Override
	public  User getModel() {
	
		return user;
	}
	@Override
	public String execute() throws Exception {
		Judge_character j=new Judge_character();
		boolean isSuccessful=false;
		if(j.character(user.getPhone())){
		System.out.println("UserAction��User"+user.toString());
		isSuccessful=userService.save(user);
		}else{System.out.println("�û��ֻ��Ų��Ϸ�:"+isSuccessful);}
		
		
	//��������
		HttpServletResponse response= ServletActionContext.getResponse();
		response.setHeader("Content-type", "text/html;charset=UTF-8");   
		response.setCharacterEncoding("UTF-8");
		
		JSONObject json = new JSONObject();   
		
    	 json.put("isSuccessful", isSuccessful);
          System.out.println("UserAction��json"+json);
        
     PrintWriter out=response.getWriter();    	
    	out.println(json);
    	out.flush();
    	out.close();
		
		return NONE;
	}

}