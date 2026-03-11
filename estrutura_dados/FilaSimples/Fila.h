//
// Created by nava on 07/03/2026.
//

#ifndef FILASIMPLES_FILA_H
#define FILASIMPLES_FILA_H
#include <stdbool.h>

// Constantes
enum {
    TAMANHO = 5
};

// Variáveis
extern int fila[TAMANHO];
extern int inicio;
extern int fim;

// Protótipos
bool adicionar(int valor);
bool retirar(int *valor);

#endif //FILASIMPLES_FILA_H