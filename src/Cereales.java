import java.util.Date;

public class Cereales implements IAlimento{
    private String marca;
    private float precio;
    private String tipoCereal;
    private Date caducidad;

    public Cereales(String marca, float precio, String tipoCereal) {
        this.marca = marca;
        this.precio = precio;
        this.tipoCereal = tipoCereal.toUpperCase();
        this.caducidad = null;
    }

    @Override
    public String toString() {
        String s = "";
        s = "CEREALES MARCA: " + marca + "\nCON PRECIO: " + precio + "\nTIPO DE CEREAL: " + tipoCereal;
        if (caducidad != null) {
            s += "\nCON CADUCIDAD: " + caducidad;
        }
        s += "\nCALORIAS: " + getCalorias();
        return s;
    }

    public void setTipoCereal(String tipoCereal) {
        this.tipoCereal = tipoCereal;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoCereal() {
        return tipoCereal;
    }

    public String getMarca() {
        return marca;
    }

    public float getPrecio() {
        return precio;
    }

    @Override
    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    @Override
    public Date getCaducidad() {
        return caducidad;
    }

    @Override
    public int getCalorias() {
        switch (getTipoCereal().toUpperCase()) {
            case "ESPELTA":
                return 5;
            case "MAÍZ":
                return 8;
            case "TRIGO":
                return 12;
            default:
                return 15;
        }
    }
}
