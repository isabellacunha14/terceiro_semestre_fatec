#ifndef FILA_H
#define FILA_H

#include <stdbool.h>


enum {
    TAMANHO = 5
};


typedef struct {
    int id;
    char nome_arquivo[50];
    int num_paginas;
} TrabalhoImpressao;


extern TrabalhoImpressao fila[TAMANHO];
extern int inicio;
extern int fim;
extern bool vazia;


bool adicionar(TrabalhoImpressao t);
bool retirar(TrabalhoImpressao *t);

#endif