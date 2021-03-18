package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.common.CommonService;
import ex01.loginService.LoginService;
import ex01.loginService.LoginServiceImpl;
import ex01.member.MemberMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	@FXML TextField fxId;
	Parent root;
	LoginService ls;
	MemberMain mm;	
	public static CommonService cs;
	static {
		cs = new CommonClass();
	}
	public void cancelProc() {
		System.out.println("취소 버튼 클릭");
		//Stage stage = (Stage) root.getScene().getWindow(); 
		//stage.close(); //창 닫기
		cs.exit(root);
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void loginProc() {
		ls.loginCheck(root);
		//System.out.println("확인 버튼 클릭");
		//TextField pwd = (TextField)root.lookup("#fxPw");
		//System.out.println("아이디 : "+fxId.getText());
		//System.out.println("비밀번호 : "+pwd.getText());
	}

	public void memberProc() {
		System.out.println("회원가입 클릭");
		mm.setMemberStage();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginServiceImpl();
		mm = new MemberMain();
	}
	
}
