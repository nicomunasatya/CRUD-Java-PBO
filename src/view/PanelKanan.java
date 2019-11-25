
package view;

import model.MHS;
import controller.MHS_Controller;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Nico Munasatya
 */
public class PanelKanan extends VBox{
    Button bAdd, bEdit, bDel, bSearch;
    TextField tfSearch;
    TableView<MHS> tbMHS;
    MHS_Controller mhsc;
    
    public PanelKanan()
    {
        Image imgAdd = new Image("image/add.png");
        Image imgEdit = new Image("image/edit.png");
        Image imgDel = new Image("image/delete.png");
        Image imgSearch = new Image("image/search.png");
        ImageView ivAdd = new ImageView(imgAdd);
        ImageView ivEdit = new ImageView(imgEdit);
        ImageView ivDel = new ImageView(imgDel);
        ImageView ivSearch = new ImageView(imgSearch);
        
        ivAdd.setFitWidth(40);
        ivAdd.setFitHeight(30);
        ivEdit.setFitWidth(40);
        ivEdit.setFitHeight(30);
        ivDel.setFitWidth(40);
        ivDel.setFitHeight(30);
        ivSearch.setFitWidth(40);
        ivSearch.setFitHeight(30);
        
        bAdd = new Button("Add", ivAdd);
        bEdit = new Button("Edit", ivEdit);
        bDel = new Button("Delete", ivDel);
        bSearch = new Button("Search", ivSearch);
        
        
        
        tfSearch = new TextField();
        tbMHS = new TableView();
        mhsc = new MHS_Controller();
        
        TableColumn<MHS,Integer> colIdmhs = new TableColumn("ID");
        TableColumn<MHS,String> colNim = new TableColumn("NIM");
        TableColumn<MHS,String> colNama = new TableColumn("Nama");
        TableColumn<MHS,String> colKota_asal = new TableColumn("Kota Asal");
        
        colIdmhs.setCellValueFactory(new PropertyValueFactory<>("idMhs"));
        colNim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colKota_asal.setCellValueFactory(new PropertyValueFactory<>("kota_asal"));
        
        colIdmhs.prefWidthProperty().bind(tbMHS.widthProperty().divide(4));
        colNim.prefWidthProperty().bind(tbMHS.widthProperty().divide(4));
        colNama.prefWidthProperty().bind(tbMHS.widthProperty().divide(4));
        colKota_asal.prefWidthProperty().bind(tbMHS.widthProperty().divide(4));
        
        tbMHS.getColumns().addAll(colIdmhs, colNim, colNama, colKota_asal);
        tbMHS.setItems(mhsc.getAllMhs());
        
        HBox hb = new HBox(20);
        hb.getChildren().addAll(bAdd, bEdit, bDel ,tfSearch, bSearch);
        this.getChildren().addAll(hb, tbMHS);
        
        bAdd.setOnMouseClicked(e->{
            CRUDsederhana.pnKiri.aktif(true);
            CRUDsederhana.pnKiri.blAdd = true;
            CRUDsederhana.pnKiri.tfId.requestFocus();
        });
        
        bSearch.setOnMouseClicked(e->{
            this.tbMHS.setItems(mhsc.searchMHS(tfSearch.getText()));
        });
        
        tbMHS.setOnMouseClicked(e->{
            MHS m = tbMHS.getSelectionModel().getSelectedItem();
            CRUDsederhana.pnKiri.tfId.setText(String.valueOf(m.getIdMhs()));
            CRUDsederhana.pnKiri.tfNim.setText(m.getNim());
            CRUDsederhana.pnKiri.tfNama.setText(m.getNama());
            CRUDsederhana.pnKiri.tfKota.setText(m.getKota_asal());
            CRUDsederhana.pnKiri.tempId=m.getIdMhs();
        });
        
        bEdit.setOnMouseClicked(e->{
            MHS m = tbMHS.getSelectionModel().getSelectedItem();
            CRUDsederhana.pnKiri.tfId.setText(String.valueOf(m.getIdMhs()));
            CRUDsederhana.pnKiri.tfNim.setText(m.getNim());
            CRUDsederhana.pnKiri.tfNama.setText(m.getNama());
            CRUDsederhana.pnKiri.tfKota.setText(m.getKota_asal());
            CRUDsederhana.pnKiri.tempId = m.getIdMhs();
            
            CRUDsederhana.pnKiri.aktif(true);
            CRUDsederhana.pnKiri.tfId.setEditable(false);
            CRUDsederhana.pnKiri.blAdd = false;
            CRUDsederhana.pnKiri.tfNim.requestFocus();
        });
        
        bDel.setOnMouseClicked(e->{
            MHS m = tbMHS.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Hapus Data");
            alert.setHeaderText("Yakin data dihapus?");
            alert.setContentText("data "+m.getNama()+" dihapus");
            Optional<ButtonType> option = alert.showAndWait();
            
            if(option.get() == ButtonType.OK)
            {
                mhsc.delete(String.valueOf(m.getIdMhs()));
                this.tbMHS.setItems(mhsc.getAllMhs());
            }
        });
    }
    
}
