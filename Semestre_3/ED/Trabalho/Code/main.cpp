#include <ctime>
#include <string>
#include <string.h>
#include "Sudoku.hpp"
#include "saveFile.hpp"
#include "rules.hpp"

// ./main --generate 1
// ./main --remove Sudoku1 15
// ./main --solver Sudoku1_Puzzle

int main(int argc, char* argv[]){  
  srand(time(NULL));
  Sudoku *sudoku;

  // Caso - Gerar 
  if(strcmp(argv[1] , "--generate") == 0){
    Sudoku *sudoku[atoi(argv[2])];

    // Criando uma lista de sudoku
    for(int i = 0; i < atoi(argv[2]); i++){
      sudoku[i] = new Sudoku;
      sudoku[i]->criarSudoku();
    }
  }

  // Caso - Remover casas 
  if(strcmp(argv[1] , "--remove") == 0){
    int n = (int) atoi(argv[3]);
    char *filename = argv[2];

    FILE *arq = fopen(filename, "r");
    // lerMatriz --> solucionarTabela --> gravar_re
    sudoku->lerMatriz(arq, n, filename,1);
  }

  //Caso - Resolver 
  if(strcmp(argv[1] , "--solver") == 0){
    char *filename = argv[2];

    FILE *arq = fopen(filename, "r");
    // lerMatriz --> remover_casas --> gravar_so
    sudoku->lerMatriz(arq, 0, filename,2);
  }

  return 0;
}
