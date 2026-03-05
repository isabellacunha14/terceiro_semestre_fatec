//
// Created by user on 05/03/2026.
//

#ifndef PROJETOPILHA_H
#define PROJETOPILHA_H
#include <stdbool.h>

// Constantes
enum {
    TAMANHO = 25
};

// Variáveis
extern int pilha[TAMANHO];
extern int posicao;

// Protótipos
bool push(char valor);
bool pop(char *valor);

#endif //PROJETOPILHA_H
