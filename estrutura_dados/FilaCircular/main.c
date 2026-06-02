#include <stdio.h>

#include "Fila.h"

// Constantes
enum {
    OP_NAO_SELECIONADA = 0,
    OP_ADICIONAR,
    OP_RETIRAR,
    OP_LISTAR,
    OP_SAIR
};

// Protótipos
int menu();
void listar();

int main(void) {
    int opcao = OP_NAO_SELECIONADA;
    int numero = 0;

    while (opcao != OP_SAIR) {
        opcao = menu();
        switch (opcao) {
            case OP_ADICIONAR:
                printf("Digite um numero: ");
                scanf("%d", &numero);
                if (!adicionar(numero)) {
                    printf("Fila cheia!\n");
                }
                break;
            case OP_RETIRAR:
                if (retirar(&numero)) {
                    printf("Retirei %d da fila.\n", numero);
                }
                else {
                    printf("Fila vazia!\n");
                }
                break;
            case OP_LISTAR:
                listar();
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
    int op = OP_NAO_SELECIONADA;
    printf("Menu\n");
    printf("%d - Adicionar\n", OP_ADICIONAR);
    printf("%d - Retirar\n", OP_RETIRAR);
    printf("%d - Listar\n", OP_LISTAR);
    printf("%d - Sair\n", OP_SAIR);
    printf("Digite sua opcao: ");
    scanf("%d", &op);
    return op;
}

void listar() {
    int i = inicio;
    if (vazia) {
        printf("Fila vazia!\n");
    } else {
        do {
            printf("%d < ", fila[i]);
            i++;
            if (i == TAMANHO) {
                i = 0;
            }
        } while (i != fim);
        printf("\n");
    }
}