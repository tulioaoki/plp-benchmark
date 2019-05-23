package benchmarkimperativo;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 *
 * @author tulioaoki && lucasbaroni
 */
public class BenchmarkImperativo {
    public static void main(String[] args) {
        int aux [];
        int [] tamanhos = {1000, 5000, 10000, 50000, 100000};
        //Execução ArraySort
        System.out.println("ArraySort Inverso");
        for(int t : tamanhos){
            int [] vetor = gerar_vetor(t, 1);   
            long startTime = System.nanoTime();
            aux = array_sort(vetor);
            long stopTime = System.nanoTime();
            double tempo_em_ms;
            tempo_em_ms = (stopTime - startTime) / Math.pow(10, 6);
            System.out.println("Vetor de tamanho "+t+ "-> Tempo de execuçao em milissegundos: " + tempo_em_ms);
            System.gc();
        }
        // Aleatorio
        System.out.println("ArraySort Aleatorio");
        for(int t : tamanhos){
            int [] vetor = gerar_vetor(t, 2);   
            long startTime = System.nanoTime();
            aux = array_sort(vetor);
            long stopTime = System.nanoTime();
            double tempo_em_ms;
            tempo_em_ms = (stopTime - startTime) / Math.pow(10, 6);
            System.out.println("Vetor de tamanho "+t+ "-> Tempo de execuçao em milissegundos: " + tempo_em_ms);
            System.gc();
        }
        
        //Execução heap
        System.out.println("Heap Inverso");
        for(int t : tamanhos){
            int [] vetor = gerar_vetor(t, 1);   
            long startTime = System.nanoTime();
            heap_sort(vetor);
            long stopTime = System.nanoTime();
            double tempo_em_ms;
            tempo_em_ms = (stopTime - startTime) / Math.pow(10, 6);
            System.out.println("Vetor de tamanho "+t+ "-> Tempo de execuçao em milissegundos: " + tempo_em_ms);
            System.gc();
        }
        
        System.out.println("Heap Aleatorio");
        for(int t : tamanhos){
            int [] vetor = gerar_vetor(t, 2);   
            long startTime = System.nanoTime();
            heap_sort(vetor);
            long stopTime = System.nanoTime();
            double tempo_em_ms;
            tempo_em_ms = (stopTime - startTime) / Math.pow(10, 6);
            System.out.println("Vetor de tamanho "+t+ "-> Tempo de execuçao em milissegundos: " + tempo_em_ms);
            System.gc();
        }
        
        //Execução Quick
        
        System.out.println("Quick Inverso");
        for(int t : tamanhos){
            int [] vetor = gerar_vetor(t, 1);
            long startTime = System.nanoTime();
            try{
                quick_sort(vetor);
            }catch(StackOverflowError e){
                System.out.println("Stack Overflow!!!");
            }
            long stopTime = System.nanoTime();
            double tempo_em_ms;
            tempo_em_ms = (stopTime - startTime) / Math.pow(10, 6);
            System.out.println("Vetor de tamanho "+t+ "-> Tempo de execuçao em milissegundos: " + tempo_em_ms);
            System.gc();
        }

        System.out.println("Quick Aleatorio");
        for(int t : tamanhos){
            int [] vetor = gerar_vetor(t, 2);
            long startTime = System.nanoTime();
            quick_sort(vetor);
            long stopTime = System.nanoTime();
            double tempo_em_ms;
            tempo_em_ms = (stopTime - startTime) / Math.pow(10, 6);
            System.out.println("Vetor de tamanho "+t+ "-> Tempo de execuçao em milissegundos: " + tempo_em_ms);
            System.gc();
        }
        
        
        //Execução Bubble
        System.out.println("Bubble Inverso");
        for(int t : tamanhos){
            int [] vetor = gerar_vetor(t, 1);
            long startTime = System.nanoTime();
            bubble_sort(vetor);
            long stopTime = System.nanoTime();
            double tempo_em_ms;
            tempo_em_ms = (stopTime - startTime) / Math.pow(10, 6);
            System.out.println("Vetor de tamanho "+t+ "-> Tempo de execuçao em milissegundos: " + tempo_em_ms);
            System.gc();
        }
        
        //Execução Bubble
        System.out.println("Bubble Aleatório");
        for(int t : tamanhos){
            int [] vetor = gerar_vetor(t, 2);
            long startTime = System.nanoTime();
            bubble_sort(vetor);
            long stopTime = System.nanoTime();
            double tempo_em_ms;
            tempo_em_ms = (stopTime - startTime) / Math.pow(10, 6);
            System.out.println("Vetor de tamanho "+t+ "-> Tempo de execuçao em milissegundos: " + tempo_em_ms);
            System.gc();
        } 
    }
    
    //Array Sort
    public static int[] array_sort(int[] v) {
        Arrays.sort(v);
        return v;
    }
    
    //Bubble Sort
    public static int[] bubble_sort(int[] v){
        int fim = v.length - 2;
        int pos = 0;
        boolean troca = true;
        int chave;
        int i;
        while (troca) {
            troca = false;
            for (i = 0; i <= fim; i++) {
                if (v[i] > v[i+1]) {
                    chave = v[i];
                    v[i] = v[i+1];
                    v[i+1] = chave;
                    pos = i;
                    troca = true;
                }
            }
            fim = pos-1;
        }
        return v;
    }
    
    //Heap Sort
    public static void heapsort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    public static int[] heap_sort(int[] vector) {
        heapsort(vector);
        return vector;
    }
    // Heap Sort end
    
    
    //Quick Sort
    public static int[] quick_sort(int[] V) {
        quickSort(V,0 , V.length - 1);
        return V;
    }


    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[f])
                f--;
            else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
    
    public static int [] gerar_vetor(int tamanho, int tipo){
        switch(tipo){
            case 0:
                return gerarOrdenado(tamanho);
            case 1:
                return gerarReverso(tamanho);
            case 2:
                return gerarAleatorio(tamanho);
            default:
                System.out.println("Invalid");
                throw new UnsupportedOperationException("Not supported yet."); 
        }
    } 

    private static int[] gerarOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for(int i = 0; i < vetor.length;i++){
            vetor[i] = i;
        }
        return vetor;
    }

    private static int[] gerarReverso(int tamanho) {
        int[] vetor = new int[tamanho];
        for(int i = 0; i < vetor.length;i++){
            vetor[i] = tamanho - i;
        }
        return vetor;
    }

    private static int[] gerarAleatorio(int tamanho) {
        SecureRandom r = new SecureRandom();
        int[] vetor = new int[tamanho];
        for(int i = 0; i < vetor.length;i++){
            vetor[i] = r.nextInt();
        }
        return vetor;
    }
    
}
