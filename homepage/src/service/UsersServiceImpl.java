package service;

import dao.UserDAO;
import vo.UserVO;

public class UsersServiceImpl implements UsersService{
	
	UserDAO dao;
	
	public UsersServiceImpl() {}
	public UsersServiceImpl(UserDAO dao) {
		super();
		this.dao = dao;
	}
	public UserDAO getDao() {
		return dao;
	}
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int addUsers(UserVO vo) {
		return dao.insertUsers(vo);
	}

	@Override
	public int usersUpdate(UserVO vo) {
		return dao.updateUsers(vo);
	}
	@Override
	public UserVO usersLogin(UserVO vo) {
		return dao.loginUsers(vo);
		
	}

	@Override
	public int checkUsers(UserVO vo) {
		return dao.checkUsers(vo);
	}
//	@Override
//	public int usersLogin(UserVO vo) {
//		// TODO Auto-generated method stub
//		return dao.loginUsers(vo);
//	}
//	

}
