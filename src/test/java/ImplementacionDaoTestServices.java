/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.soft.primerproyecto.Dao.SucursalDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

/**
 *
 * @author Usuario
 */
public class ImplementacionDaoTestServices extends AbstrantTransactionalTestNGSpringContextTests{
    
    private static Logger log = Logger.getLogger(SucursalDao.class);
    @Autowired
    private SucursalDao sucursal;
    
    public ImplementacionDaoTestServices() {
    }
    
    @BeforeClass
    public void initDataBase() {
        String fileName = "sql/script.sql";
        Resource resource = applicationContext.getResource(fileName);
        if (resource.exists()) {
            executeSqlScript(fileName, false);
        } else {
            log.debug("No existe el archivo: {}" + resource);
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         System.out.println(12);
     }
}
