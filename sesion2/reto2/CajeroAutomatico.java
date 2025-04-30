import java.util.Scanner;
public class CajeroAutomatico{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        var saldo = 1000.0;
        int opcion;

        do{
            System.out.println("**********************");
            System.out.println("Bienvenido al cajero automático");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. salir ");
            System.out.println("Seleccione una opción: ");
            System.out.println("**********************");

            opcion = teclado.nextInt();

            switch (opcion){

                case 1: { //consultar saldo
                    System.out.println("Saldo actual: $ "+ saldo );
                    break;
                }
                case 2: { //Hacer deposito
                    System.out.println("Monto a depositar: ");
                    double deposito = teclado.nextDouble(); //Validar deposito

                    if (deposito <= 0 ){
                        System.out.println("El monto debe ser mayor a $0");
                        continue; //Regreso al menú
                    }
                    saldo += deposito;
                    System.out.println("Deposito de: $ " + deposito + " Realizado con éxito");
                    break;
                }
                case 3: { //Retirar dinero
                    System.out.println("Monto a retirar: ");
                    double retiro = teclado.nextDouble();

                    if(retiro <= 0 ){
                        System.out.println("El monto debe ser mayor a $0");
                        break;
                    }
                    if (retiro>saldo){
                        System.out.println("Saldo insuficiente. Su saldo actual es de: $" + saldo);
                        continue;

                    }else{
                        saldo -= retiro;
                        System.out.println("Transacción realizada con éxito. Saldo restante de: $" + saldo);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Gracias por la confianza. ¡Nos vemos pronto!");
                    break;
                }
                default: {
                    System.out.println("Opción invalida. Intente nuevamente.");
                }
            }
        }while (opcion != 4);
        teclado.close();
    }
}
