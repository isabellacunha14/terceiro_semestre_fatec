//
// Created by nava on 21/02/2026.
//
#include "Pilha.h"

// Variáveis
int pilha[TAMANHO];
int posicao = 0;

// Funções
bool push(int valor) {
    if (posicao == TAMANHO) {
        return false;
    }
    pilha[posicao] = valor;
    posicao++;
    return true;
}

bool pop(int *valor) {
    if (posicao == 0) {
        return false;
    }
    posicao--;
    *valor = pilha[posicao];
    return true;
}
