package by.minsler.library.dao;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * User: dzmitry.misiuk
 * Date: 11/20/12
 * Time: 4:20 PM
 */
public class BookUserDaoImplTest {

    @Test
    public void testCreateDao(){
        BookUserDao dao = BookUserDaoImpl.getInstace();
        assertNotNull(dao);
    }
}