package ex01.member.service;

import ex01.Controller;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

public class MemberServiceImpl implements MemberService {
	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		addComboBox();
	}
	private void addComboBox() { //�޺��ڽ� �� ����
		ComboBox<String> cmb = (ComboBox<String>) root.lookup("#cmbAge");
		if(cmb != null)
			cmb.getItems().addAll("10��","20��","30��","30�� �̻�");
	}
	@Override
	public void memberClose() {	//��� -> â �ݱ�
		Controller.cs.exit(root);
		
	}
	@Override
	public void memberShip() { //Ȯ��
		boolean gender = getGender();
		System.out.println("����(true:��), (false:��) : "  +gender);
		int hobby = getHobby();
		//���ð�� ->1:����, 2:������, 4:��ȭ
		System.out.println("���(1.���� 2.������ 4.��ȭ) "+hobby);
		String age = getComboBox();
		System.out.println("����� ���̴� :"+age);
	}
	public boolean getGender() {
		RadioButton man = (RadioButton) root.lookup("#rdoMan");
		return man.isSelected();//������ ���� �Ǿ������� true, �ƴϸ� false
	}
	public int getHobby() {
		CheckBox music = (CheckBox) root.lookup("#chkMusic");
		CheckBox sport = (CheckBox) root.lookup("#chkSport");
		CheckBox movie = (CheckBox) root.lookup("#chkMovie");
		int hobby = 0;
		//���ð�� -> 1:����, 2:������, 4:��ȭ
		if( music.isSelected() )
			hobby += 1 ;
		if( sport.isSelected() )
			hobby += 2;
		if( movie.isSelected() )
			hobby += 4 ;
		return hobby;
	}
	public String getComboBox() {
		ComboBox<String> cmb = (ComboBox<String>) root.lookup("#cmbAge");
		String age =cmb.getValue();
		if(age == null) {
			Controller.cs.alert("���̸� ������ �ּ���");
		}
		return age;
	}
}









