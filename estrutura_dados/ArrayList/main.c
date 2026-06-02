#include <stdio.h>

#include "ArrayList.h"

// constantes
enum {
    OP_NAO_SELECIONADA = 0,
    OP_ADD,
    OP_SIZE,
    OP_BY_INDEX,
    OP_BY_VALUE,
    OP_DELETE,
    OP_SORT,
    OP_SET,
    OP_IMPRIMIR,
    OP_SAIR
};

// protótipos
int menu();
void imprimir();

int main(void) {
    int numero;
    int indice;
    int opcao = OP_NAO_SELECIONADA;

    init();

    while (opcao != OP_SAIR) {
        opcao = menu();
        switch (opcao) {
            case OP_ADD:
                printf("Digite um numero: ");
                scanf("%d", &numero);
                add(numero);
                break;
            case OP_SIZE:
                printf("Tamanho da lista: %llu\n", size());
                break;
            case OP_BY_VALUE:
                printf("Digite um numero: ");
                scanf("%d", &numero);
                if (searchByValue(numero, &indice)) {
                    printf("Encontrei %d no indice %d\n", numero, indice);
                } else {
                    printf("Nao encontrei %d\n", numero);
                }
                break;
            case OP_BY_INDEX:
                printf("Digite a posicao: ");
                scanf("%d", &indice);
                if (searchByIndex(indice, &numero)) {
                    printf("Encontrei %d no indice %d\n", numero, indice);
                } else {
                    printf("Indice invalido!\n");
                }
                break;
            case OP_DELETE:
                printf("Digite um numero: ");
                scanf("%d", &numero);
                delete(numero);
                break;
            case OP_SORT:
                sort();
                break;
            case OP_SET:
                printf("Digite um numero: ");
                scanf("%d", &numero);
                printf("Digite a posicao: ");
                scanf("%d", &indice);
                if (!set(indice, numero)) {
                    printf("Indice invalido!\n");
                }
                break;
            case OP_IMPRIMIR:
                imprimir();
                break;
            case OP_SAIR:
                break;
            default:
                printf("Opcao invalida!\n");
        }
    }
    destroy();

    return EXIT_SUCCESS;
}

int menu() {
    int op = OP_NAO_SELECIONADA;
    printf("Menu\n");
    printf("%d - Add\n", OP_ADD);
    printf("%d - Size\n", OP_SIZE);
    printf("%d - Search by Index\n", OP_BY_INDEX);
    printf("%d - Search by Value\n", OP_BY_VALUE);
    printf("%d - Delete\n", OP_DELETE);
    printf("%d - Sort\n", OP_SORT);
    printf("%d - Set\n", OP_SET);
    printf("%d - Imprimir\n", OP_IMPRIMIR);
    printf("%d - Sair\n", OP_SAIR);
    printf("Digite sua opcao: ");
    scanf("%d", &op);
    return op;
}

void imprimir() {
    for (int i = 0; i < posicao; i++) {
        printf("Lista[%d]: %d\n", i, Lista[i]);
    }
}
