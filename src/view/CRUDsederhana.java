/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Nico Munasatya
 */
public class CRUDsederhana extends Application {
    static PanelKiri pnKiri = new PanelKiri();
    static PanelKanan pnKanan =  new PanelKanan();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();
        bp.setLeft(pnKiri);
        bp.setCenter(pnKanan);
        Scene scene = new Scene(bp, 1000, 500);
        
        primaryStage.setTitle("CRUD java");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
