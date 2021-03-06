package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private volatile boolean stop;
    private ThreadPoolExecutor threadPoolExecutor;
    public Configurations configurations;
//    private final Logger LOG = LogManager.getLogManager(); //Log4j2


    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
        this.threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        this.configurations = Configurations.getInstance();

    }

    /**
     * Wrap function - sets the threadPool size
     */
    public void start() {
        threadPoolExecutor.setCorePoolSize(configurations.threadPoolSize());
        new Thread(this::startServer).start();
    }

    /**
     * start the server
     */
    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(listeningIntervalMS);
//            LOG.info("Starting server at port = " + port);
            System.out.println("Starting server at port = " + port);

            while(!stop){
            try {
                System.out.println("startClientSocket is started by new thread");
                Socket clientSocket = serverSocket.accept();//waiting for a client
                System.out.println("Client accepted: " + clientSocket.toString());
                threadPoolExecutor.execute(() -> handleClient(clientSocket));
                Thread.sleep(1000);
//      LOG.info("Client accepted: " + clientSocket.toString());
            } catch (IOException e) {
                System.out.println("Socket is waiting");;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
            threadPoolExecutor.shutdown(); // shut the thraedpool
            serverSocket.close(); //close the server socket
        } catch (SocketException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param clientSocket - applyStrategy on the client by his sockets.
     */
    private void handleClient(Socket clientSocket) {
        try {
            System.out.println(String.format("Client accepted- client with socket: %s", clientSocket.toString()));
            strategy.ServerStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream(),this.configurations);
//            LOG.info("Done handling client: " + clientSocket.toString());
            System.out.println("Done handling client: " + clientSocket.toString());
            clientSocket.close();
        } catch (IOException e){
//            LOG.error("IOException", e);
            System.out.println("IOException " + e);
        }
    }

    /**
     * stop the server
     */
    public void stop(){
//        LOG.info("Stopping server...");
        System.out.println("Stopping server...");
        stop = true;
    }
}
