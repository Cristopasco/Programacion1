import java.util.Scanner;

public class Arreglos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[5];

        System.out.println("Ingrese las 5 notas (de 1.0 a 5.0):");
        for (int i = 0; i < 5; i++) {
            double nota;
            do {
                System.out.print("Nota " + (i + 1) + ": ");
                nota = scanner.nextDouble();
                if (nota < 1.0 || nota > 5.0) {
                    System.out.println("Error: La nota debe estar entre 1.0 y 5.0");
                }
            } while (nota < 1.0 || nota > 5.0);
            notas[i] = nota;
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
            System.out.printf("Nota %d: %.1f%n", (i + 1), notas[i]);
        }
        System.out.printf("Nota definitiva: %.1f%n", definitiva);
        System.out.printf("Nota mayor: %.1f%n", mayor);
        System.out.printf("Nota menor: %.1f%n", menor);
        System.out.println("Notas ordenadas (ascendente):");
        for (double nota : notasOrdenadas) {
            System.out.printf("%.1f ", nota);
        }
        System.out.printf("%nNota ponderada (con pesos 15,20,25,20,20%%): %.1f%n", sumaPonderada);

        scanner.close();
    }
}