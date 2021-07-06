package br.com.feltex;

public class GerenciaArquivo {

    public static void main(String[] args) {
        manipularBucket();
        manipularArquivo();
    }

    private static void manipularBucket() {
        var operacoesS3 = new OperacoesS3(Credenciais.ACCESS_KEY, Credenciais.SECRET_KEY);
        var nomeBucket = "feltex-backup";
        operacoesS3.criarBucket(nomeBucket);
        operacoesS3.listarBuckets().forEach(System.out::println);
        operacoesS3.deletarBucket(nomeBucket);
    }

    private static void manipularArquivo() {
        var operacoesS3 = new OperacoesS3(Credenciais.ACCESS_KEY, Credenciais.SECRET_KEY);
        var nomeBucket = "feltex-fotos";
        var origemArquivo = "/home/teco/temp/s3/hino.jpg";
        var destinoArquivo = "fotos/hino.jpg";
        operacoesS3.enviarArquivo(nomeBucket, destinoArquivo, origemArquivo);
        operacoesS3.listarArquivos(nomeBucket).forEach(System.out::println);

        operacoesS3.deletarArquivo(nomeBucket, destinoArquivo);
        operacoesS3.listarArquivos(nomeBucket).forEach(System.out::println);
    }

}
