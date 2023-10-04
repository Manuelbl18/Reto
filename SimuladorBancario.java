
import java.util.Scanner;


	public class SimuladorBancario {
		
		//DECLARACION VARIABLES
		double depositoCuentaCorriente;
		double retiroCuentaCorriente;
		double depositarCuentaAhorros;
		double interesMensualAhorros = 0.022;
		double saldoCDT;
		double plazoCDT;
		double interesMensualCDT = 0.052;
		int meses = 0;
		double SaldoTotal = 0;
		
		//METODO PARA DEPOSITO CORRIENTE 
		public void depositarEnCuentaCorriente(double cantidad) {
			depositoCuentaCorriente += cantidad;
			System.out.println("Deposito exitoso en cuenta corriente: Saldo actual " + depositoCuentaCorriente);
		}
		//METODO PARA RETIRAR EN CUENTA CORRIENTE
		public void retirarDeCuentaCorriente (double cantidad) {
			depositoCuentaCorriente -= cantidad;
			System.out.println("Su retiro en cuenta corriente ha sido exitoso ");
		}
		
		//METODO PARA DEPOSITAR EN CUENTA AHORROS
		public void depositarEnCuentaAhorros(double cantidad) {
			depositarCuentaAhorros += cantidad;
			System.out.println("Su Deposito en cuenta de Ahorros ha sido exitoso: Saldo total " + depositarCuentaAhorros);
		}
		//OPTION CDT
		public void cerrarCDT() {
			double intereses = saldoCDT * (interesMensualCDT * plazoCDT);
			SaldoTotal += interesMensualCDT;
			saldoCDT = 0;
			plazoCDT = 0;
			System.out.println("Su CDT ha sido cerrado exitosamente ");
		}
		//AVANZAR MES
		public void avanzarMes() {
			meses++;
			depositarCuentaAhorros += depositarCuentaAhorros * interesMensualAhorros;
			saldoCDT += saldoCDT * interesMensualCDT;
			System.out.println("Avanzo un mes ");
		}
		//VER SALDO TOTAL 
		public void verSaldoTotal() {
			SaldoTotal = depositarCuentaAhorros + depositoCuentaCorriente + saldoCDT;
			System.out.println("Saldo total: " + SaldoTotal);
		}
		public void Salir() {
			System.out.println("Has salido del simulador, Todo bien mi parcero");
		}
	
		
		//MOSTRAR EN PANTALLA
		public static void main(String args[]) {
			Scanner scanner = new Scanner(System.in);
			SimuladorBancario simulador = new SimuladorBancario();
			
			while (true) {
				System.out.println("Simulacion de Cuenta Bancaria");
				System.out.println("1. Deposito de Cuenta Corriente");
				System.out.println("2. Retiro de Cuenta Corriente");
				System.out.println("3. Deposito en Cuenta de Ahorros");
				System.out.println("4. Abrir CDT");
				System.out.println("5. Cerrar CDT");
				System.out.println("6. Avanzar mes");
				System.out.println("7. Ver Saldo Total");
				System.out.println("8. Salir");
				System.out.print("Seleccione una opcion");
				int option = scanner.nextInt();
				
				//CREACION DE OPCIONES 	
				
				switch (option) {
					case 1:
						System.out.print("Ingrese la cantidad a depositar en cuenta corriete");
						double depositoCuentaCorriente = scanner.nextDouble();
						simulador.depositarEnCuentaCorriente(depositoCuentaCorriente);
						break;
					case 2:
						System.out.print("Ingrese la cantidad a retirar en cuenta corriente");
						double retiroCuentaCorriente = scanner.nextDouble();
						simulador.retirarDeCuentaCorriente(retiroCuentaCorriente);
						break;
					case 3:
						System.out.print("Ingrese la cantidad a despositar en cuenta de Ahorros");
						double depositoAhorros = scanner.nextDouble();
						simulador.depositarEnCuentaAhorros(depositoAhorros);
						break;
					case 4:
						if (simulador.saldoCDT == 0) {
					        System.out.print("Ingrese la cantidad a invertir en CDT");
					        double inversionCDT = scanner.nextDouble();
					        System.out.print("Ingrese el plazo en meses: ");
					        simulador.saldoCDT = inversionCDT;
					        int plazo = scanner.nextInt();
					        System.out.println("Su CDT ha sido creado exitosamente");
					    } else {
					        System.out.println("Ya tiene un CDT abierto. No puede abrir otro.");
					    }
					    break;
					case 5:
						simulador.cerrarCDT();
						break;
					case 6:
						simulador.avanzarMes();
						break;
					case 7:
						simulador.verSaldoTotal();
						break;
					case 8:
						simulador.Salir();
						scanner.close();
						System.exit(0);
						break;
				}
				
			}
			
		}
		
	}
	
