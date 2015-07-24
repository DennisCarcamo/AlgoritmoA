/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class NoSolucao {
    
    private Tabuleiro tabuleiro;
    private int quantidadeDeMovimentos; //g(n)
    private int pecasForaDoLugar; //h(n)
    private ArrayList<NoSolucao> filhos; 
    
    
    public ArrayList<NoSolucao> addFilho( NoSolucao noSolucao ) {
        filhos.add( noSolucao );
        return filhos;
    }    

    public ArrayList<NoSolucao> getFilhos() {
        return filhos;
    }   

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getQuantidadeDeMovimentos() {
        return quantidadeDeMovimentos;
    }

    public void setQuantidadeDeMovimentos(int quantidadeDeMovimentos) {
        this.quantidadeDeMovimentos = quantidadeDeMovimentos;
    }

    public int getPecasForaDoLugar() {
        return pecasForaDoLugar;
    }

    public void setPecasForaDoLugar(int pecasForaDoLugar) {
        this.pecasForaDoLugar = pecasForaDoLugar;
    }
    
    
}
