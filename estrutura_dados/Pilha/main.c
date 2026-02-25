#include <stdio.h>
#include "Pilha.h"

// Constantes
enum {
    OP_NAO_SELECIONADA = 0,
    OP_PUSH,
    OP_POP,
    OP_SAIR
};

// Protótipos
int menu();

int main(void) {
    int opcao = OP_NAO_SELECIONADA;
    int numero;

    while (opcao != OP_SAIR) {
        opcao = menu();
        switch (opcao) {
            case OP_PUSH:
                printf("Digite um numero: ");
                scanf("%d", &numero);
                if (!push(numero)) {
                    printf("Estouro de pilha!\n");
                }
                break;
            case OP_POP:
                if (pop(&numero)) {
                    printf("Retirado %d da pilha.\n", numero);
                }
                else {
                    printf("Pilha vazia!\n");
                }
                break;
            case OP_SAIR:
                break;
            default:
                printf("Opcao invalida!\n");
        }
    }
    return 0;
}

int menu() {
    int op;

    printf("Menu\n");
    printf("%d - Push\n", OP_PUSH);
    printf("%d - Pop\n", OP_POP);
    printf("%d - Sair\n", OP_SAIR);
    printf("Digite sua opcao: ");
    scanf("%d", &op);

    return op;
}