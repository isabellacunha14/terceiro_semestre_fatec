#ifndef FILA_H
#define FILA_H

#include <stdbool.h>

// Constante
enum {
    TAMANHO = 5
};

// Struct do trabalho
typedef struct {
    int id;
    char nome_arquivo[50];
    int num_paginas;
} TrabalhoImpressao;

// Variáveis globais
extern TrabalhoImpressao fila[TAMANHO];
extern int inicio;
extern int fim;
extern bool vazia;

// Protótipos
bool adicionar(TrabalhoImpressao t);
bool retirar(TrabalhoImpressao *t);

#endif