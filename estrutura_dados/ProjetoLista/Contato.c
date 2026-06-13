#include <stdio.h>
#include <string.h>
#include "Contato.h"

void inicializar(Lista *l) {
    l->tamanho = 0;
}

int buscar(Lista *l, char *cpf) {
    for (int i = 0; i < l->tamanho; i++)
        if (strcmp(l->dados[i].cpf, cpf) == 0)
            return i;
    return -1;
}

void adicionar(Lista *l) {
    Contato c;
    printf("CPF: ");
    scanf(" %[^\n]", c.cpf);

    if (buscar(l, c.cpf) != -1) {
        printf("CPF ja cadastrado.\n");
        return;
    }

    printf("Nome: ");
    scanf(" %[^\n]", c.nome);
    printf("Endereco: ");
    scanf(" %[^\n]", c.endereco);
    printf("Telefone: ");
    scanf(" %[^\n]", c.telefone);
    printf("Email: ");
    scanf(" %[^\n]", c.email);

    l->dados[l->tamanho++] = c;
    printf("Cadastrado com sucesso.\n");
}

void excluir(Lista *l) {
    char cpf[15];
    printf("CPF: ");
    scanf(" %[^\n]", cpf);

    int idx = buscar(l, cpf);
    if (idx == -1) return;

    for (int i = idx; i < l->tamanho - 1; i++)
        l->dados[i] = l->dados[i + 1];
    l->tamanho--;
}

void alterar(Lista *l) {
    char cpf[15], buf[150];
    printf("CPF: ");
    scanf(" %[^\n]", cpf);

    int idx = buscar(l, cpf);
    if (idx == -1) {
        printf("CPF nao cadastrado.\n");
        return;
    }

    Contato *c = &l->dados[idx];
    printf("Deixe em branco para manter o valor atual.\n");

    printf("Nome [%s]: ", c->nome);
    scanf(" %[^\n]", buf);
    if (strlen(buf) > 0) strcpy(c->nome, buf);

    printf("Endereco [%s]: ", c->endereco);
    scanf(" %[^\n]", buf);
    if (strlen(buf) > 0) strcpy(c->endereco, buf);

    printf("Telefone [%s]: ", c->telefone);
    scanf(" %[^\n]", buf);
    if (strlen(buf) > 0) strcpy(c->telefone, buf);

    printf("Email [%s]: ", c->email);
    scanf(" %[^\n]", buf);
    if (strlen(buf) > 0) strcpy(c->email, buf);

    printf("Alterado com sucesso.\n");
}

void imprimir(Lista *l) {
    char cpf[15];
    printf("CPF: ");
    scanf(" %[^\n]", cpf);

    int idx = buscar(l, cpf);
    if (idx == -1) {
        printf("CPF nao cadastrado.\n");
        return;
    }

    Contato *c = &l->dados[idx];
    printf("Nome: %s\n", c->nome);
    printf("Endereco: %s\n", c->endereco);
    printf("CPF: %s\n", c->cpf);
    printf("Telefone: %s\n", c->telefone);
    printf("Email: %s\n", c->email);
}

void imprimir_todos(Lista *l) {
    if (l->tamanho == 0) {
        printf("Nenhum registro.\n");
        return;
    }
    for (int i = 0; i < l->tamanho; i++) {
        Contato *c = &l->dados[i];
        printf("\n[%d] Nome: %s | CPF: %s | End: %s | Tel: %s | Email: %s\n",
            i + 1, c->nome, c->cpf, c->endereco, c->telefone, c->email);
    }
}

void ordenar(Lista *l) {
    for (int i = 0; i < l->tamanho - 1; i++)
        for (int j = 0; j < l->tamanho - 1 - i; j++)
            if (strcmp(l->dados[j].nome, l->dados[j+1].nome) > 0) {
                Contato tmp = l->dados[j];
                l->dados[j] = l->dados[j+1];
                l->dados[j+1] = tmp;
            }
    printf("Lista ordenada por nome.\n");
}
