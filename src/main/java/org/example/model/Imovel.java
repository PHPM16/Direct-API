package org.example.model;

public class Imovel {
    private String nomeImovel;
    private String proprietario;
    private String contato;
    private double valor;
    private String dataRegistro;
    private String ultimoContato;
    private String corretor;
    private String status; // Novo atributo

    // Construtor
    public Imovel(String nomeImovel, String proprietario, String contato, double valor, String dataRegistro, String ultimoContato, String corretor) {
        this.nomeImovel = nomeImovel;
        this.proprietario = proprietario;
        this.contato = contato;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
        this.ultimoContato = ultimoContato;
        this.corretor = corretor;
        this.status = status; // Adicionando status
    }

    public Imovel() {

    }

    // Getters e Setters
    public String getNomeImovel() {
        return nomeImovel;
    }

    public void setNomeImovel(String nomeImovel) {
        this.nomeImovel = nomeImovel;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getUltimoContato() {
        return ultimoContato;
    }

    public void setUltimoContato(String ultimoContato) {
        this.ultimoContato = ultimoContato;
    }

    public String getCorretor() {
        return corretor;
    }

    public void setCorretor(String corretor) {
        this.corretor = corretor;
    }

    // Getters e Setters para status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Imovel [nomeImovel=" + nomeImovel + ", proprietario=" + proprietario + ", contato=" + contato +
                ", valor=" + valor + ", dataRegistro=" + dataRegistro + ", ultimoContato=" + ultimoContato +
                ", corretor=" + corretor + ", status=" + status + "]";
    }
}

