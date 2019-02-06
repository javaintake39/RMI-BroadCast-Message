package commonchat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Abdelrhman
 */

public interface ClientInterface extends Remote {

    void receive(String receivedMessage) throws RemoteException;
}
