
package view;

import controller.MHS_Controller;
import model.MHS;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Nico Munasatya
 */
public class PanelKiri extends VBox{
    Label lbJudul = new Label("Data MHS");
    Label lbId = new Label("ID");
    Label lbNim = new Label("NIM");
    Label lbNama = new Label("Nama");
    Label lbKota = new Label("Kota Asal");
    TextField tfId = new TextField();
    TextField tfNim = new TextField();
    TextField tfNama = new TextField();
    TextField tfKota = new TextField();
    Button btUpdate, btCancel;
    int tempId;
    boolean blAdd;
    MHS_Controller mhsc = new MHS_Controller();
   
    public PanelKiri()
    {
        GridPane gp = new GridPane();
        gp.add(lbId,0,0);
        gp.add(lbNim,0,1);
        gp.add(lbNama,0,2);
        gp.add(lbKota,0,3);
        gp.add(tfId,1,0);
        gp.add(tfNim,1,1);
        gp.add(tfNama,1,2);
        gp.add(tfKota,1,3);
        gp.setVgap(30);
        gp.setHgap(10); 
        tfId.setPromptText("ID MHS");
        tfNim.setPromptText("NIM");
        tfNama.setPromptText("Nama");
        tfKota.setPromptText("Kota Asal");
        lbJudul.setStyle("-fx-text-fill:white;-fx-margin-bottom:20px;-fx-padding:20px;");
        lbId.setStyle("-fx-text-fill:white;");
        lbNim.setStyle("-fx-text-fill:white;");
        lbNama.setStyle("-fx-text-fill:white;");
        lbKota.setStyle("-fx-text-fill:white;");
        
        Image imgUpdate = new Image("image/update.png");
        Image imgCancel = new Image("image/delete.png");
        ImageView ivUpdate = new ImageView(imgUpdate);
        ImageView ivCancel = new ImageView(imgCancel);
        
        //ivUpdate.setStyle("-fx-padding:10px; -fx-background-color:#4d4d4d;");
        //ivCancel.setStyle("-fx-padding:10px; -fx-background-color:#4d4d4d;");
        
        ivUpdate.setFitWidth(40);
        ivUpdate.setFitHeight(30);
        ivCancel.setFitWidth(40);
        ivCancel.setFitHeight(30);
        
        btUpdate = new Button("Update", ivUpdate);
        btUpdate.setPrefWidth(120);
        btUpdate.setPrefHeight(40);
        btCancel = new Button("Cancel", ivCancel);
        btCancel.setPrefWidth(120);
        btCancel.setPrefHeight(40);
       
        gp.setPadding(new Insets(10, 10, 10, 10));
        HBox hb = new HBox(20);
        hb.getChildren().addAll(btUpdate, btCancel);
        hb.setPadding(new Insets(20));
        this.getChildren().addAll(lbJudul, gp, hb);
        this.setStyle("-fx-background-color:blue;");
        this.setAlignment(Pos.CENTER);
        aktif(false);
        
        btCancel.setOnMouseClicked(e->{
            kosong();
            aktif(false);
        });
        
        btUpdate.setOnMouseClicked(e->{
            if(!tfId.getText().equals(""));
            MHS m = new MHS();
            m.setIdMhs(Integer.parseInt(tfId.getText()));
            m.setNim(tfNim.getText());
            m.setNama(tfNama.getText());
            m.setKota_asal(tfKota.getText());
            
            if(blAdd == true)
            {
                mhsc.insert(m);
            }
            else
            {
                m.setIdMhs(tempId);
                mhsc.update(m);
            }
            CRUDsederhana.pnKanan.tbMHS.setItems(mhsc.getAllMhs());
            kosong();
            aktif(false);
        });
        
    }
    
    public void kosong()
    {
        tfId.setText("");
        tfNim.setText("");
        tfNama.setText("");
        tfKota.setText("");
    }
    
    public void aktif(boolean bl)
    {
        tfId.setEditable(bl);
        tfNim.setEditable(bl);
        tfNama.setEditable(bl);
        tfKota.setEditable(bl);
    }
}
