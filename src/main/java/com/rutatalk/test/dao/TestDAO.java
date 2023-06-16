package com.rutatalk.test.dao;

import org.springframework.stereotype.Repository;

import com.rutatalk.test.model.Test;

@Repository
public interface TestDAO {

	public int selectTest(int userId);
}
