package com.barofarm.fish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.barofarm.fish.vo.FishVo;

@Repository
@Primary
public class FishDaoImpl implements IF_FishDao{

	private String mapperQuery="com.barofarm.fish.dao.IF_FishDao";

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public void insert(FishVo fVo) throws Exception {
		sqlsession.insert(mapperQuery+".insert",fVo);
	}

	@Override
	public List<FishVo> allview() throws Exception {
		return sqlsession.selectList(mapperQuery+".select");
	}

	@Override
	public void delete(int no) throws Exception {
		sqlsession.delete(mapperQuery+".delete",no);
		
	}

	@Override
	public FishVo modify(int no) throws Exception {
		return sqlsession.selectOne(mapperQuery+".modify",no);
	}

	@Override
	public void update(FishVo fVo) throws Exception {
		sqlsession.update(mapperQuery+".update",fVo);
		
		
	}
	

}
