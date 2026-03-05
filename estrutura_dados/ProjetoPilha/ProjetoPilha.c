//
// Created by user on 05/03/2026.
//
#include "ProjetoPilha.h"

// Variáveis
int pilha[TAMANHO];
int posicao = 0;

// Funções
bool push(char valor) {

    if (posicao == TAMANHO) {
        return false;
    }

    pilha[posicao] = valor;
    posicao++;

    return true;
}

bool pop(char *valor) {

    if (posicao == 0) {
        return 0;
    }

    posicao--;
    *valor = pilha[posicao];

    return 1;
}