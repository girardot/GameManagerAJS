package repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class AbstractIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Before
    public void setUp() throws Exception {
        executeSqlScript("insert_data.sql", false);
    }
    
    
    @Test
    public void should_test_nothing() {

    }

}
