public class Detergente implements ILiquido , IDescuento {
    private String marca;
    private float precio;
    private float volumen;
    private String tipoEnvase;
    private float descuento;

    public Detergente(String marca, float precio) {
        this.marca = marca;
        this.precio = precio;
        this.volumen = 0;
        this.tipoEnvase = "";
        this.descuento = 0;
    }

    @Override
    public String toString() {
        String s = "";
        s = "DETERGENTE MARCA: " + marca + "\nCON PRECIO: " + precio;
        if (volumen != 0) {
            s += "\nCON VOLUMEN: " + volumen + "L";
        }
        if (!tipoEnvase.isEmpty()) {
            s += "\nTIPO DE ENVASE: " + tipoEnvase;
        }
        if (descuento != 0) {
            s += "\nDESCUENTO: " + descuento * 100 + "%\nPRECIO CON DESCUENTO: " + getPrecioDescuento();
        }

        return s;
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

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public float getPrecio() {
        return precio;
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
}
