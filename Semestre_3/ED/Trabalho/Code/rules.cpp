#define zero 0
#include <iostream>

/** 
  Contem todas as todas as funcoes responsaveis pelas regras do Sudoku.

**/

// Vazio representado por 0
bool encontraLugarVazio(int tab[9][9], int &lin, int &col){
  for (lin = 0; lin < 9; lin++){
    for (col = 0; col < 9; col++){
      if (tab[lin][col] == zero){
        return true;
      }
    }
  }

  return false;
}

// Verifica se numero ja existe na linha
bool presenteNaLinha(int tab[9][9], int lin, int num){
  for (int col = 0; col < 9; col++){
    if (tab[lin][col] == num){
      return true;
    }
  }

  return false;
}

// Verifica se numero ja existe na coluna
bool presenteNaColuna(int tab[9][9], int col, int num){
  for (int lin = 0; lin < 9; lin++){
    if (tab[lin][col] == num){
      return true;
    }
  }

  return false;
}

// Verifica se numero ja existe na caixa
bool presenteNaCaixa(int tab[9][9], int comeco_Lin, int comeco_Col, int num){
  for (int lin = 0; lin < 3; lin++){
    for (int col = 0; col < 3; col++){
      if (tab[lin+comeco_Lin][col+comeco_Col] == num){
        return true;
      }
    }
  }

  return false;
}

// Verifica se numero ja existe na linham coluna e caixa
// juncao das outras
bool isSafe(int tab[9][9], int lin, int col, int num){
  return !presenteNaLinha(tab, lin, num) && !presenteNaColuna(tab, col, num) && !presenteNaCaixa(tab, lin - lin%3 , col - col%3, num);
}