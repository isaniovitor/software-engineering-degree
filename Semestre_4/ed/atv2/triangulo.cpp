#include <iostream>

void printt(int ar[]){
	printf("[");

    for(int i = 0; i < ar.lenght; i++){
        printf(ar[i]);
    }

    printf("]");
}

void modifica(int ar[]){
	printt(ar);

	int new_vet[1000];

	
	
}

int main() {
    int vet[1000];
	int size = 0;
	int value = 0;
	
	//enquanto conseguir ler valores antes de chegar no fim do arquivo
	while(scanf("%d", &value) > 0) 
	    vet[size++] = value;

	modifica(vet);
	

	
    return 0;
}