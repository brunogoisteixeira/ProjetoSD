package app.bruno.minhacasa;

public class ComodosCasa {
    private String nome;
    private int imagem;
    private String aparelhos;
    private String temperetura;

    public ComodosCasa(String nome, int imagem, String aparelhos, String temperetura) {
        this.nome = nome;
        this.imagem = imagem;
        this.aparelhos = aparelhos;
        this.temperetura = temperetura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getAparelhos() {
        return aparelhos;
    }

    public void setAparelhos(String aparelhos) {
        this.aparelhos = aparelhos;
    }

    public String getTemperetura() {
        return temperetura;
    }

    public void setTemperetura(String temperetura) {
        this.temperetura = temperetura;
    }
}
