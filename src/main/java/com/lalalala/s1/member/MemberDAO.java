package com.lalalala.s1.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	//memberJoin 데이터를 받아서 DB에 insert 하는 메서드
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		// 1. 로그인 정보
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 클래스 로딩
		Class.forName(driver);

		// 3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "insert into member values(?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		
		int result = st.executeUpdate();	// 업데이트가 잘 됐는지 안됐는지는 숫자로 나
		
		st.close();
		con.close();

		return result;
		
	}

	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {

		// id, pw를 입력받고 조회

		// 1. 로그인 정보
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 클래스 로딩
		Class.forName(driver);

		// 3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);

		// 4. SQL문 생성
		String sql = "select * from member where id=? and pw=?";

		// 5. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);

		// 6. ? 세팅
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());

		// 7. 최종 전송 후 처리
		ResultSet rs = st.executeQuery();

		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));
		} else {
			memberDTO = null;
		}

		// 8. 연결 해제
		rs.close();
		st.close();
		con.close();

		return memberDTO;
	}


}
