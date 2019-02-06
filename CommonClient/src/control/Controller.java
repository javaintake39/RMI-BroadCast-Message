package control;

import view.ChatWindow;
import view.ChatWindowInterface;
import model.ClientService;
import model.ServerService;
import java.rmi.RemoteException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Abdelrhman
 */

public class Controller extends Application {

    public ChatWindowInterface chatWindow;
    public ClientService clientService;
    public ServerService serverService;

    @Override
    public void start(Stage primaryStage) {
        try {
            serverService = new ServerService();
            clientService = new ClientService(this);
            serverService.register(clientService);
            chatWindow = new ChatWindow(this);

            Scene scene = new Scene((Parent) chatWindow, 600, 400);

            primaryStage.setTitle("Chat Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }

   // @Override
   // public void stop() 
   // {
    //    serverService.unregister(clientService);
    //}

    public static void main(String[] args) {
        launch(args);
    }

    public void sendMessageToServer(String message) {
        serverService.sendMessageToServer(message);
    }

    public void displayMessage(String receivedMessage) {
        chatWindow.display(receivedMessage);
    }

}
