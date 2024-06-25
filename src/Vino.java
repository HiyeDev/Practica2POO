import java.util.Date;

public class Vino implements IDescuento, IAlimento, ILiquido{
    private String marca;
    private String tipoVino;
    private float gradosAlcohol;
    private float precio;
    private Date caducidad;
    private float descuento;
    private float volumen;
    private String tipoEnvase;

    public Vino (String marca, String tipoVino, float gradosAlcohol, float precio) {
        this.marca = marca;
        this.tipoVino = tipoVino;
        this.gradosAlcohol = gradosAlcohol;
        this.precio = precio;
        this.caducidad = null;
        this.descuento = 0;
        this.volumen = 0;
        this.tipoEnvase = "";
    }

    @Override
    public String toString() {
        String s = "";
        s = "VINO MARCA: " + marca + "\nCON TIPO: " + tipoVino + "\nGRADOS DE ALCOHOL: " + gradosAlcohol + "\nPRECIO: " + precio;
        if (caducidad != null) {
            s += "\nCON CADUCIDAD: " + caducidad;
        }
        if (volumen != 0) {
            s += "\nCON VOLUMEN: " + volumen + "L";
        }
        if (!tipoEnvase.isEmpty()) {
            s += "\nTIPO DE ENVASE: " + tipoEnvase;
        }
        if (descuento != 0) {
            s += "\nDESCUENTO: " + descuento * 100 + "%\nPRECIO CON DESCUENTO: " + getPrecioDescuento();
        }
        s += "\nCALORIAS: " + getCalorias();

        return s;
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
        return (int) gradosAlcohol * 10;
    }

    @Override
    public void setDescuento(float descuento) {
        this.descuento = descuento / 100;
    }

    @Override
    public float getDescuento() {
        return descuento;
    }

    @Override
    public float getPrecioDescuento() {
        return precio - (precio * descuento);
    }

    @Override
    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }

    @Override
    public float getVolumen() {
        return volumen;
    }

    @Override
    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    @Override
    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoVino(String tipoVino) {
        this.tipoVino = tipoVino;
    }

    public void setGradosAlcohol(float gradosAlcohol) {
        this.gradosAlcohol = gradosAlcohol;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipoVino() {
        return tipoVino;
    }

    public float getGradosAlcohol() {
        return gradosAlcohol;
    }

    public float getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }
}
