package org.example.repository;

import org.example.DatabaseConnection;
import org.example.model.Imovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImovelRepository {

    // Método para buscar todos os imóveis ordenados por 'ultimo_contato'
    public List<Imovel> findAllByOrderByUltimoContatoAsc() {
        List<Imovel> imoveis = new ArrayList<>();

        String sql = "SELECT * FROM imoveis ORDER BY ultimo_contato ASC";

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

                imoveis.add(imovel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return imoveis;
    }
}
