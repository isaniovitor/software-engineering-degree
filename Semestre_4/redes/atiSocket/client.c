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
    int sockfd, connfd;
    char IP[61];
    struct sockaddr_in servaddr, cli;
   
    while(1){
  
        //get IP. EX: 127.0.0.1
        //nao valido o ip, pode haver erros
        printf("Digite o IP: ");
        scanf("%s", IP);

        // socket create and varification
        sockfd = socket(AF_INET, SOCK_STREAM, 0);
        if (sockfd == -1) {
            printf("socket creation failed...\n");
            exit(0);
        }
        else
            printf("Socket successfully created..\n");
            
        bzero(&servaddr, sizeof(servaddr));
    
        // assign IP, PORT
        try{
            
        }
        servaddr.sin_family = AF_INET;
        servaddr.sin_addr.s_addr = inet_addr(IP); //inet_addr("127.0.0.1");
        servaddr.sin_port = htons(9001);
    
        // connect the client socket to server socket
        int con = connect(sockfd, (SA*)&servaddr, sizeof(servaddr));
        if (con != 0) {
            printf("connection with the server failed...\n");
            exit(0);
        }
        else
            printf("connected to the server..\n");
    
        // close the socket
        close(sockfd);
        printf("connection closed..\n");
    }
}