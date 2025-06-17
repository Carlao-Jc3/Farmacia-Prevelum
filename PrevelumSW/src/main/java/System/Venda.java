package System;
import java.time.LocalDateTime;

public class Venda {
    private int idV;
    private int idP;
    private Integer idC;
    private LocalDateTime dataVenda;

    public Venda(int idV, int idP, Integer idC, LocalDateTime dataVenda) {
        this.idV = idV;
        this.idP = idP;
        this.idC = idC;
        this.dataVenda = dataVenda;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }
    
}
