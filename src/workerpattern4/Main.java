package workerpattern4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import model.Worker;
import repository.WorkerRepository;

public class Main
{

    static final int PORT = 1978;

    public static void main(String[] args)
    {
        Socket socket = null;
        ServerSocket ServerSocket = null;
        System.out.println("Server Listening......");
        try
        {
            ServerSocket = new ServerSocket(PORT);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Server error");
        }

        while (true)
        {
            try
            {
//                WorkerRepository wrrp = new WorkerRepository();
//                List<Worker> l = wrrp.getWorkers();
//
//                Worker f = wrrp.getWorker();
//                System.out.println(f.getName());
                socket = ServerSocket.accept();
                System.out.println("connection Established");
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();

            }

            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Connection Error");

            }
        }
    }

}
