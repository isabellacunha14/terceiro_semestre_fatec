//
// Created by marcos.nava on 18/04/2026.
//
#include "ArrayList.h"

#include <stdio.h>

// Constantes

// Variáveis
size_t tamanho = 5;
int posicao = 0;
int *Lista = NULL;

// Funções
void add(int valor) {
    if (posicao == tamanho) {
        expand();
    }
    Lista[posicao] = valor;
    posicao++;
}

size_t size() {
    return posicao;
}

bool searchByIndex(int indice, int *valor) {
    if (indice < 0 || indice >= posicao) {
        return false;
    }
    *valor = Lista[indice];
    return true;
}

bool searchByValue(int valor, int *indice) {
    for (int i = 0; i < posicao; i++) {
        if (Lista[i] == valor) {
            *indice = i;
            return true;
        }
    }
    return false;
}

void delete(int valor) {
    int i = 0;
    if (searchByValue(valor, &i)) {
        for (;i < posicao - 1; i++) {
            Lista[i] = Lista[i + 1];
        }
        posicao--;
    }
}

void sort() {
    int aux;
    for (int i = 0; i < posicao - 1; i++) {
        for (int j = i + 1; j < posicao; j++) {
            if (Lista[i] > Lista[j]) {
                aux = Lista[i];
                Lista[i] = Lista[j];
                Lista[j] = aux;
            }
        }
    }
}

bool set(int indice, int valor) {
    if (indice < 0 || indice >= posicao) {
        return false;
    }
    Lista[indice] = valor;
    return true;
}

void expand() {
    printf("Expandindo...\n");
    int *p;
    int novoTamanho = tamanho + 3;

    p = malloc(novoTamanho * sizeof(int));
    if (!p) {
        printf("Erro ao alocar memoria\n");
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < posicao; i++) {
        p[i] = Lista[i];
    }

    free(Lista);
    Lista = p;
    tamanho = novoTamanho;
}

void init() {
    Lista = malloc(tamanho * sizeof(int));
    if (!Lista) {
        printf("Erro ao alocar memoria\n");
        exit(EXIT_FAILURE);
    }
}

void destroy() {
    free(Lista);
}
