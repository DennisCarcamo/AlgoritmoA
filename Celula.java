/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;


/**
 *
 * @author Lucas
 */
public class Celula {
    
    private byte posicaoX;
    private byte posicaoY;
    private byte valor;

    public byte getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(byte posicaoX) {
        this.posicaoX = posicaoX;
    }

    public byte getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(byte posicaoY) {
        this.posicaoY = posicaoY;
    }

    public byte getValor() {
        return valor;
    }

    public void setValor(byte valor) {
        this.valor = valor;
    }
    
    public boolean podeSubir() {
        return this.posicaoX > 0;
    }
    
    public boolean podeDescer() {
        return this.posicaoX < Tabuleiro.linhas - 1;
    }
    
    public boolean podeDireita() {
        return this.posicaoY < Tabuleiro.colunas - 1;
    }
    
    public boolean podeEsquerda() {
        return this.posicaoY > 0;
    }
}
