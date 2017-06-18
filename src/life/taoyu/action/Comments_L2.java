package life.taoyu.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import life.taoyu.modeldriver.L2_Comments_Modeldriver;
import life.taoyu.service.TaoyuService;
import zzu.util.Returndata;

@Component(value = "comments_L2Action")
@Scope(value = "prototype")
public class Comments_L2 extends ActionSupport implements ModelDriven<L2_Comments_Modeldriver> {

	/**
	 * 二级评论(一级评论的评论)，查，存，修
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "CommentsL2_Modeldriver")
	private L2_Comments_Modeldriver CMD2;
	
	@Resource(name = "taoyuService")
	private TaoyuService taoyuService;
	@Override
	public L2_Comments_Modeldriver getModel() {
		// TODO Auto-generated method stub
		return CMD2;
	}
       boolean Successful=false;
	@Override
	public String execute() throws NumberFormatException,Exception {
		if (CMD2.getAction().equals("postcomments_L2")) {
			System.out.println("发表二级评论操作!");
			if (CMD2.getL1_Cid() != null && !CMD2.getL1_Cid().isEmpty()) {
				System.out.println("二级评论对一级评论的操作!");

			//设置sql语句和值，String转Integer		
					CMD2.setSql("from Comments_L1 where L1_Cid = ?");
					Integer integerValue=Integer.valueOf(CMD2.getL1_Cid());
					CMD2.setValues(integerValue);
					Successful=taoyuService.postcommentsL2(CMD2);

			} else if (CMD2.getL2_Cid() != null && !CMD2.getL2_Cid().isEmpty()) {
				System.out.println("二级评论评对二级评论的操作!");
				//设置sql语句和值，String转Integer		
				CMD2.setSql("from Comments_L2 where L2_Cid = ?");
				Integer integerValue=Integer.valueOf(CMD2.getL2_Cid());
				CMD2.setValues(integerValue);
				Successful=taoyuService.postcommentsL2(CMD2);
			}

		} else if(CMD2.getAction().equals("querycomments_L2")){
			System.out.println("查询二级评论操作!");
			
		}

//返回数据
		Returndata.returnboolean(Successful);
		return null;
	}

}
