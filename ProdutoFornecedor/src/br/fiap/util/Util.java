package br.fiap.util;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

public class Util {

    private Fornecedor[] fornecedor = new Fornecedor[3];
    private Produto[] produto = new Produto[2 * fornecedor.length];
    private int indexFornecedor = 0;

    public void menuPrincipal() {
        int option = 0;
        String menu = "1.Cadastar Produto\n2.Pesquisar Poduto por nome\n3.Pesquisar Fornecedor por CNPJ\n4.Finalizar";
        System.out.println();

        do {
            option = parseInt(showInputDialog(menu));

            if (option < 1 || option > 4) {
                showMessageDialog(null, "Opcao Invalida");
            }

            switch (option) {
                case 1:
                    cadastrarProduto();
                    break;

                case 2:
                    pesquisarProduto();
                    break;

                case 3:
                    pesquisarFornecedor();
                    break;

                default:
                    break;
            }

        } while (option != 4);

    }

    // Antes de cadastrar um produto, o sistema deve perguntar o CNPJ do fornecedor.
    // Caso o fornecedor com esse CNPJ já esteja cadastrado, ele será utilizado na
    // composição do novo produto. Caso não esteja cadastrado, o programa deve
    // solicitar
    // o nome do fornecedor e cadastrar o novo fornecedor antes de continuar o
    // cadastro do produto.

    public void cadastrarProduto() {

        String nome;
        double valor;
        int qtdEstoque;
        Fornecedor fornecedor = pesquisarFornecedor();

        if (fornecedor == null) {
            cadastrarFornecedor();
        } else {
            nome = showInputDialog("Nome do Produto: ");
            valor = parseDouble(showInputDialog("Valor do Produto: "));
            qtdEstoque = parseInt(showInputDialog("Quantidade em estoque: "));

        }

    }

    public void cadastrarFornecedor() {
        String nome = showInputDialog("Nome do Fornecedor: ");
        long cnpj = parseLong(showInputDialog("CNPJ do Fornecedor: "));

    }

    public void pesquisarProduto() {

    }

    public Fornecedor pesquisarFornecedor() {
        long cnpj = parseLong(showInputDialog("Entre com o CNPJ do fornecedor: "));

        for (int i = 0; i < indexFornecedor; i++) {
            if (fornecedor[i].getCnpj() == cnpj) {
                return fornecedor[i];
            }
        }

        showMessageDialog(null, cnpj + " não encontrado.");
        return null;
    }

}
