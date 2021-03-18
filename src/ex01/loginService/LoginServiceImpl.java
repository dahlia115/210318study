package ex01.loginService;

import ex01.Controller;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginServiceImpl implements LoginService {

	@Override
	public void loginCheck(Parent root) {
		TextField id = (TextField) root.lookup("#fxId");
		TextField pwd = (TextField) root.lookup("#fxPw");
		
		if(id.getText().isEmpty()) {
			Controller.cs.alert("아이디를 입력하세요");
		}
		
		System.out.println("로그인 체크 합니다");
		System.out.println("id : "+id.getText());
		System.out.println("pw : "+pwd.getText());
		
	}

}
