package com.barofarm.fish.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barofarm.fish.vo.UserVo;

//승훈쓰 로그인 기능 개발중 ~

@Repository
public class LoginDaoImpl implements IF_LoginDao{
	private String mapperquery="com.barofarm.fish.dao.IF_LoginDao";
	
	@Autowired
	private SqlSession sqlsession ;
		
	@Override
	public UserVo login(String id, String pw) throws Exception {

		return sqlsession.selectOne(mapperquery+".login", id);
	}

}
