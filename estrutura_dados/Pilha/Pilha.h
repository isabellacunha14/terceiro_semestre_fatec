//
// Created by nava on 21/02/2026.
//

#ifndef PILHA_PILHA_H
#define PILHA_PILHA_H
#include <stdbool.h>

// Constantes
enum {
    TAMANHO = 5
};

// Variáveis
extern int pilha[TAMANHO];
extern int posicao;

// Protótipos
bool push(int valor);
bool pop(int *valor);

#endif //PILHA_PILHA_H