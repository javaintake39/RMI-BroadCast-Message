
package commonserver;

import commonchat.ClientInterface;
import commonchat.ServerInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdelrhman
 */

public class ServerImp extends UnicastRemoteObject implements ServerInterface{

    // ArrayList Contains all registered Clients
    static ArrayList<ClientInterface> clientList; 
    
    public ServerImp() throws RemoteException
    {
        super();
        clientList=new ArrayList<>(); 
    }
    @Override
    public void register(ClientInterface clientInterface) throws RemoteException {
        clientList.add(clientInterface);
        System.out.println("Client Registered");
    }

    @Override
    public void unregister(ClientInterface clientInterface) throws RemoteException {
        clientList.remove(clientInterface);
        System.out.println("Client Removed");
    }

    @Override
    public void broadCast(String message) throws RemoteException {
        clientList.stream().forEach(client->{
            try {
                client.receive(message);
            } catch (RemoteException ex) {
                Logger.getLogger(ServerImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        System.out.println("BroadCast Sent");
    }
    
}
