/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

import projeto2.Celula;

/**
 *
 * @author Lucas
 */
public class Tabuleiro {

    /**
     *
     * @param inicial
     */
    public Tabuleiro(byte[][] inicial) {
        this.estado = new Celula[4][4];
        copiaEstadoInicialParaTabuleiro(inicial);
    }

    private void copiaEstadoInicialParaTabuleiro(byte[][] inicial) {
        //Talvez eu consiga solucionar isso com um Hash??!
        this.inicial = inicial;
        for (byte linha = 0; linha <= 3; linha++) {
            for (byte coluna = 0; coluna <= 3; coluna++) {
                Celula celulaAtual = new Celula();
                estado[linha][coluna] = celulaAtual;
                celulaAtual.setPosicaoX(linha);
                celulaAtual.setPosicaoY(coluna);
                celulaAtual.setValor(inicial[linha][coluna]);
//                System.err.print( inicial[linha][coluna] );
//                System.err.print( "     " );
//                System.err.print( solucao[linha][coluna] );                

                if (inicial[linha][coluna] == 0) {
                    celulaDeControle = celulaAtual;
                }
                if (solucao[linha][coluna] != inicial[linha][coluna]) {
                    pecasForaDoLugar += 1;
                }
            }
        }
    }

    byte[][] inicial;
    static final byte[][] solucao = {{1, 2, 3, 4},
    {12, 13, 14, 5},
    {11, 0, 15, 6},
    {10, 9, 8, 7}};
    static final byte linhas = 4;
    static final byte colunas = 4;
    private final Celula[][] estado;
    private byte pecasForaDoLugar = 0;
    private Celula celulaDeControle;
    
    public Celula getCelula( byte x, byte y ) {        
        return estado[ x ][ y ];
    }

    public Celula getCelulaDeControle() {
        return celulaDeControle;
    }

    public void setCelulaDeControle(Celula celulaDeControle) {
        this.celulaDeControle = celulaDeControle;
    }

    public byte getPecasForaDoLugar() {
        return pecasForaDoLugar;
    }

    public void movaPeca(Celula peca) {
        celulaDeControle.setValor(peca.getValor());
        peca.setValor((byte) 0);
        celulaDeControle = peca;
    }

}
