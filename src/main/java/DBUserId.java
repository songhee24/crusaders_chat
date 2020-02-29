import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUserId {
        public int addToBd(long l) {
          int id = (int)l;
        String SQL = "insert into usersid (userid) values (?)";
        try (Connection connection = DB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                      int userID = resultSet.getInt("userID");
                      return userID;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
        }

        public String getUserByLogin(String login){
            String SQL = "select * from usersId where userLogin = ?";
            String userLogin = "";
            try(Connection connection = DB.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);) {
                preparedStatement.setString(1,login);
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()){
                         userLogin = resultSet.getString("userLogin");
                    }
                    return userLogin;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public int getUserIdById(int id) {
            String SQL = "select * from usersId where id = ?";
            int idd = 0;
            try(Connection connection = DB.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                preparedStatement.setInt(1,id);
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                     if (resultSet.next()){
                         idd = resultSet.getInt("id");
                     }
                    return idd;

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }


    }

