package uenp.trabalholp;

import java.util.List;
import java.util.ArrayList;

public class Loteria extends Thread{
    private int inicio;
    private int fim;
    private List<Integer> sequencias;
    private List<Integer[]> dados;
    
    public Loteria(int inicio, int fim, List<Integer[]> dados) {
        this.inicio = inicio;
        this.fim = fim;
        this.sequencias = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            sequencias.add(0);
        }
        this.dados = dados;
    }

    public List<Integer> getSequencias() {
        return sequencias;
    }
    
    public void contaSequencias(Integer[] jogo) {
        int tamanho = jogo.length;
        for (int i = 0; i < tamanho; i++) {
            int sequencia = 1;
            while (i + sequencia < tamanho && jogo[i+sequencia] == jogo[i]+sequencia) {
                sequencia++;
            }
            if (sequencia >= 2 && sequencia <= 15) {
                sequencias.set(sequencia - 2, sequencias.get(sequencia - 2) + 1);
            }
        }
        
    }
    
    @Override
    public void run() {
        System.out.println("Iniciando a contagem de sequencias..."+inicio+" "+fim);
        for (int i = inicio; i < fim; i++) {
            contaSequencias(dados.get(i));
        }
    }
}
