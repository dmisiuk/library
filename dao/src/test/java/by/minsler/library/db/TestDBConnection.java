package by.minsler.library.db;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

/**
 * User: dzmitry.misiuk
 * Date: 11/20/12
 * Time: 3:51 PM
 */
public class TestDBConnection {

    @Test
    public void testGetInstance() throws SQLException {
        DBConnection inst = DBConnection.getInstance();
        assertNotNull(inst);
        assertNotNull(inst.getConnection());
    }
}