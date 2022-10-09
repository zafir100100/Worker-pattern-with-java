package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.GlobalWrittingConfig;

public class GlobarWrittingConfigRepository
{

    public GlobalWrittingConfig getGlobalWrittingConfig()
    {
        try
        {
            Connection connection = new DbConnectionRepository().getConnection();
            if (connection != null)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from global_writting_config LIMIT ?");
                preparedStatement.setInt(1, 1);
                ResultSet resultSet = preparedStatement.executeQuery();
                GlobalWrittingConfig globalWrittingConfig = null;
                while (resultSet.next())
                {
                    globalWrittingConfig = new GlobalWrittingConfig();
                    globalWrittingConfig.setText1(resultSet.getString("text1"));
                    globalWrittingConfig.setText2(resultSet.getString("text2"));
                    globalWrittingConfig.setText3(resultSet.getString("text3"));
                    globalWrittingConfig.setText4(resultSet.getString("text4"));
                    globalWrittingConfig.setState(resultSet.getString("state"));
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return globalWrittingConfig;
            }
        }
        catch (Exception ex)
        {
            return null;
        }
        return null;
    }

    public boolean updateGlobalWrittingConfigState(String state)
    {

        try
        {
            Connection connection = new DbConnectionRepository().getConnection();
            if (connection != null)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from global_writting_config LIMIT ?");
                preparedStatement.setInt(1, 1);
                ResultSet resultSet = preparedStatement.executeQuery();
                GlobalWrittingConfig globalWrittingConfig = null;
                while (resultSet.next())
                {
                    globalWrittingConfig = new GlobalWrittingConfig();
                    globalWrittingConfig.setText1(resultSet.getString("text1"));
                    globalWrittingConfig.setText2(resultSet.getString("text2"));
                    globalWrittingConfig.setText3(resultSet.getString("text3"));
                    globalWrittingConfig.setText4(resultSet.getString("text4"));
                    globalWrittingConfig.setState(resultSet.getString("state"));
                }
                if (globalWrittingConfig == null)
                {
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                    return false;
                }
                else
                {
                    preparedStatement = connection.prepareStatement("update global_writting_config set state = ? where text1 = ? and text2 = ? and text3 = ? and text4 = ? and state = ?");
                    preparedStatement.setString(1, state);
                    preparedStatement.setString(2, globalWrittingConfig.getText1());
                    preparedStatement.setString(3, globalWrittingConfig.getText2());
                    preparedStatement.setString(4, globalWrittingConfig.getText3());
                    preparedStatement.setString(5, globalWrittingConfig.getText4());
                    preparedStatement.setString(6, globalWrittingConfig.getState());
                    int rowsAffected = preparedStatement.executeUpdate();
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                    return rowsAffected > 0;
                }
            }
        }
        catch (Exception ex)
        {
            return false;
        }
        return false;
    }
}
