#include <iostream>
#include <algorithm>
#include <ctime>
#include <cstdlib>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <list>
#include <string.h>
#include "Sudoku.hpp"
#include "saveFile.hpp"
#include "rules.hpp"

#define zero 0
using namespace std;

// Gera numeros aleatorios
int genRandNum(int maxLimit){
  return rand()%maxLimit;
}

Sudoku::Sudoku(){

  // Ordem aleatória de remoção da posições
  for(int i=0;i<81;i++){
    gridPos[i] = i;
  }

  random_shuffle(gridPos, (gridPos) + 81, genRandNum);

  // Ordem aleatória da matriz de número convidado
   for(int i=0;i<9;i++){
     guessNum[i]=i+1;
   }

  random_shuffle(guessNum, (guessNum) + 9, genRandNum);

  // Inicializando com 0
  for(int i=0;i<9;i++){
    for(int j=0;j<9;j++){
      grid[i][j]=0;
    }
  }

}

// Gerando tabela completa
void Sudoku::criarSudoku(){ 
  contruir_Sudoku();
  gravar(grid);
}

// Gerando a solucao da tabela completa
bool Sudoku::contruir_Sudoku(){
  int lin, col;

  // Se não tiver mais lugares vazios (0), sucesso!
  if (!encontraLugarVazio(grid, lin, col))
    return true; 

  // Ferifica os numeros 1 - 9
  for (int num = 0; num < 9; num++){

    // Verifica regras
    if (isSafe(grid, lin, col, guessNum[num])){

      // Coloca o numero provisoriamente como verdadeiro
      grid[lin][col] = guessNum[num];

      // Se numero aprovado, continua a construcao do sudoku
      if (contruir_Sudoku())
        return true;

      // Se numero reprovado, volta e tenta novamente
      grid[lin][col] = zero;
    }
  }
  
  return false; 
}

// Gerando a solucao da tabela completa
// Mesma logica de criacao, agora usada para solucionar
bool Sudoku::solucionarTabela(int tab[][9], char * name){
  int lin, col;
 
    // Se não tiver mais lugares vazios (0), sucesso!
    if (!encontraLugarVazio(tab, lin, col)){
        gravar_so(name, tab);
        return true;
    }
 
    // Verifica os numero 1 to 9
    for (int num = 1; num <= 9; num++){
         
        // Verifica regras
        if (isSafe(tab, lin, col, num)){

            // Aloca temporariamente
            tab[lin][col] = num;
 
            // Se numero aprovado, continua a construcao do sudoku
            if (solucionarTabela(tab, name)){
              return true;
            }
 
            // Se numero reprovado, volta e tenta novamente
            tab[lin][col] = 0;
        }
    }
    
  return false;     
}

// Removendo casas
void Sudoku::remover_casas(int n, int grid[][9], char* name){
  for(int i = 0;i < n;i++){
    int x = rand() % 9;     
    int y = rand() % 9;     

    // Caso casa ja esteja vazia: volta e tenta outra casa   
    if(grid[x][y] == 0){
      i--;
    }else{
      grid[x][y] = zero;
    }

  }

  // Gravando tabela
  gravar_re(name, grid);

}

// Ler matriz dos arquivos
void Sudoku::lerMatriz(FILE *arq, int n, char* name, int op){
  char c;
  int m[9][9];

  for(int i=0; i<9; i++){
    for(int j=0; j<9; j++){
      c = fgetc(arq);

      if(c == EOF){ /*ERRO*/ }

      if(c == '-'){   
        m[i][j] = '0';
      }else{
        m[i][j] = c;
      } 
    }

    c = fgetc(arq);
    if(c != '\n'){ /*ERRO*/ }
  }

  // Uso a variavel op para saber qual funcao foi chamada
  // 1 - remover_casas
  // 2 - solucionarTabela
  if(op == 1){
    remover_casas(n, m, name);
  }else{
    // Transformar os valores em int pois estao em char
    for(int i=0;i<9;i++){
      for(int j=0;j<9;j++){
        m[i][j] = m[i][j] - 48;
      }
    }

    solucionarTabela(m, name);
  }
}
