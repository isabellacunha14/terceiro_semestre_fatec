#include <stdio.h>
#include "ProjetoPilha.h"
#include "ProjetoPilha.c"



int main(void) {
    char expressao[TAMANHO];

    printf("Digite a expressao: ");
    fgets(expressao, 25, stdin);

    char caracter;

    for (int i = 0; expressao[i] != '\0'; i++) {

        switch (expressao[i]) {

            // símbolos de abertura
            case '(':
            case '[':
            case '{':
                push(expressao[i]);
            break;

            // símbolos de fechamento
            case ')':
            case ']':
            case '}':
                if (!pop(&caracter)) {
                    printf("Nao balanceada\n");
                    return 0;
                }

            if ((expressao[i] == ')' && caracter != '(') ||
                (expressao[i] == ']' && caracter != '[') ||
                (expressao[i] == '}' && caracter != '{')) {

                printf("Nao balanceada\n");
                return 0;
                }

            break;
        }
    }

    if (posicao == 0)
        printf("Balanceada\n");
    else
        printf("Nao balanceada\n");

}