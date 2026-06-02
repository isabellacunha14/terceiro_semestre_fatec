//
// Created by nava on 14/03/2026.
//

#include "Fila.h"
// Variáveis
int fila[TAMANHO];
int inicio = 0;
int fim = 0;
bool vazia = true;

// Funções
bool adicionar(int valor) {
    if (vazia) {
        fila[fim] = valor;
        vazia = false;
        fim++;
        if (fim == TAMANHO) {
            fim = 0;
        }
    } else {
        if (inicio == fim) {
            return false;
        }
        fila[fim] = valor;
        fim++;
        if (fim == TAMANHO) {
            fim = 0;
        }
    }
    return true;
}

bool retirar(int *valor) {
    if (vazia) {
        return false;
    }
    *valor = fila[inicio];
    inicio++;
    if (inicio == TAMANHO) {
        inicio = 0;
    }
    if (inicio == fim) {
        vazia = true;
    }
    return true;
}
