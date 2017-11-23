/**
 * 
 */
package com.career.compass.restapi;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.career.compass.data.Statewise;
import com.career.compass.services.StatewiseService;

/**
 * @author Kavichezliyan Rajendran
 *
 */
@RestController
//@RequestMapping(value="/api")
public class CollegeController {
	
	Log logger=LogFactory.getFactory().getInstance(CollegeController.class);
	
	@Autowired
    StatewiseService statewiseService; //Service which will do all data retrieval/manipulation work
	
	/*-------- Retrive All the details --------------*/	
	@RequestMapping(value="/getColleges/" , produces="Application/Json")
	public ResponseEntity<List<Statewise>> getAllColleges(){
		logger.info( " CollegeController : getAllColleges Starting"); 
		List<Statewise> statewises=statewiseService.findAllStatewises();
		if(statewises.isEmpty()) {
			logger.info( " CollegeController : getAllColleges No data from the response"); 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		logger.info( " CollegeController : getAllColleges  Loaded All the details "); 
		return new ResponseEntity<List<Statewise>>(HttpStatus.OK);
		
	}
	

}
