#include <stdio.h>
#include "Contato.h"

int main() {
    Lista l;
    inicializar(&l);
    int opcao;

    do {
        printf("\n1. Adicionar\n2. Excluir\n3. Alterar\n4. Imprimir\n5. Imprimir todos\n6. Ordenar\n7. Sair\nOpcao: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1: adicionar(&l);     break;
            case 2: excluir(&l);       break;
            case 3: alterar(&l);       break;
            case 4: imprimir(&l);      break;
            case 5: imprimir_todos(&l); break;
            case 6: ordenar(&l);       break;
            case 7: printf("Saindo...\n"); break;
            default: printf("Opcao invalida.\n");
        }
    } while (opcao != 7);

    return 0;
}
