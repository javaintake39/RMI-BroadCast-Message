package model;

import control.Controller;
import commonchat.ClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Abdelrhman
 */

public class ClientService extends UnicastRemoteObject implements ClientInterface {

    private Controller controller;

    public ClientService(Controller controller) throws RemoteException {
        super();
        this.controller = controller;
    }

    @Override
    public void receive(String receivedMessage) throws RemoteException {
        controller.displayMessage(receivedMessage);

    }

}
