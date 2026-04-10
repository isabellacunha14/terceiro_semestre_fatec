#include <stdio.h>
#include <string.h>
#include "Fila.h"

// Constantes
enum {
    OP_NAO_SELECIONADA = 0,
    OP_ADICIONAR,
    OP_PROCESSAR,
    OP_LISTAR,
    OP_SAIR
};

// Protótipos
int menu();
void listar();

int main() {
    int opcao = OP_NAO_SELECIONADA;
    int proximo_id = 1;
    TrabalhoImpressao t;

    while (opcao != OP_SAIR) {
        opcao = menu();

        switch (opcao) {
            case OP_ADICIONAR:
                t.id = proximo_id++;

                printf("Nome do arquivo: ");
                scanf(" %[^\n]", t.nome_arquivo);

                printf("Numero de paginas: ");
                scanf("%d", &t.num_paginas);

                if (!adicionar(t)) {
                    printf("Fila cheia!\n");
                } else {
                    printf("Trabalho adicionado!\n");
                }
                break;

            case OP_PROCESSAR:
                if (retirar(&t)) {
                    printf("\nProcessando trabalho:\n");
                    printf("ID: %d\n", t.id);
                    printf("Arquivo: %s\n", t.nome_arquivo);
                    printf("Paginas: %d\n", t.num_paginas);
                } else {
                    printf("Fila vazia!\n");
                }
                break;

            case OP_LISTAR:
                listar();
                break;

            case OP_SAIR:
                printf("Encerrando...\n");
                break;

            default:
                printf("Opcao invalida!\n");
        }
    }

    return 0;
}

// Menu
int menu() {
    int op;
    printf("\nMENU\n");
    printf("1 - Adicionar trabalho\n");
    printf("2 - Processar trabalho\n");
    printf("3 - Listar fila\n");
    printf("4 - Sair\n");
    printf("Opcao: ");
    scanf("%d", &op);
    return op;
}

// Listar fila
void listar() {
    int i = inicio;

    if (vazia) {
        printf("Fila vazia!\n");
    } else {
        do {
            printf("\nID: %d", fila[i].id);
            printf("\nArquivo: %s", fila[i].nome_arquivo);
            printf("\nPaginas: %d\n", fila[i].num_paginas);

            i++;
            if (i == TAMANHO) {
                i = 0;
            }

        } while (i != fim);
    }
}