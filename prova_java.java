import java.util.Arrays;

public class Prova {

    public static boolean contem(int[] v, int tam, int x) {
        for (int i = 0; i < tam; i++) {
            if (v[i] == x) {
                return true;
            }
        }
        return false;
    }

    public static void inverter(int[] v, int ini, int fim) {
        while (ini < fim) {
            int aux = v[ini];
            v[ini] = v[fim];
            v[fim] = aux;
            ini++;
            fim--;
        }
    }

    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
        int tamU = 0;
        for (int i = 0; i < tamA; i++) {
            if (!contem(u, tamU, a[i])) {
                u[tamU] = a[i];
                tamU++;
            }
        }
        for (int i = 0; i < tamB; i++) {
            if (!contem(u, tamU, b[i])) {
                u[tamU] = b[i];
                tamU++;
            }
        }
        return tamU;
    }

    public static void ordenar(int[] v, int n) {
        for (int i = 1; i < n; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
    }

    public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
        int tamVSR = 0;
        for (int i = 0; i < tamV; i++) {
            if (!contem(vsr, tamVSR, v[i])) {
                vsr[tamVSR] = v[i];
                tamVSR++;
            }
        }
        return tamVSR;
    }

    public static void rotacionar(int[] v, int tam, int k) {
        if (tam <= 1) {
            return;
        }
        k = k % tam;
        if (k < 0) {
            k = k + tam;
        }
        if (k == 0) {
            return;
        }
        inverter(v, 0, k - 1);
        inverter(v, k, tam - 1);
        inverter(v, 0, tam - 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 5};
        int[] b = {3, 4, 5, 6, 6};
        int[] u = new int[a.length + b.length];
        int tamU = uniao(a, a.length, b, b.length, u);
        System.out.println("Uniao: " + Arrays.toString(Arrays.copyOf(u, tamU)) + " tam=" + tamU);

        int[] c = {9, 4, 7, 1, 8, 2};
        ordenar(c, c.length);
        System.out.println("Ordenado: " + Arrays.toString(c));

        int[] v = {5, 2, 5, 3, 3, 8, 3, 8, 2};
        int[] vsr = new int[v.length];
        int tamVSR = gerarVetorSemRepeticao(v, v.length, vsr);
        System.out.println("VSR: " + Arrays.toString(Arrays.copyOf(vsr, tamVSR)) + " tam=" + tamVSR);

        int[] r1 = {1, 2, 3, 4, 5};
        rotacionar(r1, r1.length, 2);
        System.out.println("k=2: " + Arrays.toString(r1));

        int[] r2 = {1, 2, 3, 4, 5};
        rotacionar(r2, r2.length, -1);
        System.out.println("k=-1: " + Arrays.toString(r2));
    }
}