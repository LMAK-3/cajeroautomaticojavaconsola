import java.util.Scanner;
import java.util.Date;
public class cajero_automatico {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String historial_banca = "";
        System.out.print("Ingrese el nombre: ");
        String name =  input.next();
        System.out.print("Ingrese la edad: ");
        int number = input.nextInt();
        if(number < 18) {
            System.out.print("La persona es menor de edad\n\tDebes ser mayor de edad.\n\n");
            System.out.print("Reingrese la edad: ");
            number = input.nextInt();
        }
        System.out.print("Ingrese saldo inicial: ");
        int saldo_initial = input.nextInt();
        if(saldo_initial < 150000) {
            System.out.print("El saldo inicial debe ser igual o superior $150000\n\n");
            System.out.print("Reingrese saldo inicial: ");
            saldo_initial = input.nextInt();
        }
        System.out.print("\n\nUsuario Registrado Correctamente:\n~Nombre: "+name+"\n~Edad: "+number+"\n~Saldo: "+saldo_initial+
                "\n");
        while (true){
            System.out.print("\n\n\t\t~~~Cajero~~~\n\tBienvenido "+name+".\n\tEstas son tus opciones"+
                "\n\n\t\t1) Ver saldo\n\t\t2) Cosignar\n\t\t3) Retirar\n\t\t4) Salir\n\n");
            System.out.print("Ingrese Una opción: ");
            int options = input.nextInt();
            if(options >= 1 && options <= 3){
                Date fecha = new Date();
                switch(options){
                    case 1:
                        System.out.print("\n\t~Saldo Actual: $"+saldo_initial);
                        if(!historial_banca.isEmpty()){
                            System.out.print("\n\n\t\t~~~~Historial Bancario~~~~:\n\n"+historial_banca+"\n\n\t\t~~~~Fin Historial Bancario~~~~");
                        }
                        break;
                    case 2:
                        System.out.print("¿Qué cantidad de dinero quiere cosignar?: ");
                        int consigna = input.nextInt();
                        saldo_initial += consigna;
                        historial_banca += "\t\t~Fecha: "+fecha+"\t~Consignación: $"+consigna+"\t~Saldo: $"+saldo_initial+"\n";
                        System.out.print("\n~Has cosignado $"+consigna+".\n");
                        break;
                    case 3:
                        System.out.print("¿Qué cantidad de dinero quiere retirar?: ");
                        int retiro = input.nextInt();
                        saldo_initial -= retiro;
                        if(saldo_initial < 100000){
                            saldo_initial += retiro;
                            System.out.print("~[ALERTA] Tu Cuenta bancaria no puede tener un saldo inferior a $100000.");
                        }
                        else {
                            historial_banca += "\t\t~Fecha:"+fecha+"\t~Retiró: $"+retiro+"\t~Saldo: $"+saldo_initial+"\n";
                            System.out.print("\n~Has retirado $"+retiro+".\n");
                        }
                        break;
                }
            }
            else if(options == 4){
                System.out.print("Has salido correctamente de tu cuenta bancaria.");
                break;
            }else{
                System.out.print("Opción ingresada no valida.");
            }
        }
    }
}
