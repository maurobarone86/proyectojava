package dao;

import javax.persistence.Query;

import JPAUtil.Conexion;
import entities.Servicio;

public class ServicioDAOImpl extends GenericDAOImpl<Servicio> implements ServicioDAO{

	public ServicioDAOImpl(Class<Servicio> clase) {
		super(clase);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void borradoLogico(Servicio entity) {
		entity=	this.recuperar(entity.getId());
		entity.setActivo(false);
		this.actualizar(entity);
	}
	
	@Override
	public Servicio obtenerServicio(String dato) {
		Servicio ser=new Servicio();
		ser.setNombre(dato);
		return super.existe(ser);
	}
	
	public void save(Servicio servicio) throws Exception {
		super.save(servicio);
	}
	public Query makeQuery(Servicio ser) {
		Query q = Conexion.getManager().createQuery("SELECT s FROM Servicio s WHERE s.nombre = :nombre AND s.activo = :activo");
		q.setParameter("nombre",ser.getNombre());
		q.setParameter("activo",Boolean.TRUE);
		return q;
	}
}
