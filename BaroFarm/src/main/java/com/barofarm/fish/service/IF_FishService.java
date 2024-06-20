package com.barofarm.fish.service;

import java.util.List;

import com.barofarm.fish.vo.FishVo;

public interface IF_FishService {

	public void insert(FishVo fVo) throws Exception;
	public List<FishVo> allview() throws Exception;
	public void delete(int no) throws Exception;
	public FishVo modify(int no) throws Exception;
	public void update(FishVo fVo) throws Exception;
	
}
