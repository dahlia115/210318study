package ex01.database;

import ex01.memberdto.MemberDTO;

public interface DatabaseService {

	public int saveMember(MemberDTO dto);

	public String loginCheck(String userId);



}
