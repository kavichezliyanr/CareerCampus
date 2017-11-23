/**
 * 
 */
package com.career.compass.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.career.compass.data.Statewise;

/**
 * @author Administrator
 *
 */
@Repository
public interface StatewiseRepository extends JpaRepository<Statewise, Serializable>{
	
	Statewise findByState(String state);

}