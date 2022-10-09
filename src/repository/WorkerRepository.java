package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Worker;

public class WorkerRepository
{

    private final int workerSerial = 1;

    public List<Worker> getWorkers()
    {
        try
        {
            Connection connection = new DbConnectionRepository().getConnection();
            if (connection != null)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from worker");
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Worker> workers = new ArrayList<Worker>();
                while (resultSet.next())
                {
                    Worker worker = new Worker();
                    worker.setName(resultSet.getString("name"));
                    worker.setWritingFilePath(resultSet.getString("file_path"));
                    worker.setText1(resultSet.getString("text1"));
                    worker.setText2(resultSet.getString("text2"));
                    worker.setText3(resultSet.getString("text3"));
                    worker.setText4(resultSet.getString("text4"));
                    worker.setState(resultSet.getString("state"));
                    workers.add(worker);
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
                if (workers.size() > 0)
                {
                    return workers;
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception ex)
        {
            return null;
        }
        return null;
    }

    public Worker getWorker()
    {

        try
        {
            Connection connection = new DbConnectionRepository().getConnection();
            if (connection != null)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from worker where name = ? LIMIT ?");
                preparedStatement.setString(1, "worker-" + this.workerSerial);
                preparedStatement.setInt(2, 1);
                ResultSet resultSet = preparedStatement.executeQuery();
                Worker worker = null;
                while (resultSet.next())
                {
                    worker = new Worker();
                    worker.setName(resultSet.getString("name"));
                    worker.setWritingFilePath(resultSet.getString("file_path"));
                    worker.setText1(resultSet.getString("text1"));
                    worker.setText2(resultSet.getString("text2"));
                    worker.setText3(resultSet.getString("text3"));
                    worker.setText4(resultSet.getString("text4"));
                    worker.setState(resultSet.getString("state"));
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return worker;
            }
        }
        catch (Exception ex)
        {
            return null;
        }
        return null;
    }

    public boolean updateWorkerState(String state)
    {

        try
        {
            Connection connection = new DbConnectionRepository().getConnection();
            if (connection != null)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from worker where name = ?");
                preparedStatement.setString(1, "worker-" + this.workerSerial);
                ResultSet resultSet = preparedStatement.executeQuery();
                Worker worker = null;
                while (resultSet.next())
                {
                    worker = new Worker();
                    worker.setName(resultSet.getString("name"));
                    worker.setWritingFilePath(resultSet.getString("file_path"));
                    worker.setText1(resultSet.getString("text1"));
                    worker.setText2(resultSet.getString("text2"));
                    worker.setText3(resultSet.getString("text3"));
                    worker.setText4(resultSet.getString("text4"));
                    worker.setState(resultSet.getString("state"));
                }
                if (worker == null)
                {
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                    return false;
                }
                else
                {
                    preparedStatement = connection.prepareStatement("update worker set state = ? where name = ?");
                    preparedStatement.setString(1, state);
                    preparedStatement.setString(2, "worker-" + this.workerSerial);
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
