public class Detergente implements ILiquido {
    private String marca;
    private float precio;
    private float volumen;
    private String tipoEnvase;

    public Detergente(String marca, float precio) {
        this.marca = marca;
        this.precio = precio;
        this.volumen = 0;
        this.tipoEnvase = "";
    }

    @Override
    public String toString() {
        String s = "";
        s = "DETERGENTE MARCA: " + marca + "\nCON PRECIO: " + precio;
        if (volumen != 0) {
            s += "\nCON VOLUMEN: " + volumen;
        }
        if (!tipoEnvase.isEmpty()) {
            s += "\nTIPO DE ENVASE: " + tipoEnvase;
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
}
