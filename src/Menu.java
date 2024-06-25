import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final String UPPER_AND_BOTTOM_MENU = "-----------------------------";
    private final String SEPARATOR_TEXT_MENU =   "|                           |";

    private List<IAlimento> iAlimentoList;
    private boolean firstInitMenu;
    private Scanner scanner;

    public Menu() {
        this.iAlimentoList = new LinkedList<>();
        firstInitMenu = true;
        scanner = new Scanner(System.in);
    }

    public void initMenu() {
        int optionSelected;
        if (firstInitMenu == true) {
            System.out.println("BIENVENID@ AL CREADOR DE PRODUCTOS\nSELECCIONE UNA DE LAS OPCIONES");
            firstInitMenu = false;
        }
        System.out.println();
        System.out.println("            MENU");
        System.out.println(UPPER_AND_BOTTOM_MENU);
        System.out.println(SEPARATOR_TEXT_MENU);
        System.out.println("| (1) Crear Detergente      |");
        System.out.println("| (2) Crear Cereales        |");
        System.out.println("| (3) Crear Vino            |");
        System.out.println("| (4) Calcular Calorias     |");
        System.out.println("| (0) Salir                 |");
        System.out.println(SEPARATOR_TEXT_MENU);
        System.out.println(UPPER_AND_BOTTOM_MENU);
        optionSelected = scanner.nextInt();
        scanner.nextLine();
        switch (optionSelected) {
            case 0:
                System.out.println("GRACIAS POR USAR LA APP");
                break;
            case 1:
                crearDetergente();
                break;
            case 2:
                crearCereales();
                break;
            case 3:
                crearVino();
                break;
            case 4:
                calcularCalorias();
                break;
            default:
                System.out.println("Por favor introduzca una opción valida");
                initMenu();
                break;
        }
    }



    private void crearDetergente() {
        System.out.print("Introduzca la marca del detergente: ");
        String marca = scanner.nextLine();
        System.out.print("Introduzca el precio del detergente(usa la \",\" para separar los decimales): ");
        float precio = scanner.nextFloat();
        scanner.nextLine();
        Detergente newDetergente = new Detergente(marca, precio);
        detergenteaAtributosAdicionales(newDetergente);
    }

    public void detergenteaAtributosAdicionales(Detergente newDetergente) {
        System.out.println("ATRIBUTOS ADICIONALES");
        System.out.println(UPPER_AND_BOTTOM_MENU);
        System.out.println(SEPARATOR_TEXT_MENU);
        System.out.println("| (1) Añadir volumen        |");
        System.out.println("| (2) Añadir tipo de envase |");
        System.out.println("| (3) Añadir descuento      |");
        System.out.println("| (0) Volver al menu        |");
        System.out.println(SEPARATOR_TEXT_MENU);
        System.out.println(UPPER_AND_BOTTOM_MENU);
        int optionSelected = scanner.nextInt();
        scanner.nextLine();
        switch (optionSelected) {
            case 0:
                System.out.println("VOLVIENDO AL MENU");
                System.out.println(newDetergente);
                initMenu();
                return;
            case 1:
                addVolumen(newDetergente, newDetergente.getMarca());
                System.out.println(newDetergente);
                detergenteaAtributosAdicionales(newDetergente);
                return;
            case 2:
                addTipoEnvase(newDetergente, newDetergente.getMarca());
                System.out.println(newDetergente);
                detergenteaAtributosAdicionales(newDetergente);
                return;
            case 3:
                addDescuento(newDetergente, newDetergente.getMarca());
                System.out.println(newDetergente);
                detergenteaAtributosAdicionales(newDetergente);
                return;
            default:
                System.out.println("INTRODUZCA UNA OPCIÓN VALIDA");
                detergenteaAtributosAdicionales(newDetergente);
                break;
        }
        detergenteaAtributosAdicionales(newDetergente);
    }

    private void addVolumen(ILiquido newLiquido, String marca) {
        System.out.print("Introduzca el volumen de " + marca + ": ");
        float volumen = scanner.nextFloat();
        scanner.nextLine();
        newLiquido.setVolumen(volumen);
    }

    private void addTipoEnvase(ILiquido newLiquido, String marca) {
        System.out.print("Introduzca el tipo de envase de " + marca + ": ");
        String tipoEnvase = scanner.nextLine();
        newLiquido.setTipoEnvase(tipoEnvase);
    }

    private void addDescuento(IDescuento newDescuento, String marca) {
        System.out.print("Introduzca el descuento de " + marca + ": ");
        float descuento = scanner.nextFloat();
        scanner.nextLine();
        newDescuento.setDescuento(descuento);
    }

    private void crearCereales() {
        System.out.print("Introduzca la marca de los cereales: ");
        String marca = scanner.nextLine();
        System.out.print("Introduzca el precio de los cereales(usa la \",\" para separar los decimales): ");
        float precio = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Introduzca el tipo de cereal: ");
        String tipoCereal = scanner.nextLine();
        Cereales newCereal = new Cereales(marca, precio, tipoCereal);
        cerelaesAtributosAdicionales(newCereal);
    }

    public void cerelaesAtributosAdicionales(Cereales newCereal) {
        System.out.println("ATRIBUTOS ADICIONALES");
        System.out.println(UPPER_AND_BOTTOM_MENU);
        System.out.println(SEPARATOR_TEXT_MENU);
        System.out.println("| (1) Añadir fecha cacucidad|");
        System.out.println("| (0) Volver al menu        |");
        System.out.println(SEPARATOR_TEXT_MENU);
        System.out.println(UPPER_AND_BOTTOM_MENU);
        int optionSelected = scanner.nextInt();
        scanner.nextLine();
        switch (optionSelected) {
            case 0:
                System.out.println("VOLVIENDO AL MENU");
                System.out.println(newCereal);
                iAlimentoList.add(newCereal);
                initMenu();
                return;
            case 1:
                addCaducidad(newCereal);
                System.out.println(newCereal);
                cerelaesAtributosAdicionales(newCereal);
                return;
            default:
                System.out.println("INTRODUZCA UNA OPCIÓN VALIDA");
                cerelaesAtributosAdicionales(newCereal);
                break;
        }
        cerelaesAtributosAdicionales(newCereal);
    }

    private void addCaducidad(IAlimento newCaducidad) {
        newCaducidad.setCaducidad(new Date());
    }

    private void crearVino() {
        System.out.print("Introduzca la marca de el vino: ");
        String marca = scanner.nextLine();
        System.out.print("Introduzca de que tipo es el vino: ");
        String tipoVino = scanner.nextLine();
        System.out.println("Introduzca cuantos grados de alcohol tiene el vino: ");
        float gradosAlcohol = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Introduzca el precio del vino(usa la \",\" para separar los decimales): ");
        float precio = scanner.nextFloat();
        scanner.nextLine();
        Vino newVino = new Vino(marca, tipoVino, gradosAlcohol, precio);
        vinoAtributosAdicionales(newVino);
    }

    private void vinoAtributosAdicionales(Vino newVino) {
        System.out.println("ATRIBUTOS ADICIONALES");
        System.out.println(UPPER_AND_BOTTOM_MENU);
        System.out.println(SEPARATOR_TEXT_MENU);
        System.out.println("| (1) Añadir fecha cacucidad|");
        System.out.println("| (2) Añadir volumen        |");
        System.out.println("| (3) Añadir tipo de envase |");
        System.out.println("| (4) Añadir descuento      |");
        System.out.println("| (0) Volver al menu        |");
        System.out.println(SEPARATOR_TEXT_MENU);
        System.out.println(UPPER_AND_BOTTOM_MENU);
        int optionSelected = scanner.nextInt();
        scanner.nextLine();
        switch (optionSelected) {
            case 0:
                System.out.println("VOLVIENDO AL MENU");
                System.out.println(newVino);
                iAlimentoList.add(newVino);
                initMenu();
                return;
            case 1:
                addCaducidad(newVino);
                System.out.println(newVino);
                return;
            case 2:
                addVolumen(newVino, newVino.getMarca());
                System.out.println(newVino);
                vinoAtributosAdicionales(newVino);
                return;
            case 3:
                addTipoEnvase(newVino, newVino.getMarca());
                System.out.println(newVino);
                vinoAtributosAdicionales(newVino);
                return;
            case 4:
                addDescuento(newVino, newVino.getMarca());
                System.out.println(newVino);
                vinoAtributosAdicionales(newVino);
                return;
            default:
                System.out.println("INTRODUZCA UNA OPCIÓN VALIDA");
                vinoAtributosAdicionales(newVino);
                break;
        }
        vinoAtributosAdicionales(newVino);
    }

    private void calcularCalorias() {
        float sumaCalorias = 0;
        for (IAlimento element: iAlimentoList) {
            sumaCalorias += element.getCalorias();
        }
        System.out.println("LA SUMA DE LAS CALORIAS DE LA LISTA ES: " + sumaCalorias);
        initMenu();
    }
}
