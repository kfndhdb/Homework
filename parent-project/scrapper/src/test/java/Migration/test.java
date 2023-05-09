package Migration;


import integration.Environment;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class test extends Environment {
    @Test
    void checkMigrations_link_open(){
        String SQL_REQUEST_FROM_LINK = """ 
                SElECT * FROM links
                """;

        try (Connection connection = POSTGRE_SQL_CONTAINER.createConnection("")) {

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SQL_REQUEST_FROM_LINK);


            assertTrue(result.next());
        } catch (SQLException exception) {
            System.out.println(42);
        }

    }

    @Test
    void checkMigrations_chat_open(){
        String SQL_REQUEST_FROM_CHAT = """ 
                SElECT * FROM chats
                """;

        try (Connection connection = POSTGRE_SQL_CONTAINER.createConnection("")) {

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SQL_REQUEST_FROM_CHAT);

            assertTrue(result.next());
        } catch (SQLException exception) {
            System.out.println(42);
        }
    }


}
