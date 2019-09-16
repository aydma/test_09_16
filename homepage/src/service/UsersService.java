package service;

import vo.UserVO;

public interface UsersService {
	
//	Users user();
	int addUsers(UserVO vo); // 회원가입
	int usersUpdate(UserVO vo);
	UserVO usersLogin(UserVO vo);
//	int usersLogin(UserVO vo);
	int checkUsers(UserVO vo);

}
