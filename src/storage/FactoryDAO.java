package storage;

/**
 * La classe FactoryDAO costruisce un oggetto di tipo ObjectDAO.
 * Questa classe permette di creare un oggetto di tipo ObjectDAO specificando quale tipo di DAO è in particolare.
 * @author Antonio Cimino
 * @version 1.0
 */
public class FactoryDAO {
	
	 /**
	  * Il metodo serve per costruire un oggetto DAO di una particolare tipologia.
	  * @return restituisce un oggetto DAO.
	  */
	public ObjectDAO getObject(String tipo){
		switch (tipo) {
		case "Studente" : return new StudenteDAOImp();
		case "Tutor" : return new TutorDAOImp();
		case "Domanda" : return new DomandaDAOImp();
		case "Risposta" : return new RispostaDAOImp();
		default : return null;
	}

