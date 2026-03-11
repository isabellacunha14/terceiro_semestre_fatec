//
// Created by nava on 07/03/2026.
//
#include "Fila.h"

// Variáveis
int fila[TAMANHO];
int inicio = 0;
int fim = 0;

// Funções
bool adicionar(int valor) {
    if (fim == TAMANHO) {
        return false;
    }
    fila[fim] = valor;
    fim++;
    return true;
}

bool retirar(int *valor) {
    if (inicio == fim) {
        return false;
    }
    *valor = fila[inicio];
    inicio++;
    return true;
}
