package ex01.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ex01.memberdto.MemberDTO;

public class DatabaseServiceImpl implements DatabaseService {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jwoo";
	String pwd = "1234";

	public DatabaseServiceImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int saveMember(MemberDTO dto) {
		String sql = "INSERT INTO member(id,pw,name,gender,age,hobby) VALUES(?,?,?,?,?,?)";
		int result = 0;
		try {

			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setInt(4, dto.getGender());
			ps.setString(5, dto.getAge());
			ps.setInt(6, dto.getHobby());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String loginCheck(String userId) {
		String sql ="SELECT pw FROM member WHERE id='"+userId+"'";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("pw");
			}
		}catch (Exception e) {
		
		}
		return null;			
	}

}
