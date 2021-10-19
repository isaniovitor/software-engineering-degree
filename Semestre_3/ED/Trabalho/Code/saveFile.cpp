#include <iostream>

/** 
  Contem todas as todas as funcoes responsaveis por gravar as tabelas.

  Sao 3 ao todo
**/

// Responsavel por gravar os arquivos de solução
void gravar_so(char* nome, int tab[][9]){
  char filename[100];
  
  FILE *pArq = fopen(nome, "r");
  sprintf(filename, "%s_Solução", nome);

  if((pArq = fopen(filename, "w")) == 0x0) {
	  printf("erro.");
	  exit(1);
  }

  for(int i = 0; i < 9; i++) {
	  for(int j = 0; j < 9; j++){
        fprintf(pArq, "%d", tab[i][j]);
      }

    fprintf(pArq, "\n");
  }

  if(fclose(pArq)) {
	  printf("erro.");
	  exit(1);
  }

} 

//Responsavel por gravar os arquivos de remover
void gravar_re(char* nome, int tab[][9]){
  char filename[100];
  
  FILE *pArq = fopen(nome, "r");
  sprintf(filename, "%s_Puzzle", nome);

  if((pArq = fopen(filename, "w")) == 0x0) {
	  printf("erro.");
	  exit(1);
  }

  for(int i = 0; i < 9; i++) {
	  for(int j = 0; j < 9; j++) {
		  if(tab[i][j] == 0){
        fprintf(pArq, "%c", '-');
      }else{
        fprintf(pArq, "%c", tab[i][j]);
      }
    }

    fprintf(pArq, "\n");
  }

  if(fclose(pArq)) {
	  printf("erro.");
	  exit(1);
  }

} 

//Responsavel por gravar os arquivos de criar
int auxC = 0;
void gravar(int tab[][9]){
  char filename[100];
  FILE *pArq;

  auxC++;
  sprintf(filename, "Sudoku%d", auxC);

  if((pArq = fopen(filename, "w")) == 0x0) {
	  printf("erro.");
	  exit(1);
  }

  for(int i = 0; i < 9; i++) {
	  for(int j = 0; j < 9; j++){
        fprintf(pArq, "%d", tab[i][j]);
      }

    fprintf(pArq, "\n");
  }
  
  if(fclose(pArq)) {
	  printf("erro.");
	  exit(1);
  }

} 