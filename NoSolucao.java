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
public final class NoSolucao {

    private Tabuleiro tabuleiro;
    private int quantidadeDeMovimentos; //g(n)
    private int pecasForaDoLugar; //h(n)    
    private NoSolucao noPai; 

    private ArrayList<NoSolucao> filhos;

    public NoSolucao(Tabuleiro tabuleiroOrigem, int quantitadeDeMovimentos, NoSolucao noPai) {

        Tabuleiro novoTabuleiro = new Tabuleiro(tabuleiroOrigem.inicial);
        this.setTabuleiro(novoTabuleiro);
        this.setPecasForaDoLugar(novoTabuleiro.getPecasForaDoLugar());
        this.setQuantidadeDeMovimentos(quantitadeDeMovimentos);
        this.setNoPai(noPai);

    }

    public NoSolucao(byte[][] inicial) {

        Tabuleiro tabuleiro = new Tabuleiro(inicial);
        this.setTabuleiro(tabuleiro);
        this.setPecasForaDoLugar(tabuleiro.getPecasForaDoLugar());
        this.setQuantidadeDeMovimentos(0);
        this.setNoPai(null);

    }
    
    public int custo() {
        return this.quantidadeDeMovimentos + this.pecasForaDoLugar;
    }
    
    public ArrayList<NoSolucao> addFilho(NoSolucao noSolucao) {
        filhos.add(noSolucao);
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

    public NoSolucao getNoPai() {
        return noPai;
    }

    public void setNoPai(NoSolucao noPai) {
        this.noPai = noPai;
    }
}
