/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DentaSoft.Persistencia;

import DentaSoft.Dominio.Dentista;
import DentaSoft.Dominio.HorarioAtencion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author estdi
 */
public class HorarioPostgreSQL {

    private AccesoDatosJDBC accesoDatosJDBC;

    public HorarioPostgreSQL(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
//        this.MedicoPostgreSQL = new MedicoPostgreSQL(accesoDatosJDBC);
    }

    public void guardar(HorarioAtencion horario) throws Exception {
        String insertSQL = "insert into horario(idhorario,  horainicio, horafin, estado, iddentista)"
                + "values(?,?,?,?,?)";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setString(1, horario.getIdhorario());
            sentencia.setTime(2, Time.valueOf(horario.getHoraInicio()));
            sentencia.setTime(3, Time.valueOf(horario.getHoraFin()));
            sentencia.setString(4, horario.getEstado());
            sentencia.setInt(5, horario.getDentista().getIddentista());
            sentencia.executeUpdate();
        } catch (Exception e) {
            throw new Exception("ERROR AL INTENTAR GUARDAR HORARIO", e);
        }
    }

    public HorarioAtencion buscar(String idHorario, int idDentista) throws Exception {
        String consultaSQL = "select h.horainicio,h.horafin,h.estado,d.nombres from horario h "
                + " join dentista d on d.iddentista=h.iddentista "
                + " where h.estado='A' and h.idhorario = ? and h.iddentista = ?";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, idHorario);
            sentencia.setInt(2, idDentista);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {

                Dentista dentista = new Dentista();
                dentista.setNombres(resultado.getString("nombres"));
                dentista.setIddentista(idDentista);

                HorarioAtencion horario = new HorarioAtencion();
                horario.setIdhorario(idHorario);
                horario.setHoraInicio(resultado.getTime("horainicio").toLocalTime());
                horario.setHoraFin(resultado.getTime("horafin").toLocalTime());
                horario.setEstado(resultado.getString("estado"));
                horario.setDentista(dentista);
                return horario;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception("ERROR AL INTENTAR BUSCAR EL HORARIO", e);
        }
    }

//    public List<String> obtenerHoras(HorarioAtencion horario) throws Exception {
//
//        String consultaSQL = "select idhorario, horainicio, horafin, estado from horario where fecha = ? ";
//        PreparedStatement sentencia;
//        List<String> horas = new ArrayList<>();
//        try {
//
//            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
//            sentencia.setString(1, horario.getFecha());
//            ResultSet resultado = sentencia.executeQuery();
//            while (resultado.next()) {
//                horas.add(resultado.getString(1));
//                horas.add(resultado.getString(2));
//
//            }
//        } catch (Exception e) {
//            System.out.println("error metodo obetener horas");
//            throw new Exception("ERROR AL VERIFICAR SI EXISTE EL HORARIO");
//        }
//        return horas;
//    }
//
    public List<HorarioAtencion> mostrarHorarios() throws SQLException {

        String mostraSQL = "select h.*,d.nombres from horario h join dentista d on d.iddentista=h.iddentista where estado='A'";
        PreparedStatement sentencia;

        List<HorarioAtencion> lista = new ArrayList<>();

        try {
            sentencia = accesoDatosJDBC.prepararSentencia(mostraSQL);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Dentista dentista = new Dentista();
                dentista.setNombres(resultado.getString("nombres"));
                dentista.setIddentista(resultado.getInt("iddentista"));

                HorarioAtencion horarioAtencion = new HorarioAtencion(
                        resultado.getString("idhorario"),
                        resultado.getTime("horainicio").toLocalTime(),
                        resultado.getTime("horafin").toLocalTime(),
                        resultado.getString("estado"), dentista);
                String codigo = resultado.getString("idhorario");

                lista.add(horarioAtencion);
            }
            return lista;
        } catch (SQLException e) {
            throw new SQLException("ERROR AL INTENTAR BUSCAR EL HORARIO.", e);
        }
    }

    public List<HorarioAtencion> mostrarHorarios(int documentoDentista) throws SQLException {

        String mostraSQL = "select h.*,d.nombres from horario h join dentista d on d.iddentista=h.iddentista where estado='A' and d.dni=?";
        PreparedStatement sentencia;

        List<HorarioAtencion> lista = new ArrayList<>();

        try {
            sentencia = accesoDatosJDBC.prepararSentencia(mostraSQL);
            sentencia.setInt(1, documentoDentista);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Dentista dentista = new Dentista();
                dentista.setNombres(resultado.getString("nombres"));
                dentista.setIddentista(resultado.getInt("iddentista"));

                HorarioAtencion horarioAtencion = new HorarioAtencion(
                        resultado.getString("idhorario"),
                        resultado.getTime("horainicio").toLocalTime(),
                        resultado.getTime("horafin").toLocalTime(),
                        resultado.getString("estado"), dentista);
                String codigo = resultado.getString("idhorario");

                lista.add(horarioAtencion);
            }
            return lista;
        } catch (SQLException e) {
            throw new SQLException("ERROR AL INTENTAR BUSCAR EL HORARIO.", e);
        }
    }

}
