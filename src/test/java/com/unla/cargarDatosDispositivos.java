package com.unla;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class cargarDatosDispositivos {

    public static void main(String[] args) {
        JdbcTemplate  jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        //jdbcTemplate.update("insert into banios(id_dispositivo, num_banios) values (2,2);");
        jdbcTemplate.update("update banios set cerrojo=false where id_dispositivo=1");

//        Edificio e = new Edificio();
//        Banios b = new Banios("baño", true, e, 2);
//        e.getDispositivos().add(b);
//        dispositivoService.insertOrUpdate(b);
//
//        b.cambiarEstadoCerrojo(); //deberia registrar un evento
//        System.out.println(e);
    }

    private static DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/bd-grupo23-oo2");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }




}
