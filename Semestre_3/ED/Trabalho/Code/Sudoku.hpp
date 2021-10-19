class Sudoku {

public:
  int grid[9][9];
  int guessNum[9];
  int gridPos[81];
  std::string nomes[100];

public:
  Sudoku();
  void criarSudoku();
  bool contruir_Sudoku();
  void remover_casas(int n, int grid[9][9], char* name);
  bool solucionarTabela(int m[][9], char * name);
  void lerMatriz(FILE *arquivo, int n, char* name, int op);
};