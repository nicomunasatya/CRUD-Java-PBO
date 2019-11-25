
package model;

/**
 *
 * @author Nico Munasatya
 */
public class MHS {
    int idMhs;
    String nim;
    String nama;
    String kota_asal;

    public int getIdMhs() {
        return idMhs;
    }

    public void setIdMhs(int idMhs) {
        this.idMhs = idMhs;
    }
    
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKota_asal() {
        return kota_asal;
    }

    public void setKota_asal(String kota_asal) {
        this.kota_asal = kota_asal;
    }
}
