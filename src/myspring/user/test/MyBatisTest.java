package myspring.user.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.service.UserService;
import myspring.user.vo.DeptVO;
import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserService userService;
	
	@Test
	public void service() {
		UserVO user = userService.getUser("jinsun");
		System.out.println(user);
	}
	
	@Test @Ignore
	public void studentDept() {
		StudentVO student = new StudentVO(199, "하진선", 10, "1", "주", new DeptVO(40));
		int cnt = sqlSession.insert("studentNS.insertStudent", student);
		System.out.println("등록건수 : " + cnt);
		
		List<StudentVO> stuList= sqlSession.selectList("studentNS.selectStudentDeptById");
		for (StudentVO studentVO : stuList) {
			System.out.println(studentVO);
		}	
	}	
	
	@Test @Ignore
	public void list() {
		List<UserVO> userList = sqlSession.selectList("userNS.selectUserList");
		
		for (UserVO userVO : userList) {
			System.out.println(userVO);
		}
	}
	
	@Test @Ignore
	public void update() {
		UserVO user = new UserVO("jinsun", "하진선", "여", "문경");
		int cnt = sqlSession.update("updateUser", user);
		System.out.println("수정건수: " + cnt);		
	}	
	
	@Test @Ignore
	public void insert() {
		UserVO user = new UserVO("jinsun", "하진선", "여", "서울");
		int cnt = sqlSession.insert("insertUser", user);
		System.out.println("등록건수 " + cnt);
	}
	
	@Test @Ignore
	public void select() {
		UserVO  user = sqlSession.selectOne("userNS.selectUserById", "jinsun");
		System.out.println(user);	
	}
}
