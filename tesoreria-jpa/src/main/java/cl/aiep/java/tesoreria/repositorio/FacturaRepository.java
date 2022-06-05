package cl.aiep.java.tesoreria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.tesoreria.modelo.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
