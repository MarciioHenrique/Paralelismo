package uenp.trabalholp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer[]> dados = Leitor.lerDados();
        int tam = dados.size();
        int fim = tam/4;
        ArrayList<Integer> result = new ArrayList<>();

        Loteria loteria = new Loteria(0, fim, dados);
        Loteria loteria2 = new Loteria(fim, fim*2, dados);
        Loteria loteria3 = new Loteria(fim*2, fim*3, dados);
        Loteria loteria4 = new Loteria(fim*3, tam, dados);
        
        loteria.start();
        loteria2.start();
        loteria3.start();
        loteria4.start();
        loteria.join();
        loteria2.join();
        loteria3.join();
        loteria4.join();
        
        System.out.println("--------------------------");
        
        for (int i = 0; i < 14; i++) {
            result.add(loteria.getSequencias().get(i) + loteria2.getSequencias().get(i) + loteria3.getSequencias().get(i) + loteria4.getSequencias().get(i));
            System.out.println("Sequencias de tamanho "+(i+2)+": "+result.get(i));
        }

    }
}
