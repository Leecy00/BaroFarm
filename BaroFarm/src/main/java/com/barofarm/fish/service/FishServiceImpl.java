package com.barofarm.fish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barofarm.fish.dao.IF_FishDao;
import com.barofarm.fish.vo.FishVo;

@Service
public class FishServiceImpl implements IF_FishService{

	@Autowired
	IF_FishDao fDao;
	
	@Override
	public void insert(FishVo fVo) throws Exception {
		fDao.insert(fVo);
	}

	@Override
	public List<FishVo> allview() throws Exception {
	
		return fDao.allview();
	}

	@Override
	public void delete(int no) throws Exception {
		fDao.delete(no);
		
	}

	@Override
	public FishVo modify(int no) throws Exception {
		return fDao.modify(no);
	}

	@Override
	public void update(FishVo fVo) throws Exception {
		// TODO Auto-generated method stub
		fDao.update(fVo);
	}



}
