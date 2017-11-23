/**
 * 
 */
package com.career.compass.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.career.compass.data.Statewise;
import com.career.compass.repository.StatewiseRepository;

/**
 * @author Administrator
 *
 */
@Service("statewiseService")
@Transactional
public class StatewiseServiceImpl implements StatewiseService {
	
	@Autowired
	private StatewiseRepository statewiseRepository ;

	@Override
	public Statewise findById(Long id) {
		// TODO Auto-generated method stub
		return statewiseRepository.findOne(id);
	}

	@Override
	public Statewise findByName(String name) {
		// TODO Auto-generated method stub
		return statewiseRepository.findByState(name);
	}

	@Override
	public void saveStatewise(Statewise statewise) {
		// TODO Auto-generated method stub
		statewiseRepository.save(statewise);
	}

	@Override
	public void updateStatewise(Statewise statewise) {
		// TODO Auto-generated method stub
		saveStatewise(statewise);
	}

	@Override
	public void deleteStatewiseById(Long id) {
		// TODO Auto-generated method stub
		statewiseRepository.delete(id);
	}

	@Override
	public void deleteAllStatewises() {
		// TODO Auto-generated method stub
		statewiseRepository.deleteAll();
	}

	@Override
	public List<Statewise> findAllStatewises() {
		// TODO Auto-generated method stub
		return statewiseRepository.findAll();
	}

	@Override
	public boolean isStatewiseExist(Statewise statewise) {
		// TODO Auto-generated method stub
		return  findByName(statewise.getState()) != null;
	}

}
