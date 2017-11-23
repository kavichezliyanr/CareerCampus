/**
 * 
 */
package com.career.compass.services;

import java.util.List;

import com.career.compass.data.Statewise;

/**
 * @author Administrator
 *
 */
public interface StatewiseService {
	
	Statewise findById(Long id);
	 
    Statewise findByName(String name);
 
    void saveStatewise(Statewise statewise);
 
    void updateStatewise(Statewise statewise);
 
    void deleteStatewiseById(Long id);
 
    void deleteAllStatewises();
 
    List<Statewise> findAllStatewises();
 
    boolean isStatewiseExist(Statewise statewise);

}
