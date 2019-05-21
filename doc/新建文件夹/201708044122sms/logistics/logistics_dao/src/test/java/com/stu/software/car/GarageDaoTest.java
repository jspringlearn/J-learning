package com.stu.software.car;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.car.dao.GarageDao;
import com.stu.software.car.domain.Garage;
import com.stu.software.dao.GenericTreeDaoTestCase;

public class GarageDaoTest extends GenericTreeDaoTestCase<Long, Garage, GarageDao> {

	GarageDao garageDao;
	@Autowired
	 public void setBossDao(GarageDao garageDao){
        this.garageDao=garageDao;
        this.dao=this.garageDao;
    }
	
	
	 @Test
	    public void testGetRoot(){
	        int root_size=10;
	        for(int i=0;i<root_size;i++){
	            Garage garage=new Garage();
	            garage.setGarage_place("garage_"+i);
	            for(int j=0;j<10;j++) {
	                Garage g=new Garage();
	                g.setGarage_place("garage_"+i+"_"+j);
	                g.setParent(garage);
	            }
	            this.garageDao.save(garage);
	        }
	        List<Garage> roots=this.garageDao.getRoot();
	        assertEquals(root_size,roots.size());

	        if (logger.isInfoEnabled()) {
	            logger.info("testGetRoot() - List<Boss> roots={}", roots); //$NON-NLS-1$
	        }
	    }
	
}
