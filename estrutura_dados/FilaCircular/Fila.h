//
// Created by nava on 14/03/2026.
//

#ifndef FILACIRCULAR_FILA_H
#define FILACIRCULAR_FILA_H
#include <stdbool.h>

// Constantes
enum {
    TAMANHO = 5
};

// Variáveis
extern int fila[TAMANHO];
extern int inicio;
extern int fim;
extern bool vazia;

// Protótipos
bool adicionar(int valor);
bool retirar(int *valor);

#endif //FILACIRCULAR_FILA_H