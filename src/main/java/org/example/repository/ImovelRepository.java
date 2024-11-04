package org.example.repository;

import org.example.DatabaseConnection;
import org.example.model.Imovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ImovelRepository {

    //Método para buscar todos os imóveis ordenados por 'ultimo_contato'
    public List<Imovel> findAllByOrderByUltimoContatoDesc() {
        List<Imovel> imoveis = new ArrayList<>();

        String sql = "SELECT * FROM imoveis ORDER BY ultimo_contato DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setNomeImovel(rs.getString("nome_imovel"));
                imovel.setProprietario(rs.getString("proprietario"));
                imovel.setContato(rs.getString("contato"));
                imovel.setValor(rs.getDouble("valor"));
                imovel.setDataRegistro(rs.getString("data_registro"));
                imovel.setUltimoContato(rs.getString("ultimo_contato"));
                imovel.setCorretor(rs.getString("corretor"));
                imovel.setStatus(rs.getString("status"));
                imovel.setId(rs.getInt("id"));
                imoveis.add(imovel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return imoveis;
    }

    // Método para gerar um ID único
    private int gerarIdUnico(Connection conn) throws Exception {
        Random random = new Random();
        int idAleatorio;

        String verificarSql = "SELECT COUNT(*) FROM imoveis WHERE id = ?";
        boolean idExiste;
        do {
            idAleatorio = random.nextInt(1_000_000); // Gera um ID aleatório entre 0 e 999.999
            try (PreparedStatement ps = conn.prepareStatement(verificarSql)) {
                ps.setInt(1, idAleatorio);
                try (ResultSet rs = ps.executeQuery()) {
                    rs.next();
                    idExiste = rs.getInt(1) > 0; // Verifica se o ID já existe
                }
            }
        } while (idExiste);

        return idAleatorio;
    }

    // Método para salvar um imóvel no banco de dados
    public void save(Imovel imovel) {
        String sql = "INSERT INTO imoveis (nome_imovel, proprietario, contato, valor, data_registro, ultimo_contato, corretor, status, id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dataAtual = LocalDate.now().format(formatter);  // Formata a data atual como string
            // Gera um ID único usando o método
            int idUnico = gerarIdUnico(conn);


            ps.setString(1, imovel.getNomeImovel());
            ps.setString(2, imovel.getProprietario());
            ps.setString(3, imovel.getContato());
            ps.setDouble(4, imovel.getValor());
            ps.setString(5, dataAtual);
            ps.setString(6, dataAtual);
            ps.setString(7, imovel.getCorretor());
            ps.setString(8, imovel.getStatus());
            ps.setInt(9, idUnico);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateImovel(int id, Imovel imovel) {
        String sql = "UPDATE imoveis SET nome_imovel = ?, proprietario = ?, contato = ?, valor = ?, corretor = ?, ultimo_contato = ?, status = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dataAtual = LocalDate.now().format(formatter);  // Formata a data atual como string

            ps.setString(1, imovel.getNomeImovel());
            ps.setString(2, imovel.getProprietario());
            ps.setString(3, imovel.getContato());
            ps.setDouble(4, imovel.getValor());
            ps.setString(5, imovel.getCorretor());
            ps.setString(6, dataAtual);
            ps.setString(7, imovel.getStatus());
            ps.setInt(8, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
