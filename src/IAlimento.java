import java.util.Date;

public interface IAlimento {
    void setCaducidad(Date caducidad);
    Date getCaducidad();
    int getCalorias();
}
