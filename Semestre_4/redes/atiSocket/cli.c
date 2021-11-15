#include <netdb.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <arpa/inet.h>    // htons(), inet_addr()
#define MAX 80
#include <unistd.h> // for close
#define SA struct sockaddr

int main(){
	int network_socket;
	network_socket = socket(AF_INET, SOCK_STREAM, 0);
	
	if(network_socket == -1){
		printf("Falha em criar o socket.\n");
		exit(0);
	}else{
		printf("Socket criado com sucesso.\n");
	}
	
	struct sockaddr_in server_address;
	server_address.sin_family = AF_INET;
	server_address.sin_port = htons(7658);
	
	bzero(&server_address, sizeof(server_address));
	
	char ip[16];
	printf("Informe o endereco IP: ");
	scanf("%s", ip);
	server_address.sin_addr.s_addr = inet_addr(ip);
	
	int connection_status = connect(network_socket, (struct sockaddr *) &server_address, sizeof(server_address));
	
	if(connection_status != 0){
		printf("Erro ao tentar conectar o socket remoto \n\n");
	}else{
		printf("Conectado.\n");
	}
	
	close(network_socket);
	
	return 0;
}