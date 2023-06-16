package com.rutatalk.test.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rutatalk.test.dao.TestDAO;
import com.rutatalk.test.model.Test;

@Service
public class TestBO {

	@Autowired
	private TestDAO testDAO;
	
	public int getTest(int userId) {
		return testDAO.selectTest(userId);
	}
}
