/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public class AlgoritmoAEstrela {
    
    private Map<Integer,NoSolucao> estadosAbertos;
    private Map<Integer,NoSolucao> estadosFechados;
    
    

    public AlgoritmoAEstrela( NoSolucao noRaiz ) {
        estadosAbertos = new HashMap<Integer,NoSolucao>();
        estadosFechados = new HashMap<Integer,NoSolucao>();
        estadosAbertos.put(noRaiz.getTabuleiro().getHashCode(),noRaiz);
//        estadosAbertos.remove(noRaiz.getTabuleiro().getHashCode()); Como retirar
        
        
        
    }            
    
    private NoSolucao umDosSucessoresESolucao( NoSolucao no ) {
        
        for (NoSolucao filho : no.getFilhos()) {
            
            if ( filho.getPecasForaDoLugar() == 0 )
                return filho;
        }
        return null;
        
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
