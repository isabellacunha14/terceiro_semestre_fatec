//
// Created by marcos.nava on 18/04/2026.
//

#ifndef ARRAYLIST_ARRAYLIST_H
#define ARRAYLIST_ARRAYLIST_H
#include <stdbool.h>
#include <stdlib.h>

// Variáveis
extern size_t tamanho;
extern int posicao;
extern int *Lista;

// Funções
void add(int valor);
size_t size();
bool searchByIndex(int indice, int *valor);
bool searchByValue(int valor, int *indice);
void delete(int valor);
void sort();
bool set(int indice, int valor);
void expand();
void init();
void destroy();
#endif //ARRAYLIST_ARRAYLIST_H
