public class Main {
    public static void main(String[] args) throws Exception {
        Fornecedor fornecedor = new Fornecedor("aa", 0);
        System.out.println(fornecedor.getNome());
        fornecedor.setNome("bb");
        System.out.println(fornecedor.getNome());
    }
}
