package workerpattern4;

import java.util.ArrayList;
import java.util.List;
import model.Worker;
import repository.WorkerRepository;

public class Main
{

    public static void main(String[] args)
    {
        WorkerRepository wrrp = new WorkerRepository();
        List<Worker> l = wrrp.getWorkers();

        Worker f = wrrp.getWorker();
        System.out.println(f.getName());
    }

}
