import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[5];

        System.out.println("Ingrese las 5 notas:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        double definitiva = suma / 5;

        double mayor = notas[0];
        double menor = notas[0];
        for (double nota : notas) {
            if (nota > mayor) mayor = nota;
            if (nota < menor) menor = nota;
        }

        double[] notasOrdenadas = notas.clone();
        for (int i = 0; i < notasOrdenadas.length - 1; i++) {
            for (int j = 0; j < notasOrdenadas.length - 1 - i; j++) {
                if (notasOrdenadas[j] > notasOrdenadas[j + 1]) {
                    double temp = notasOrdenadas[j];
                    notasOrdenadas[j] = notasOrdenadas[j + 1];
                    notasOrdenadas[j + 1] = temp;
                }
            }
        }

        double sumaPonderada = 0;
        double[] pesos = {0.15, 0.20, 0.25, 0.20, 0.20};
        for (int i = 0; i < 5; i++) {
            sumaPonderada += notas[i] * pesos[i];
        }

        System.out.println("\n=== RESUMEN DE NOTAS ===");
        System.out.println("Notas ingresadas:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Nota " + (i + 1) + ": " + notas[i]);
        }
        System.out.println("Nota definitiva: " + definitiva);
        System.out.println("Nota mayor: " + mayor);
        System.out.println("Nota menor: " + menor);
        System.out.println("Notas ordenadas (ascendente):");
        for (double nota : notasOrdenadas) {
            System.out.print(nota + " ");
        }
        System.out.println("\nNota ponderada (con pesos 15,20,25,20,20%): " + sumaPonderada);

        scanner.close();
    }
}