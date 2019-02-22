package myspring.user.dao;

import java.util.List;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.vo.UserVO;

//@Repository("userDao")
public class UserDaoImplMapper implements UserDao {
	//@Autowired
	private UserMapper userMapper;	
	
	@Override
	public UserVO read(String id) {
		UserVO user  = userMapper.selectUserById(id);
		return user;
	}
	
	public List<UserVO> readAll() {
		List<UserVO> userList = userMapper.selectUserList();
		return userList;
	}

	public void insert(UserVO user) {
		userMapper.insertUser(user);
		System.out.println("��ϵ� Record UserId=" + user.getUserId() + 
				" Name=" + user.getName());
	}

	@Override
	public void update(UserVO user) {
		userMapper.updateUser(user);
	}
	
	@Override
	public void delete(String id) {
		userMapper.deleteUser(id);
		System.out.println("������ Record with ID = " + id ); 
	}
}










