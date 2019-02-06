package commonchat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Abdelrhman
 */

public interface ServerInterface extends Remote {

    void register(ClientInterface clientInterface) throws RemoteException;

    void unregister(ClientInterface clientInterface) throws RemoteException;

    void broadCast(String message) throws RemoteException;
}
