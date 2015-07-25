/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public class AlgoritmoAEstrela {

    private Map<Integer, NoSolucao> estadosAbertos;
    private Map<Integer, NoSolucao> estadosFechados;
    private Map<Integer, NoSolucao> estadosFinais;
    private ArrayList<NoSolucao> sucessores;
            
    public AlgoritmoAEstrela(NoSolucao noRaiz) {
        estadosAbertos = new HashMap<>();
        estadosFechados = new HashMap<>();
        estadosFinais = new HashMap<>();
        estadosAbertos.put(noRaiz.getTabuleiro().getHashCode(), noRaiz);

        NoSolucao noSolucao;
        noSolucao = new NoSolucao(Tabuleiro.solucao);
        estadosFinais.put(noSolucao.getTabuleiro().getHashCode(), noSolucao);

//        estadosAbertos.remove(noRaiz.getTabuleiro().getHashCode()); Como retirar
    }
    
    public int encontreASolucao(){
        NoSolucao noSolucao;
        noSolucao = null;
        
        while (!estadosAbertos.isEmpty()) {
            NoSolucao no;
            no = this.oMenorNosAbertos();
            
            estadosAbertos.remove(no.getTabuleiro().getHashCode());
            estadosFechados.put(no.getTabuleiro().getHashCode(), no);
            
            if (estadosFinais.containsKey(no.getTabuleiro().getHashCode())){
                return no.getQuantidadeDeMovimentos();
            }
            
            
            
            
        }
        
        if (noSolucao == null)
            return -1;
        
        return noSolucao.getQuantidadeDeMovimentos();
    }
    
    public NoSolucao oMenorNosAbertos(){
        NoSolucao no;
        
        no = null;
        
        for (Map.Entry<Integer, NoSolucao> noCompar : estadosAbertos.entrySet()) {            
            if (estadosFinais.containsKey(noCompar.getKey())){
                return noCompar.getValue();
            }
            if (no == null || noCompar.getValue().custo() < no.custo())
                no = noCompar.getValue();            
        }
        return no;
    }

    private void geradorDeSucessores(NoSolucao no) {

        Celula celulaDeControle = no.getTabuleiro().getCelulaDeControle();
        if (celulaDeControle.podeSubir()) {
            NoSolucao novoNo = new NoSolucao(no.getTabuleiro(), no.getQuantidadeDeMovimentos() + 1, no);
            novoNo.getTabuleiro().movaPeca(novoNo.getTabuleiro().getCelula((byte) (novoNo.getTabuleiro().getCelulaDeControle().getPosicaoX() - 1), novoNo.getTabuleiro().getCelulaDeControle().getPosicaoY()));
            no.addFilho(novoNo);

        }

        if (celulaDeControle.podeDescer()) {
            NoSolucao novoNo = new NoSolucao(no.getTabuleiro(), no.getQuantidadeDeMovimentos() + 1, no);
            novoNo.getTabuleiro().movaPeca(novoNo.getTabuleiro().getCelula((byte) (novoNo.getTabuleiro().getCelulaDeControle().getPosicaoX() + 1), novoNo.getTabuleiro().getCelulaDeControle().getPosicaoY()));
            no.addFilho(novoNo);

        }

        if (celulaDeControle.podeEsquerda()) {
            NoSolucao novoNo = new NoSolucao(no.getTabuleiro(), no.getQuantidadeDeMovimentos() + 1, no);
            novoNo.getTabuleiro().movaPeca(novoNo.getTabuleiro().getCelula(novoNo.getTabuleiro().getCelulaDeControle().getPosicaoX(), (byte) (novoNo.getTabuleiro().getCelulaDeControle().getPosicaoY() - 1)));
            no.addFilho(novoNo);

        }

        if (celulaDeControle.podeDireita()) {
            NoSolucao novoNo = new NoSolucao(no.getTabuleiro(), no.getQuantidadeDeMovimentos() + 1, no);
            novoNo.getTabuleiro().movaPeca(novoNo.getTabuleiro().getCelula(novoNo.getTabuleiro().getCelulaDeControle().getPosicaoX(), (byte) (novoNo.getTabuleiro().getCelulaDeControle().getPosicaoY() + 1)));
            no.addFilho(novoNo);

        }

    }

}
