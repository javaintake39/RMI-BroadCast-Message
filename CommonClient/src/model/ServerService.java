package model;

import commonchat.ClientInterface;
import commonchat.ServerInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Abdelrhman
 */
public class ServerService {

    ServerInterface serverRefrence;

    public ServerService() {
        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
            serverRefrence = (ServerInterface) registry.lookup("chat");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (NotBoundException ex) {
            ex.printStackTrace();
        }
    }

    public void register(ClientInterface clientService) {
        try {
            serverRefrence.register(clientService);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
      public void unregister(ClientInterface clientService) {
        try {
            serverRefrence.register(clientService);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public void sendMessageToServer(String message) {
        try {
            serverRefrence.broadCast(message);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

}
