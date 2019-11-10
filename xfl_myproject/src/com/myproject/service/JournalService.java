package com.myproject.service;

import java.util.List;

import com.myproject.dao.JournalDao;
import com.myproject.entity.Journal;

public class JournalService {
	private JournalDao jnDao=new JournalDao();
	
	public List<Journal> getDailyByybId(String yb_userid){
		return jnDao.getDailyByybId(yb_userid);
	}
	public int addDaily(Journal jn) {
		return jnDao.addDaily(jn);
	} 
	

}
