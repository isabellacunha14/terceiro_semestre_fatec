#include "Fila.h"

// Variáveis
TrabalhoImpressao fila[TAMANHO];
int inicio = 0;
int fim = 0;
bool vazia = true;

// Adicionar trabalho
bool adicionar(TrabalhoImpressao t) {
    if (vazia) {
        fila[fim] = t;
        vazia = false;
        fim++;
        if (fim == TAMANHO) {
            fim = 0;
        }
    } else {
        if (inicio == fim) {
            return false; // cheia
        }
        fila[fim] = t;
        fim++;
        if (fim == TAMANHO) {
            fim = 0;
        }
    }
    return true;
}

// Retirar trabalho
bool retirar(TrabalhoImpressao *t) {
    if (vazia) {
        return false;
    }

    *t = fila[inicio];

    inicio++;
    if (inicio == TAMANHO) {
        inicio = 0;
    }

    if (inicio == fim) {
        vazia = true;
    }

    return true;
}