#ifndef CONTATO_H
#define CONTATO_H

#define MAX 100

typedef struct {
    char nome[100];
    char endereco[150];
    char cpf[15];
    char telefone[20];
    char email[100];
} Contato;

typedef struct {
    Contato dados[MAX];
    int tamanho;
} Lista;

void inicializar(Lista *l);
int buscar(Lista *l, char *cpf);
void adicionar(Lista *l);
void excluir(Lista *l);
void alterar(Lista *l);
void imprimir(Lista *l);
void imprimir_todos(Lista *l);
void ordenar(Lista *l);

#endif